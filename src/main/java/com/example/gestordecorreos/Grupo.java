package com.example.gestordecorreos;
import java.util.ArrayList;
import java.util.List;


public class Grupo {

    public List<Contacto> contactos;

    public Grupo() {
        this.contactos = new ArrayList<>();
    }

    
    public Grupo(List<Contacto> contactos) {
        //Se recibe una lista de contactos como parametro
        this.contactos = contactos != null ? contactos : new ArrayList<>();
    }

   
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    // Método para acceder a las bandejas de los miembros del grupo
    public List<Email> obtenerEmailsRecibidos() {
        
        List<Email> emailsRecibidos = new ArrayList<>();

        // Recorre los contactos del grupo y accede a la bandeja de recibidos de cada uno
        for (Contacto contacto : contactos) {
            if (contacto.bandeja != null) {
                emailsRecibidos.addAll(contacto.bandeja.getRecibidos());
            }
        }

        return emailsRecibidos;
    }

}
