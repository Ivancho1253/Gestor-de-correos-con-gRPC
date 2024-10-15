package com.example.gestordecorreos;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void MandarUnEmailTest(){

        Contacto c1 = new Contacto("Augusto", "Ojeda", "augustojedamathe@gmail.com");
        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);

        Email email1 = new Email("Hola","Hola soy Augusto",c1,destinatarios);

        assertEquals(email1.getAsunto(), "Hola");
        assertEquals(email1.getContenido(), "Hola soy Augusto");
        assertEquals(email1.getRemitente(), c1);
        assertEquals(email1.getDestinatarios(),destinatarios);
        
    }

    @Test
    public void MandarUnEmailCompletoTest(){
        Contacto c1 = new Contacto("Augusto","ojeda", "augustojedamathe@gmail.com");

        Contacto c2 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");

        List<Contacto> destinatarios = new ArrayList<>();
        destinatarios.add(c2);


        Email email=new Email("Rodri","venir",c1,destinatarios);



        assertEquals(email.getAsunto(), "Rodri");
        assertEquals(email.getContenido(), "venir");
        assertEquals(email.getRemitente(), c1);
        assertEquals(email.getDestinatarios(),destinatarios);
        
    }

    
}
