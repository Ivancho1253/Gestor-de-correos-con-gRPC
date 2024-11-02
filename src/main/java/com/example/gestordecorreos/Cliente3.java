package com.example.gestordecorreos;

import com.example.gestordecorreos.GrpsServiceGrpc;
import com.example.gestordecorreos.GrpsServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

public class Cliente3 {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;

    public Cliente3(String host, int puerto) {
        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, puerto)
                .usePlaintext()
                .build();
        stubBloqueante = GrpsServiceGrpc.newBlockingStub(canal);
    }

    public void consultarBandejaEntrada(String destinatario) {
        GrpsServiceProto.SolicitudBandeja solicitud = GrpsServiceProto.SolicitudBandeja.newBuilder()
                .setDestinatario(destinatario)
                .build();

        try {
            GrpsServiceProto.RespuestaBandeja respuesta = stubBloqueante.obtenerBandejaEntrada(solicitud);
            if (respuesta.getCorreosList().isEmpty()) {
                System.out.println("No hay correos en la bandeja de entrada para " + destinatario + ".");
                return;
            }

            System.out.println("Bandeja de entrada para " + destinatario + ":");
            int indice = 1;
            for (GrpsServiceProto.Correo correo : respuesta.getCorreosList()) {
                System.out.println("Correo #" + indice);
                System.out.println("De: " + correo.getRemitente());
                System.out.println("Asunto: " + correo.getAsunto());
                System.out.println("Leer == 1 " + (correo.getLeido() ? "Si" : "No"));
                System.out.println("----------------------------");
                indice++;
            }

            // Seleccionar un correo para ver los detalles
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa el numero del correo que deseas ver en detalle: ");
            int indiceCorreo = scanner.nextInt();

            if (indiceCorreo > 0 && indiceCorreo <= respuesta.getCorreosList().size()) {
                GrpsServiceProto.Correo correoSeleccionado = respuesta.getCorreosList().get(indiceCorreo - 1);
                System.out.println("\nDetalles del correo seleccionado:");
                System.out.println("De: " + correoSeleccionado.getRemitente());
                System.out.println("Asunto: " + correoSeleccionado.getAsunto());
                System.out.println("Mensaje: " + correoSeleccionado.getCuerpo());
                System.out.println("----------------------------");

                if (!correoSeleccionado.getLeido()) {
                    marcarCorreoComoLeido(correoSeleccionado);
                }
            } else {
                System.out.println("Numero de correo no valido.");
            }

        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    private void marcarCorreoComoLeido(GrpsServiceProto.Correo correo) {
        System.out.println("Marcando el correo como leido...");
    }

    public static void main(String[] args) {
        Cliente3 clienteTercero = new Cliente3("localhost", 50051);

        // Cliente3 consulta su bandeja de entrada
        clienteTercero.consultarBandejaEntrada("IvanUCP@gmail.com");  
    }
}
