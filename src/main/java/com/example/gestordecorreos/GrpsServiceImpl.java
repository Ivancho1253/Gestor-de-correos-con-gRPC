package com.example.gestordecorreos;
import java.util.ArrayList;
import java.util.List;
import com.example.gestordecorreos.GrpsServiceProto; // Asegúrate de que esta ruta sea correcta
import io.grpc.stub.StreamObserver;

public class GrpsServiceImpl extends GrpsServiceGrpc.GrpsServiceImplBase {

    private final List<GrpsServiceProto.Email> inbox = new ArrayList<>();

    @Override
    public void sendEmail(GrpsServiceProto.EmailRequest request, StreamObserver<GrpsServiceProto.Response> responseObserver) {
        GrpsServiceProto.Email email = GrpsServiceProto.Email.newBuilder()
                .setSender(request.getSender())
                .setRecipient(request.getRecipient())
                .setSubject(request.getSubject())
                .setBody(request.getBody())
                .setRead(false) // Marcar como no leído
                .build();
        inbox.add(email);

        GrpsServiceProto.Response response = GrpsServiceProto.Response.newBuilder()
                .setMessage(" De: " + request.getSender() + " Para: " + request.getRecipient() + " Asunto: " + request.getSubject() + " " + request.getBody())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getInbox(GrpsServiceProto.InboxRequest request, StreamObserver<GrpsServiceProto.InboxResponse> responseObserver) {
        // Filtrar correos para el destinatario especificado
        List<GrpsServiceProto.Email> userInbox = new ArrayList<>();
        for (GrpsServiceProto.Email email : inbox) {
            if (email.getRecipient().equals(request.getRecipient())) {
                userInbox.add(email);
            }
        }

        // Construir y enviar la respuesta
        GrpsServiceProto.InboxResponse response = GrpsServiceProto.InboxResponse.newBuilder()
                .addAllEmails(userInbox)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
}
//" De: " + request.getSender() + " Para: " + request.getRecipient() + " Asunto: " + request.getSubject() + " " + request.getBody()