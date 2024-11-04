package com.example.gestordecorreos;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.List;
import java.util.Scanner;

public class Cliente3 {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;

    public Cliente3(String host, int puerto) {
        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, puerto)
                .usePlaintext()
                .build();
        stubBloqueante = GrpsServiceGrpc.newBlockingStub(canal);
    }

    public void consultarBandejaEntrada(String destinatario) {
        GrpsServiceProto.SolicitudBandeja solicitud = GrpsServiceProto.SolicitudBandeja.newBuilder()
                .setDestinatario(destinatario)
                .build();

        try {
            //Realiza la solicitud al servidor para ver la bandeja de entrada

            GrpsServiceProto.RespuestaBandeja respuesta = stubBloqueante.obtenerBandejaEntrada(solicitud);
            List<GrpsServiceProto.Correo> correos = respuesta.getCorreosList();

            //se verifica que no este vacia

            if (correos.isEmpty()) {
                System.out.println("No hay correos en la bandeja de entrada para " + destinatario + ".");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("\nBandeja de entrada para " + destinatario + ":");
                for (int i = 0; i < correos.size(); i++) {
                    GrpsServiceProto.Correo correo = correos.get(i);
                    System.out.println("Correo #" + (i + 1));
                    System.out.println("De: " + correo.getRemitente());
                    System.out.println("Asunto: " + correo.getAsunto());
                    System.out.println("----------------------------");
                }

                System.out.print("\nIngresa el número del correo que deseas leer en detalle (0 para salir): ");
                int indiceCorreo = scanner.nextInt();

                if (indiceCorreo == 0) {
                    continuar = false;
                } else if (indiceCorreo > 0 && indiceCorreo <= correos.size()) {
                    GrpsServiceProto.Correo correoSeleccionado = correos.get(indiceCorreo - 1);
                    System.out.println("\nDetalles del correo seleccionado:");
                    System.out.println("De: " + correoSeleccionado.getRemitente());
                    System.out.println("Asunto: " + correoSeleccionado.getAsunto());
                    System.out.println("Mensaje: " + correoSeleccionado.getCuerpo());
                    System.out.println("----------------------------");

                } else {
                    System.out.println("Número de correo no válido.");
                }

                if (continuar) {
                    System.out.print("¿Deseas ver otro correo? (si/no): ");
                    continuar = scanner.next().equalsIgnoreCase("si");
                }
            }

            System.out.println("Saliendo de la bandeja de entrada...");

        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public static void main(String[] args) {
        Cliente3 clienteTercero = new Cliente3("localhost", 50051);
        clienteTercero.consultarBandejaEntrada("IvanUCP@gmail.com");
    }
}