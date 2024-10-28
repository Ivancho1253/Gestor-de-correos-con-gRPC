package com.example.gestordecorreos;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {
    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(50051)
                .addService((BindableService) new GrpsService())
                .build()
                .start();
        System.out.println("Servidor gRPC iniciado en el puerto 50051");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Apagando servidor gRPC");
            GrpcServer.this.stop();
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer server = new GrpcServer();
        server.start();
        server.server.awaitTermination();
    }
}
