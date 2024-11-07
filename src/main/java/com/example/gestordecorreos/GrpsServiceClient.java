package com.example.gestordecorreos;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrpsServiceClient {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;
    private static final String REMITENTE_PREDETERMINADO = "rodrigoUCP@gmail.com";

    public GrpsServiceClient(String host, int puerto) {
        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, puerto)
                .usePlaintext()
                .build();
        stubBloqueante = GrpsServiceGrpc.newBlockingStub(canal);
    }

    public void enviarCorreo(List<String> destinatarios, String grupo, String asunto, String cuerpo) {
        // Construir la solicitud de correo
        GrpsServiceProto.SolicitudCorreo.Builder solicitudBuilder = GrpsServiceProto.SolicitudCorreo.newBuilder()
                .setRemitente(REMITENTE_PREDETERMINADO)
                .setAsunto(asunto)
                .setCuerpo(cuerpo);

        // Verificar si se debe enviar a un grupo o a destinatarios individuales
        if (!grupo.isEmpty()) {
            solicitudBuilder.setGrupo(grupo);
            System.out.println("Enviando correo al grupo: " + grupo);
        } else {
            solicitudBuilder.addAllDestinatarios(destinatarios);
            System.out.println("Enviando correo a los destinatarios individuales: " + destinatarios);
        }

        // Crear la solicitud final
        GrpsServiceProto.SolicitudCorreo solicitud = solicitudBuilder.build();
        
        // Enviar la solicitud y obtener la respuesta
        try {
            GrpsServiceProto.Respuesta respuesta = stubBloqueante.enviarCorreo(solicitud);
            if (respuesta.getExito()) {
                System.out.println("Correo enviado exitosamente.");
            } else {
                System.out.println("No se pudo enviar el correo.");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public void verCorreosRecibidos() {
        String destinatario = REMITENTE_PREDETERMINADO;
        GrpsServiceProto.SolicitudBandeja solicitud = GrpsServiceProto.SolicitudBandeja.newBuilder()
                .setDestinatario(destinatario)
                .build();

        try {
            GrpsServiceProto.RespuestaBandeja respuesta = stubBloqueante.obtenerBandejaEntrada(solicitud);
            System.out.println("Correos recibidos para " + destinatario + ":");
            for (GrpsServiceProto.Correo correo : respuesta.getCorreosList()) {
                System.out.println("De: " + correo.getRemitente());
                System.out.println("Asunto: " + correo.getAsunto());
                System.out.println("Mensaje: " + correo.getCuerpo());
                System.out.println("----------------------------");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public void verCorreosEnviados() {
        GrpsServiceProto.SolicitudEnviados solicitud = GrpsServiceProto.SolicitudEnviados.newBuilder()
                .setRemitente(REMITENTE_PREDETERMINADO)
                .build();

        try {
            GrpsServiceProto.RespuestaEnviados respuesta = stubBloqueante.obtenerCorreosEnviados(solicitud);
            System.out.println("Correos enviados por " + REMITENTE_PREDETERMINADO + ":");
            for (GrpsServiceProto.Correo correo : respuesta.getCorreosList()) {
                System.out.println("Para: " + correo.getDestinatario());
                System.out.println("Asunto: " + correo.getAsunto());
                System.out.println("Mensaje: " + correo.getCuerpo());
                System.out.println("----------------------------");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public static void main(String[] args) {
        GrpsServiceClient cliente = new GrpsServiceClient("localhost", 50051);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Enviar un correo");
            System.out.println("2. Ver correos recibidos");
            System.out.println("3. Ver correos enviados");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Enviar a un grupo? (s/n): ");
                    String enviarAGrupo = scanner.nextLine();
                    List<String> destinatarios = new ArrayList<>();
                    String grupo = "";

                    if (enviarAGrupo.equalsIgnoreCase("s")) {
                        System.out.print("Nombre del grupo: ");
                        grupo = scanner.nextLine();
                        System.out.print("Ingrese los destinatarios separados por coma: ");
                        String[] destArray = scanner.nextLine().split(",");
                        for (String dest : destArray) {
                            destinatarios.add(dest.trim());
                        }
                    } else {
                        System.out.print("Para: ");
                        String destinatario = scanner.nextLine();
                        destinatarios.add(destinatario);
                    }

                    System.out.print("Asunto: ");
                    String asunto = scanner.nextLine();
                    System.out.print("Mensaje: ");
                    String cuerpo = scanner.nextLine();

                    cliente.enviarCorreo(destinatarios, grupo, asunto, cuerpo);
                    break;

                case 2:
                    cliente.verCorreosRecibidos();
                    break;

                case 3:
                    cliente.verCorreosEnviados();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
