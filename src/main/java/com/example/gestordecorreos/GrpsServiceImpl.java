package com.example.gestordecorreos;

import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.stub.StreamObserver;

public class GrpsServiceImpl extends GrpsServiceGrpc.GrpsServiceImplBase {

    @Override
    public void yourMethod(GrpsServiceProto.Request request,
                           io.grpc.stub.StreamObserver<GrpsServiceProto.Response> responseObserver) {
        // Recupera el mensaje de la solicitud
        String requestMessage = request.getMessage();

        // Lógica de negocio aquí
        String responseMessage = "Respuesta a: " + requestMessage;

        // Construye la respuesta
        GrpsServiceProto.Response response = GrpsServiceProto.Response.newBuilder()
                .setMessage(responseMessage)
                .build();

        // Envía la respuesta
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
