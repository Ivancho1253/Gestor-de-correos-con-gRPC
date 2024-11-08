package com.example.gestordecorreos;

import java.util.List;
import java.util.Scanner;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Cliente3 {

    // Cliente gRPC de tipo bloqueante para realizar llamadas síncronas al servidor
    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;

    public Cliente3(String host, int puerto) {
        // Configura el canal de comunicación gRPC
        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, puerto)
                .usePlaintext()  // Usa conexión sin cifrado (plaintext) para desarrollo
                .build();
        // Inicializar el cliente bloqueante para realizar las llamadas RPC
        stubBloqueante = GrpsServiceGrpc.newBlockingStub(canal);
    }

    public void consultarBandejaEntrada(String destinatario) {
        // Crear una solicitud para consultar la bandeja de entrada del destinatario especificado
        GrpsServiceProto.SolicitudBandeja solicitud = GrpsServiceProto.SolicitudBandeja.newBuilder()
                .setDestinatario(destinatario)
                .build();

        try {
            // Llamada al servidor para obtener los correos en la bandeja de entrada del destinatario
            GrpsServiceProto.RespuestaBandeja respuesta = stubBloqueante.obtenerBandejaEntrada(solicitud);
            List<GrpsServiceProto.Correo> correos = respuesta.getCorreosList();

            // Verificar si la bandeja de entrada está vacía
            if (correos.isEmpty()) {
                System.out.println("No hay correos en la bandeja de entrada para " + destinatario + ".");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                // Mostrar una lista con los correos disponibles en la bandeja de entrada
                System.out.println("\nBandeja de entrada para " + destinatario + ":");
                for (int i = 0; i < correos.size(); i++) {
                    GrpsServiceProto.Correo correo = correos.get(i);
                    System.out.println("Correo #" + (i + 1));
                    System.out.println("De: " + correo.getRemitente());
                    System.out.println("Asunto: " + correo.getAsunto());
                    System.out.println("----------------------------");
                }

                // Solicitar al usuario seleccionar un correo para ver los detalles
                System.out.print("\nIngresa el número del correo que deseas leer en detalle (0 para salir): ");
                int indiceCorreo = scanner.nextInt();

                // Manejar la salida si el usuario ingresa 0
                if (indiceCorreo == 0) {
                    continuar = false;
                } else if (indiceCorreo > 0 && indiceCorreo <= correos.size()) {
                    // Mostrar detalles completos del correo seleccionado
                    GrpsServiceProto.Correo correoSeleccionado = correos.get(indiceCorreo - 1);
                    System.out.println("\nDetalles del correo seleccionado:");
                    System.out.println("De: " + correoSeleccionado.getRemitente());
                    System.out.println("Asunto: " + correoSeleccionado.getAsunto());
                    System.out.println("Mensaje: " + correoSeleccionado.getCuerpo());
                    System.out.println("----------------------------");

                } else {
                    System.out.println("Número de correo no válido.");
                }

                // Preguntar al usuario si quiere ver otro correo
                if (continuar) {
                    System.out.print("¿Deseas ver otro correo? (si/no): ");
                    continuar = scanner.next().equalsIgnoreCase("si");
                }
            }

            System.out.println("Saliendo de la bandeja de entrada...");

        } catch (StatusRuntimeException e) {
            // Captura errores de comunicación con el servidor y muestra el estado de error
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public static void main(String[] args) {
        // Inicializa un cliente para conectarse al servidor gRPC en localhost en el puerto 50051
        Cliente3 clienteTercero = new Cliente3("192.168.0.165", 50051);
        // Consultar la bandeja de entrada de un destinatario específico
        clienteTercero.consultarBandejaEntrada("IvanUCP@gmail.com");
    }
}
