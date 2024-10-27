package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;


public class Email {
    //el correo es enviado por email manager
    private String asunto;
    private String contenido;

    // remitente es un Contacto
    private Contacto remitente;

    // destinatarios es uno o mas Contactos
    public ArrayList<Contacto> destinatarios;

    public boolean esFavorito = false;

    public Email(String asunto, String contenido, Contacto remitente, List<Contacto> destinatarios) {
        setAsunto(asunto);
        setContenido(contenido);
        setRemitente(remitente);
        setDestinatarios(destinatarios);
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    //se hizo publico para la exposicion
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    private void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Contacto getRemitente() {
        return remitente;
    }

    private void setRemitente(Contacto remitente) {
        this.remitente = remitente;
    }
    
    private void setDestinatarios(List<Contacto> destinatarios) {
        this.destinatarios = new ArrayList<>(destinatarios);
    }
    
    public List<Contacto> getDestinatarios() {
        return destinatarios;
    }
    public Email clonar() {
        return new Email(this.asunto, this.contenido, this.remitente, new ArrayList<>( this.destinatarios));

    }

    public void marcarComoFavorito() {
        this.esFavorito = true;
    }
}
