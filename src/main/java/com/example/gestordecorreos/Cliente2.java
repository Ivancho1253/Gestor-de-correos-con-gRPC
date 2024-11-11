package com.example.gestordecorreos;

import java.util.List;
import java.util.Scanner;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Cliente2 {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;
    private final Bandeja bandeja; // Instancia de la bandeja para almacenar correos

    public Cliente2(String host, int puerto) {
        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, puerto)
                .usePlaintext()
                .build();
        stubBloqueante = GrpsServiceGrpc.newBlockingStub(canal);
        bandeja = new Bandeja();
    }

    public void consultarBandejaEntrada(String destinatario) {
        GrpsServiceProto.SolicitudBandeja solicitud = GrpsServiceProto.SolicitudBandeja.newBuilder()
                .setDestinatario(destinatario)
                .build();

        try {
            GrpsServiceProto.RespuestaBandeja respuesta = stubBloqueante.obtenerBandejaEntrada(solicitud);
            List<GrpsServiceProto.Correo> correos = respuesta.getCorreosList();

            if (correos.isEmpty()) {
                System.out.println("No hay correos en la bandeja de entrada para " + destinatario + ".");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("\nOpciones:");
                System.out.println("1. Ver correos en bandeja de entrada");
                System.out.println("2. Ver correos favoritos");
                System.out.println("0. Salir");
                System.out.print("Selecciona una opción: ");
                int opcion = scanner.nextInt();

                if (opcion == 0) {
                    continuar = false;
                } else if (opcion == 1) {
                    mostrarCorreos(correos, scanner);
                } else if (opcion == 2) {
                    mostrarFavoritos();
                } else {
                    System.out.println("Opción no válida.");
                }
            }

            System.out.println("Saliendo del cliente de correos...");

        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    private void mostrarCorreos(List<GrpsServiceProto.Correo> correos, Scanner scanner) {
        System.out.println("\nBandeja de entrada:");
        for (int i = 0; i < correos.size(); i++) {
            GrpsServiceProto.Correo correo = correos.get(i);
            System.out.println("Correo #" + (i + 1));
            System.out.println("De: " + correo.getRemitente());
            System.out.println("Asunto: " + correo.getAsunto());
            System.out.println("----------------------------");
        }

        System.out.print("\nIngresa el número del correo que deseas leer en detalle (0 para salir): ");
        int indiceCorreo = scanner.nextInt();

        if (indiceCorreo > 0 && indiceCorreo <= correos.size()) {
            GrpsServiceProto.Correo correoSeleccionado = correos.get(indiceCorreo - 1);
            Email email = new Email(correoSeleccionado.getRemitente(), correoSeleccionado.getAsunto(), correoSeleccionado.getCuerpo());
            System.out.println("\nDetalles del correo seleccionado:");
            System.out.println("De: " + correoSeleccionado.getRemitente());
            System.out.println("Asunto: " + correoSeleccionado.getAsunto());
            System.out.println("Mensaje: " + correoSeleccionado.getCuerpo());
            System.out.println("----------------------------");

            System.out.print("¿Quieres marcar este correo como favorito? (si/no): ");
            if (scanner.next().equalsIgnoreCase("si")) {
                bandeja.setFavoritos(email);
            }
        } else if (indiceCorreo != 0) {
            System.out.println("Número de correo no válido.");
        }
    }

    private void mostrarFavoritos() {

        List<Email> favoritos = bandeja.getFavoritos();

        if (favoritos.isEmpty()) {
            System.out.println("No tienes correos en favoritos.");
        } else {
            System.out.println("\nLista de correos favoritos:");
            for (Email favorito : favoritos) {
                System.out.println("De: " + favorito.getRemitente());
                System.out.println("Asunto: " + favorito.getAsunto());
                System.out.println("Mensaje: " + favorito.getContenido());
                System.out.println("----------------------------");
            }
        }
    }

    public static void main(String[] args) {
        Cliente2 clienteSegundo = new Cliente2("localhost", 50051);
        clienteSegundo.consultarBandejaEntrada("AugustoUCP@gmail.com");
    }
    
}
