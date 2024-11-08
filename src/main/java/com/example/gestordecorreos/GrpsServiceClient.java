package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GrpsServiceClient {

    private final GrpsServiceGrpc.GrpsServiceBlockingStub stubBloqueante;
    private static final String REMITENTE_PREDETERMINADO = "rodrigoUCP@gmail.com";

    public GrpsServiceClient(String host, int puerto) {
        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, puerto)
                .usePlaintext()
                .build();
        stubBloqueante = GrpsServiceGrpc.newBlockingStub(canal);
    }

    public void enviarCorreo(List<String> destinatarios, String grupo, String asunto, String cuerpo) {
        // Construir la solicitud de correo
        GrpsServiceProto.SolicitudCorreo.Builder solicitudBuilder = GrpsServiceProto.SolicitudCorreo.newBuilder()
                .setRemitente(REMITENTE_PREDETERMINADO)
                .setAsunto(asunto)
                .setCuerpo(cuerpo);

        // Verificar si se debe enviar a un grupo o a destinatarios individuales
        if (!grupo.isEmpty()) {
            solicitudBuilder.setGrupo(grupo);
            System.out.println("Enviando correo al grupo: " + grupo);
        } else {
            solicitudBuilder.addAllDestinatarios(destinatarios);
            System.out.println("Enviando correo a los destinatarios individuales: " + destinatarios);
        }

        // Crear la solicitud final
        GrpsServiceProto.SolicitudCorreo solicitud = solicitudBuilder.build();
        
        // Enviar la solicitud y obtener la respuesta
        try {
            GrpsServiceProto.Respuesta respuesta = stubBloqueante.enviarCorreo(solicitud);
            if (respuesta.getExito()) {
                System.out.println("Correo enviado exitosamente.");
            } else {
                System.out.println("No se pudo enviar el correo.");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public void verCorreosRecibidos() {
        String destinatario = REMITENTE_PREDETERMINADO;
        GrpsServiceProto.SolicitudBandeja solicitud = GrpsServiceProto.SolicitudBandeja.newBuilder()
                .setDestinatario(destinatario)
                .build();

        try {
            GrpsServiceProto.RespuestaBandeja respuesta = stubBloqueante.obtenerBandejaEntrada(solicitud);
            System.out.println("Correos recibidos para " + destinatario + ":");
            for (GrpsServiceProto.Correo correo : respuesta.getCorreosList()) {
                System.out.println("De: " + correo.getRemitente());
                System.out.println("Asunto: " + correo.getAsunto());
                System.out.println("Mensaje: " + correo.getCuerpo());
                System.out.println("----------------------------");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }

    public void verCorreosEnviados() {
        GrpsServiceProto.SolicitudEnviados solicitud = GrpsServiceProto.SolicitudEnviados.newBuilder()
                .setRemitente(REMITENTE_PREDETERMINADO)
                .build();

        try {
            GrpsServiceProto.RespuestaEnviados respuesta = stubBloqueante.obtenerCorreosEnviados(solicitud);
            System.out.println("Correos enviados por " + REMITENTE_PREDETERMINADO + ":");
            for (GrpsServiceProto.Correo correo : respuesta.getCorreosList()) {
                System.out.println("Para: " + correo.getDestinatario());
                System.out.println("Asunto: " + correo.getAsunto());
                System.out.println("Mensaje: " + correo.getCuerpo());
                System.out.println("----------------------------");
            }
        } catch (StatusRuntimeException e) {
            System.err.println("Error de RPC: " + e.getStatus());
        }
    }
    public void enviarCorreoAGrupoPredeterminado(String asunto, String cuerpo) {
        // Crear una instancia de GruposDeUsuarios
        GruposDeUsuarios grupo = new GruposDeUsuarios();
        
        // Agregar contactos predeterminados al grupo
        grupo.agregarAlGrupo(new Contacto("IvanUCP@gmail.com"));
        grupo.agregarAlGrupo(new Contacto("AugustoUCP@gmail.com"));
        
        // Obtener los correos de los contactos en el grupo
        List<String> destinatarios = new ArrayList<>();
        for (Contacto contacto : grupo.obtenerMiembros()) {
            destinatarios.add(contacto.getCorreo());
        }
        
        // Llamar al método enviarCorreo usando el grupo de destinatarios
        enviarCorreo(destinatarios, "", asunto, cuerpo);
    }

    public static void main(String[] args) {
        GrpsServiceClient cliente = new GrpsServiceClient("Localhost", 50051);//192.168.0.165
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Enviar un correo");
            System.out.println("2. Ver correos recibidos");
            System.out.println("3. Ver correos enviados");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Enviar a un grupo predefinido? (s/n): ");
                    String enviarAGrupoPredefinido = scanner.nextLine();
                    List<String> destinatarios = new ArrayList<>();
                    String grupo = "";
            
                    if (enviarAGrupoPredefinido.equalsIgnoreCase("s")) {
                        // Usar el grupo predefinido de contactos
                        GruposDeUsuarios grupoPredeterminado = new GruposDeUsuarios();
                        grupoPredeterminado.agregarAlGrupo(new Contacto("IvanUCP@gmail.com"));
                        grupoPredeterminado.agregarAlGrupo(new Contacto("AugustoUCP@gmail.com"));
            
                        // Obtener los correos de los miembros del grupo
                        for (Contacto contacto : grupoPredeterminado.obtenerMiembros()) {
                            destinatarios.add(contacto.getCorreo());
                        }
                        System.out.println("Enviando correo al grupo predefinido: " + destinatarios);
                    } else {
                        System.out.print("Para: ");
                        String destinatario = scanner.nextLine();
                        destinatarios.add(destinatario);
                        System.out.println("Enviando correo al destinatario individual: " + destinatarios);
                    }
            
                    System.out.print("Asunto: ");
                    String asunto = scanner.nextLine();
                    System.out.print("Mensaje: ");
                    String cuerpo = scanner.nextLine();
            
                    cliente.enviarCorreo(destinatarios, grupo, asunto, cuerpo);
                    break;
            
                case 2:
                    cliente.verCorreosRecibidos();
                    break;
            
                case 3:
                    cliente.verCorreosEnviados();
                    break;
            
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
