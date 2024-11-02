package com.example.gestordecorreos;

import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

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

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        GrpsServiceProto.SolicitudCorreo solicitud = GrpsServiceProto.SolicitudCorreo.newBuilder()
                .setRemitente(REMITENTE_PREDETERMINADO)
                .setDestinatario(destinatario)
                .setAsunto(asunto)
                .setCuerpo(cuerpo)
                .build();

        try {
            GrpsServiceProto.Respuesta respuesta = stubBloqueante.enviarCorreo(solicitud);
            System.out.println("Correo enviado:");
            System.out.println(String.format("De: %s\nPara: %s\nAsunto: %s\nMensaje: %s\n",
                    REMITENTE_PREDETERMINADO, destinatario, asunto, cuerpo));
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public void verCorreosRecibidos() {
            // Configura el destinatario predeterminado del cliente
        String destinatario = REMITENTE_PREDETERMINADO;  // tu propio correo

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
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Para: ");
                    String destinatario = scanner.nextLine();
                    System.out.print("Asunto: ");
                    String asunto = scanner.nextLine();
                    System.out.print("Mensaje: ");
                    String cuerpo = scanner.nextLine();
                    cliente.enviarCorreo(destinatario, asunto, cuerpo);
                    break;

                case 2:
                    cliente.verCorreosRecibidos();
                    break;

                case 3:
                    cliente.verCorreosEnviados();
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
