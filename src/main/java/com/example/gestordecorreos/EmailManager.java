package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;


public class EmailManager{

    //contacto envia un email a uno o varios contactos

    public ArrayList <Bandeja> favoritos = new ArrayList<>();

    public EmailManager() {
    }

    //Exception para mandar un email invalido (sin asunto)
    public void enviar(Email email) {
        if (email.getAsunto() == null || email.getAsunto().trim().isEmpty()) {
            throw new IllegalArgumentException("El correo debe tener un asunto.");
        }

        email.getRemitente().bandeja.getEnviados().add(email.clonar());

        for (Contacto destinatario : email.getDestinatarios()) {
            destinatario.bandeja.getRecibidos().add(email.clonar());
        }
    }

    public List<Email> borrar(List<Email> bandejaFiltrada) {

        for (Email email : bandejaFiltrada) {
            for (Contacto destinatario : email.getDestinatarios()) {
                destinatario.bandeja.getRecibidos().remove(email);
            }
           
        }
        return bandejaFiltrada; 
    }

}
