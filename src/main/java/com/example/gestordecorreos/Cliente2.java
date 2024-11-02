package com.example.gestordecorreos;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import com.example.gestordecorreos.GrpsServiceProto; // Asegúrate de que esta ruta sea correcta
import io.grpc.stub.StreamObserver;

public class Cliente2 {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub blockingStub;

    public Cliente2(String host, int port) {
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
            System.out.println("Bandeja de entrada para " + recipient + ":");
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

    public static void main(String[] args) {
        Cliente2 clienteAugusto = new Cliente2("localhost", 50051);

        // Augusto consulta su bandeja de entrada
        clienteAugusto.checkInbox("AugustoUCP@gmail.com");
    }
}
