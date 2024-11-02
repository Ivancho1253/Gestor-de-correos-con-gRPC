package com.example.gestordecorreos;

import java.util.Scanner;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Cliente2 {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;

    public Cliente2(String host, int puerto) {
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
                System.out.println("Leido? " + (correo.getLeido() ? "Sí" : "No"));
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
    
                // Marcar como leído si no lo está
                if (!correoSeleccionado.getLeido()) {
                    marcarCorreoComoLeido(correoSeleccionado);
                }
            } else {
                System.out.println("Número de correo no valido.");
            }
    
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    private void marcarCorreoComoLeido(GrpsServiceProto.Correo correo) {
        // Implementa la lógica para actualizar el estado del correo en el servidor
        System.out.println("Marcando el correo como leido...");
        // Aquí necesitarías un método adicional en el servicio para actualizar el estado del correo
    }

    public static void main(String[] args) {
        Cliente2 clienteAugusto = new Cliente2("localhost", 50051);

        // Augusto consulta su bandeja de entrada
        clienteAugusto.consultarBandejaEntrada("AugustoUCP@gmail.com");
    }
    
}
