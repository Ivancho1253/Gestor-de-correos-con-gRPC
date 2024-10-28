package com.example.gestordecorreos;

import com.example.grpc.generated.GrpsServiceGrpc;
import com.example.grpc.generated.GrpsServiceOuterClass.GroupRequest;
import com.example.grpc.generated.GrpsServiceOuterClass.GroupResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpsClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        GrpsServiceGrpc.GrpsServiceBlockingStub stub = GrpsServiceGrpc.newBlockingStub(channel);

        GroupRequest request = GroupRequest.newBuilder().setGroupName("Grupo1").build();
        GroupResponse response = stub.getGroupInfo(request);

        System.out.println("Información del grupo: " + response.getGroupName());
        System.out.println("Miembros: " + response.getMembersList());

        channel.shutdown();
    }
}
