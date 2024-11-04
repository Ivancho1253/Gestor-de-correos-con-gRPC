package com.example.gestordecorreos;

import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrpsServiceImpl extends GrpsServiceGrpc.GrpsServiceImplBase {

    // Mapa para almacenar correos recibidos organizados por destinatario
    private final Map<String, List<GrpsServiceProto.Correo>> bandejaEntrada = new HashMap<>();
    // Mapa para almacenar correos enviados organizados por remitente
    private final Map<String, List<GrpsServiceProto.Correo>> correosEnviados = new HashMap<>();

    @Override
    public void enviarCorreo(GrpsServiceProto.SolicitudCorreo request, StreamObserver<GrpsServiceProto.Respuesta> responseObserver) {
        // Obtener información del correo a enviar desde la solicitud
        String remitente = request.getRemitente();
        String destinatario = request.getDestinatario();
        String asunto = request.getAsunto();
        String cuerpo = request.getCuerpo();

        // Crear un objeto 'Correo' usando los datos obtenidos
        GrpsServiceProto.Correo correo = GrpsServiceProto.Correo.newBuilder()
                .setRemitente(remitente)
                .setDestinatario(destinatario)
                .setAsunto(asunto)
                .setCuerpo(cuerpo)
                .build();

        // Agregar el correo a la bandeja de entrada del destinatario.
        // Si el destinatario no existe en el mapa, se crea una nueva lista para él.
        bandejaEntrada.computeIfAbsent(destinatario, k -> new ArrayList<>()).add(correo);

        // Agregar el correo a la lista de correos enviados del remitente
        correosEnviados.computeIfAbsent(remitente, k -> new ArrayList<>()).add(correo);

        // Crear una respuesta indicando que el envío fue exitoso
        GrpsServiceProto.Respuesta respuesta = GrpsServiceProto.Respuesta.newBuilder()
                .setExito(true)
                .build();
        // Enviar la respuesta al cliente y completar la comunicación
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }

    @Override
    public void obtenerBandejaEntrada(GrpsServiceProto.SolicitudBandeja request, StreamObserver<GrpsServiceProto.RespuestaBandeja> responseObserver) {
        String destinatario = request.getDestinatario();

        // Obtener los correos de la bandeja de entrada para el destinatario solicitado
        List<GrpsServiceProto.Correo> correos = bandejaEntrada.getOrDefault(destinatario, new ArrayList<>());

        // Crear una respuesta con la lista de correos
        GrpsServiceProto.RespuestaBandeja respuesta = GrpsServiceProto.RespuestaBandeja.newBuilder()
                .addAllCorreos(correos)
                .build();
        // Enviar la respuesta con los correos y completar la comunicación
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }

    @Override
    public void obtenerCorreosEnviados(GrpsServiceProto.SolicitudEnviados request, StreamObserver<GrpsServiceProto.RespuestaEnviados> responseObserver) {
        // Obtener los correos enviados por el remitente especificado en la solicitud
        List<GrpsServiceProto.Correo> correos = correosEnviados.getOrDefault(request.getRemitente(), new ArrayList<>());

        // Crear la respuesta con la lista de correos enviados
        GrpsServiceProto.RespuestaEnviados respuesta = GrpsServiceProto.RespuestaEnviados.newBuilder()
                .addAllCorreos(correos)
                .build();
        // Enviar la respuesta con los correos enviados y completar la comunicación
        responseObserver.onNext(respuesta);
        responseObserver.onCompleted();
    }
}
