package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class FavoritoTest {

    @Test
    public void marcarFavorito() {

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augusto@ucp.com");
        Contacto c2 = new Contacto("Ivan", "Cabrera", "ivan@ucp.com");
        Contacto c3 = new Contacto("Rodrigo","Magallanes", "rodri123@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email e1 = new Email("prueba1", "hola", c1, destinatarios);
        Email e2 = new Email("prueba2", "hola", c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(e1);
        em.enviar(e2);

        //Ivan marca en su bandeja de recibido un mensaje como favorito
        assertEquals(2, c2.bandeja.getRecibidos().size());

        c2.agregarFavoritos(e2);
        c2.agregarFavoritos(e1);

        c3.agregarFavoritos(e2);

        assertEquals(2, c2.getFavoritos().size());
        assertEquals(0, c3.getFavoritos().size());

    }


// se corrigio el merge de favoritos

}