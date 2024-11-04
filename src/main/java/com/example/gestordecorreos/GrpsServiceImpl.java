package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;
import io.grpc.stub.StreamObserver;

public class GrpsServiceImpl extends GrpsServiceGrpc.GrpsServiceImplBase {

    private final List<GrpsServiceProto.Correo> bandejaEntrada = new ArrayList<>();    // Lista para correos recibidos
    private final List<GrpsServiceProto.Correo> correosEnviados = new ArrayList<>();   // Lista para correos enviados

    @Override
    public void enviarCorreo(GrpsServiceProto.SolicitudCorreo solicitud, StreamObserver<GrpsServiceProto.Respuesta> responseObserver) {
        GrpsServiceProto.Correo correo = GrpsServiceProto.Correo.newBuilder()
                .setRemitente(solicitud.getRemitente())
                .setDestinatario(solicitud.getDestinatario())
                .setAsunto(solicitud.getAsunto())
                .setCuerpo(solicitud.getCuerpo())
                .setLeido(false)
                .build();
        
        // Agregar el correo solo a la bandeja de entrada del destinatario
        bandejaEntrada.add(correo);

        // Agregar el correo a la lista de correos enviados del remitente
        correosEnviados.add(correo);

        GrpsServiceProto.Respuesta respuesta = GrpsServiceProto.Respuesta.newBuilder()
                .setMensaje("Correo enviado. De: " + solicitud.getRemitente() + " Para: " + solicitud.getDestinatario() + " Asunto: " + solicitud.getAsunto() + " Mensaje: " + solicitud.getCuerpo())
                .build();
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }

    @Override
    public void obtenerBandejaEntrada(GrpsServiceProto.SolicitudBandeja solicitud, StreamObserver<GrpsServiceProto.RespuestaBandeja> responseObserver) {
        List<GrpsServiceProto.Correo> bandejaUsuario = new ArrayList<>();
        for (GrpsServiceProto.Correo correo : bandejaEntrada) {
            // Filtrar para mostrar solo correos de remitentes distintos al destinatario
            if (correo.getDestinatario().equals(solicitud.getDestinatario()) && 
                !correo.getRemitente().equals(solicitud.getDestinatario())) {
                bandejaUsuario.add(correo);
            }
        }

        GrpsServiceProto.RespuestaBandeja respuesta = GrpsServiceProto.RespuestaBandeja.newBuilder()
                .addAllCorreos(bandejaUsuario)
                .build();
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }




    @Override
    public void obtenerCorreosEnviados(GrpsServiceProto.SolicitudEnviados solicitud, StreamObserver<GrpsServiceProto.RespuestaEnviados> responseObserver) {
        List<GrpsServiceProto.Correo> enviadosPorUsuario = new ArrayList<>();
        for (GrpsServiceProto.Correo correo : correosEnviados) {
            if (correo.getRemitente().equals(solicitud.getRemitente())) {
                enviadosPorUsuario.add(correo);
            }
        }
        
        // Mensaje de log
        System.out.println("Mostrando correos enviados por: " + solicitud.getRemitente());
        for (GrpsServiceProto.Correo correo : enviadosPorUsuario) {
            System.out.println("Correo - Para: " + correo.getDestinatario() + ", Asunto: " + correo.getAsunto());
        }
        
        GrpsServiceProto.RespuestaEnviados respuesta = GrpsServiceProto.RespuestaEnviados.newBuilder()
                .addAllCorreos(enviadosPorUsuario)
                .build();
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }

}
