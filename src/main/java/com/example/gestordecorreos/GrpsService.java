package com.example.gestordecorreos;

import com.google.rpc.context.AttributeContext.Request;
import com.google.rpc.context.AttributeContext.Response;


import io.grpc.stub.StreamObserver;

public class GrpsService extends GrpsService.GrpsServiceImplBase {
    @Override
    public void someMethod(Request request, StreamObserver<Response> responseObserver) {
        // Lógica del servicio
        Response response = Response.newBuilder().setMessage("Hola Rodri").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
