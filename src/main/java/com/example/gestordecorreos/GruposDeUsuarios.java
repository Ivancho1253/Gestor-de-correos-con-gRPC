package com.example.gestordecorreos;
import java.util.ArrayList;
import java.util.List;


public class GruposDeUsuarios {

    public List <Contacto> contactos;

    public GruposDeUsuarios() {
        this.contactos = new ArrayList<>();
    }

   
    public void agregarAlGrupo(Contacto contacto) {

        for (Contacto c : contactos) {
            if (c.getCorreo().equals(contacto.getCorreo())) {
                return;
            }
        }
        contactos.add(contacto);
    }

    public List<Contacto> obtenerMiembros() {
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
