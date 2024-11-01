package com.example.gestordecorreos;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new GrpsServiceImpl())
                .build()
                .start();

        System.out.println("Servidor gRPC iniciado en el puerto 50051");
        server.awaitTermination();
    }
}
