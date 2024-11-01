package com.example.gestordecorreos;

import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


public class GrpsServiceClient {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub blockingStub;

    public GrpsServiceClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = GrpsServiceGrpc.newBlockingStub(channel);
    }

    public void sendEmail(String sender, String recipient, String subject, String body) {
        // Construye el mensaje de solicitud del email
        GrpsServiceProto.EmailRequest request = GrpsServiceProto.EmailRequest.newBuilder()
                .setSender(sender)
                .setRecipient(recipient)
                .setSubject(subject)
                .setBody(body)
                .build();

        try {
            // Llama al método sendEmail y obtiene la respuesta
            GrpsServiceProto.Response response = blockingStub.sendEmail(request);
            System.out.println("Respuesta del servidor: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public static void main(String[] args) {
        GrpsServiceClient client = new GrpsServiceClient("localhost", 50051);

        // Envía un email de prueba
        client.sendEmail("remitente@ejemplo.com", "destinatario@ejemplo.com",
                         "Prueba de Asunto", "Contenido del email de prueba.");
    }
}
