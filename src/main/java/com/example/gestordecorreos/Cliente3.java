package com.example.gestordecorreos;
import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

public class Cliente3 {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub blockingStub;

    public Cliente3(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = GrpsServiceGrpc.newBlockingStub(channel);
    }

    public void checkInbox(String recipient) {
        GrpsServiceProto.InboxRequest request = GrpsServiceProto.InboxRequest.newBuilder()
                .setRecipient(recipient)
                .build();

        try {
            GrpsServiceProto.InboxResponse response = blockingStub.getInbox(request);
            if (response.getEmailsList().isEmpty()) {
                System.out.println("No hay correos en la bandeja de entrada para " + recipient + ".");
                return;
            }

            System.out.println("Bandeja de entrada para " + recipient + ":");
            int index = 1;
            for (GrpsServiceProto.Email email : response.getEmailsList()) {
                System.out.println("Email #" + index);
                System.out.println("De: " + email.getSender());
                System.out.println("Asunto: " + email.getSubject());
                System.out.println("¿Leído? " + (email.getRead() ? "Sí" : "No"));
                System.out.println("----------------------------");
                index++;
            }


            // Seleccionar un correo para ver los detalles
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa el número del email que deseas ver en detalle: ");
            int emailIndex = scanner.nextInt();

            if (emailIndex > 0 && emailIndex <= response.getEmailsList().size()) {
                GrpsServiceProto.Email selectedEmail = response.getEmailsList().get(emailIndex - 1);
                System.out.println("\nDetalles del Email seleccionado:");
                System.out.println("De: " + selectedEmail.getSender());
                System.out.println("Asunto: " + selectedEmail.getSubject());
                System.out.println("Mensaje: " + selectedEmail.getBody());
                System.out.println("----------------------------");

                if (!selectedEmail.getRead()) {
                    markEmailAsRead(selectedEmail);
                }
            } else {
                System.out.println("Número de email no válido.");
            }

        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    private void markEmailAsRead(GrpsServiceProto.Email email) {
        System.out.println("Marcando el email como leído...");
    }

    public static void main(String[] args) {
        Cliente3 clienteTercero = new Cliente3("localhost", 50051);

        // Cliente3 consulta su bandeja de entrada
        clienteTercero.checkInbox("IvanUCP@gmail.com");  
    }
}
