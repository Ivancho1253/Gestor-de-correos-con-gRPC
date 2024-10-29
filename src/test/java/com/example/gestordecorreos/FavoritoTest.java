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
        //Contacto c3 = new Contacto("Rodrigo", "Magallanes", "rodrigo@ucp.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email e1 = new Email("prueba", "hola", c1, destinatarios);
        Email e2 = new Email("prueba", "hola", c1, destinatarios);

        EmailManager em = new EmailManager();
        em.enviar(e1);
        em.enviar(e2);

        //Ivan marca en su bandeja de recibido un mensaje como favorito
        assertEquals(2, c2.bandeja.getRecibidos().size());

        em.marcarComoFavorito(e2, c2);

        assertEquals(1, c2.bandeja.favoritos.size());
        
        //Augusto marca en su bandeja de enviado un mensaje como favorito
        assertEquals(2, c1.bandeja.getEnviados().size());

        em.marcarComoFavorito(c1.bandeja.getEnviados().get(0), c1.bandeja.getFavoritos());

        assertEquals(1, c1.bandeja.favoritos.size());

        //em.marcarComoFavorito(c3.bandeja.getEnviados().get(0), c3.bandeja.getFavoritos());

        
        
    }


}