package com.example.gestordecorreos;

import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.stub.StreamObserver;


public class GrpsServiceImpl extends GrpsServiceGrpc.GrpsServiceImplBase {

    @Override
    public void sendEmail(GrpsServiceProto.EmailRequest request,
                          StreamObserver<GrpsServiceProto.Response> responseObserver) {
        // Recupera los datos de la solicitud
        String sender = request.getSender();
        String recipient = request.getRecipient();
        String subject = request.getSubject();
        String body = request.getBody();

        // Lógica de envío de correo
        String responseMessage = "De: " + sender + " Para: " + recipient + " Asunto: " + subject + " " + body;

        // Construye y envía la respuesta
        GrpsServiceProto.Response response = GrpsServiceProto.Response.newBuilder()
                .setMessage(responseMessage)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
