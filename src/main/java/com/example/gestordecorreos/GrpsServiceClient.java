package com.example.gestordecorreos;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

public class GrpsServiceClient {

    // Cliente gRPC de tipo bloqueante, usado para realizar llamadas síncronas al servidor
    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;
    // Dirección de correo del remitente predeterminado
    private static final String REMITENTE_PREDETERMINADO = "rodrigoUCP@gmail.com";

    public GrpsServiceClient(String host, int puerto) {
        // Crear y configurar el canal de comunicación gRPC con el servidor
        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, puerto)
                .usePlaintext()  // Usa comunicación sin encriptar (plaintext) para desarrollo
                .build();
        // Inicializar el cliente bloqueante
        stubBloqueante = GrpsServiceGrpc.newBlockingStub(canal);
    }

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        // Crear solicitud de envío de correo con datos del remitente, destinatario, asunto y cuerpo
        GrpsServiceProto.SolicitudCorreo solicitud = GrpsServiceProto.SolicitudCorreo.newBuilder()
                .setRemitente(REMITENTE_PREDETERMINADO)
                .setDestinatario(destinatario)
                .setAsunto(asunto)
                .setCuerpo(cuerpo)
                .build();
        // Enviar la solicitud al servidor y recibir la respuesta
        GrpsServiceProto.Respuesta respuesta = stubBloqueante.enviarCorreo(solicitud);
    }

    public void verCorreosRecibidos() {
        // Crear una solicitud para obtener la bandeja de entrada del destinatario predeterminado
        String destinatario = REMITENTE_PREDETERMINADO;

        GrpsServiceProto.SolicitudBandeja solicitud = GrpsServiceProto.SolicitudBandeja.newBuilder()
                .setDestinatario(destinatario)
                .build();

        try {
            // Llama al servidor para obtener la bandeja de entrada del destinatario
            GrpsServiceProto.RespuestaBandeja respuesta = stubBloqueante.obtenerBandejaEntrada(solicitud);
            System.out.println("Correos recibidos para " + destinatario + ":");
            // Imprimir los detalles de cada correo recibido
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
        // Crear una solicitud para obtener la lista de correos enviados por el remitente predeterminado
        GrpsServiceProto.SolicitudEnviados solicitud = GrpsServiceProto.SolicitudEnviados.newBuilder()
                .setRemitente(REMITENTE_PREDETERMINADO)
                .build();

        try {
            // Llama al servidor para obtener la lista de correos enviados
            GrpsServiceProto.RespuestaEnviados respuesta = stubBloqueante.obtenerCorreosEnviados(solicitud);
            System.out.println("Correos enviados por " + REMITENTE_PREDETERMINADO + ":");
            // Imprimir los detalles de cada correo enviado
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
        // Inicializar el cliente gRPC para conectarse al servidor en localhost en el puerto 50051
        GrpsServiceClient cliente = new GrpsServiceClient("localhost", 50051);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Enviar un correo");
            System.out.println("2. Ver correos recibidos");
            System.out.println("3. Ver correos enviados");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de leer un entero

            switch (opcion) {
                case 1:
                    // Solicita los datos del correo y lo envía
                    System.out.print("Para: ");
                    String destinatario = scanner.nextLine();
                    System.out.print("Asunto: ");
                    String asunto = scanner.nextLine();
                    System.out.print("Mensaje: ");
                    String cuerpo = scanner.nextLine();
                    System.out.println("----------------------------");

                    cliente.enviarCorreo(destinatario, asunto, cuerpo);
                    System.out.println("Correo enviado.");
                    break;

                case 2:
                    // Muestra la bandeja de entrada del destinatario predeterminado
                    cliente.verCorreosRecibidos();
                    break;

                case 3:
                    // Muestra la lista de correos enviados por el remitente predeterminado
                    cliente.verCorreosEnviados();
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
