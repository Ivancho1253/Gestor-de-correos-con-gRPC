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

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email e1 = new Email("prueba", "hola", c1, destinatarios);
        Email e2 = new Email("prueba", "hola", c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(e1);
        em.enviar(e2);

        assertEquals(2, c2.bandeja.getRecibidos().size());

       // em.marcarComoFavorito(e2, c2.bandeja);

        assertEquals(1, em.getFavoritos(c2.bandeja).size());
    }


}