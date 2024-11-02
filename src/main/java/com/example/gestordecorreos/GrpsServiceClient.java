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
                GrpsServiceProto.Response response = blockingStub.sendEmail(request);
                System.out.println("Email enviado:");
                System.out.println(String.format("De: %s\nPara: %s\nAsunto: %s\nMensaje: %s\n",
                        sender, recipient, subject, body));
            } catch (StatusRuntimeException e) {
                System.err.println("Error de RPC: " + e.getStatus());
            }
    }

    public static void main(String[] args) {
        GrpsServiceClient client = new GrpsServiceClient("localhost", 50051);

        // Envía un email de prueba
        client.sendEmail("rodriUCP@gmail.com", 
                        "IvanUCP@gmail.com",
                        "Tenemos que realizar lo de fisica", 
                        "Vamos a juntarnos el 05/11 a hacer lo de fisica.");
        //Cliente3 "IvanUCP@gmail.com"
        //Cliente2 "AugustoUCP@gmail.com"
    }
    
}
