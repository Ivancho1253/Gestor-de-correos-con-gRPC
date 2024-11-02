package com.example.gestordecorreos;

import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

public class GrpsServiceClient {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub blockingStub;

    public GrpsServiceClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = GrpsServiceGrpc.newBlockingStub(channel);
    }

    public void sendEmail(String sender, String recipient, String subject, String body) {
        GrpsServiceProto.EmailRequest request = GrpsServiceProto.EmailRequest.newBuilder()
                .setSender(sender)
                .setRecipient(recipient)
                .setSubject(subject)
                .setBody(body)
                .build();

        try {
            GrpsServiceProto.Response response = blockingStub.sendEmail(request);
            System.out.println("Email enviado:");
            System.out.println(String.format("De: %s\nPara: %s\nAsunto: %s\nMensaje: %s\n",
                    sender, recipient, subject, body));
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public void viewReceivedEmails(String recipient) {
        GrpsServiceProto.InboxRequest request = GrpsServiceProto.InboxRequest.newBuilder()
                .setRecipient(recipient)
                .build();

        try {
            GrpsServiceProto.InboxResponse response = blockingStub.getInbox(request);
            System.out.println("Emails recibidos para " + recipient + ":");
            for (GrpsServiceProto.Email email : response.getEmailsList()) {
                System.out.println("De: " + email.getSender());
                System.out.println("Asunto: " + email.getSubject());
                System.out.println("Mensaje: " + email.getBody());
                System.out.println("----------------------------");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public void viewSentEmails(String sender) {
        GrpsServiceProto.SentRequest request = GrpsServiceProto.SentRequest.newBuilder()
                .setSender(sender)
                .build();

        try {
            GrpsServiceProto.SentResponse response = blockingStub.getSentEmails(request);
            System.out.println("Emails enviados por " + sender + ":");
            for (GrpsServiceProto.Email email : response.getEmailsList()) {
                System.out.println("Para: " + email.getRecipient());
                System.out.println("Asunto: " + email.getSubject());
                System.out.println("Mensaje: " + email.getBody());
                System.out.println("----------------------------");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public static void main(String[] args) {
        GrpsServiceClient client = new GrpsServiceClient("localhost", 50051);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Enviar un email");
            System.out.println("2. Ver emails recibidos");
            System.out.println("3. Ver emails enviados");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("De: ");
                    String sender = scanner.nextLine();
                    System.out.print("Para: ");
                    String recipient = scanner.nextLine();
                    System.out.print("Asunto: ");
                    String subject = scanner.nextLine();
                    System.out.print("Mensaje: ");
                    String body = scanner.nextLine();
                    client.sendEmail(sender, recipient, subject, body);
                    break;

                case 2:
                    System.out.print("Ingrese su email para ver la bandeja de entrada: ");
                    String recipientEmail = scanner.nextLine();
                    client.viewReceivedEmails(recipientEmail);
                    break;

                case 3:
                    System.out.print("Ingrese su email para ver los emails enviados: ");
                    String senderEmail = scanner.nextLine();
                    client.viewSentEmails(senderEmail);
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
