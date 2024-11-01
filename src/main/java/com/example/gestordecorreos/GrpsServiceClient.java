package com.example.gestordecorreos;
import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GrpsServiceClient {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub blockingStub;

    // Constructor del cliente que recibe la dirección y puerto del servidor gRPC
    public GrpsServiceClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext() // Si estás ejecutando sin TLS/SSL
                .build();
        blockingStub = GrpsServiceGrpc.newBlockingStub(channel);
    }

    // Método para llamar a YourMethod y enviar una solicitud al servidor
    public void sendMessage(String message) {
        // Construye el mensaje de solicitud
        GrpsServiceProto.Request request = GrpsServiceProto.Request.newBuilder()
                .setMessage(message)
                .build();

        try {
            // Llama al método YourMethod y obtiene la respuesta
            GrpsServiceProto.Response response = blockingStub.yourMethod(request);
            System.out.println("Respuesta del servidor: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public static void main(String[] args) {
        // Cambia "localhost" y el puerto según tu configuración del servidor gRPC
        GrpsServiceClient client = new GrpsServiceClient("localhost", 50051);
        
        // Envía un mensaje de prueba al servidor
        client.sendMessage("Hola desde el cliente");
    }
}
