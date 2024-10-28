package com.example.gestordecorreos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class ContactoTest {
    
    @Test
    public void crearContacto() {
       Contacto c1 = new Contacto("Augusto", "Ojeda", "augustojedamathe@gmail.com");

       assertEquals("Augusto",c1.getNombre());
       assertEquals("Ojeda", c1.getApellido());
       assertEquals("augustojedamathe@gmail.com", c1.getCorreo());

    }

    @Test
    public void crearContacto2() {

        Contacto c1 = new Contacto("Ivan","Cabrera", "ivangonzalo1253@gmail.com");

        assertEquals("Ivan", c1.nombre);
        assertEquals("Cabrera", c1.apellido);
        assertEquals("ivangonzalo1253@gmail.com", c1.getCorreo());

    }
    
  
    @Test
     public void crearContactoInvalido1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contacto("Rodrigo", "Magallanes", "rodri@gmail");
            
         });
     }

     @Test
     public void crearContactoInvalido2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contacto("Rodrigo", "Magallanes", "rodri123gmail.com");
            
         });
    }

    @Test
    public void Crear_grupo_con_contactos() {
        
        // Crear contactos individuales
        Contacto c1 = new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com");
        Contacto c2 = new Contacto("Augusto", "Ojeda", "augustojedamathe@gmail.com");
        Contacto c3 = new Contacto("Rodrigo", "Magallanes", "rodrigomagallanes0@gmail.com");

        // Crear una lista de contactos
        GruposDeUsuarios grupo = new GruposDeUsuarios();

        grupo.agregarAlGrupo(c1);
        grupo.agregarAlGrupo(c2);
        grupo.agregarAlGrupo(c3);

        // Crear el grupo con esa lista de contactos

        assertEquals(3, grupo.obtenerMiembros().size()); 
    }

    
    @Test
    public void crearContactoConPibes() {

        Contacto c1 = new Contacto("Juan", "Perez", "juanperez@gmail.com");
        Contacto c2= new Contacto("Maria", "Gomez", "mariagomez@gmail.com");

        GruposDeUsuarios grupo = new GruposDeUsuarios();
        
        grupo.agregarAlGrupo(c1);
        grupo.agregarAlGrupo(c2);
        
        assertEquals(2, grupo.obtenerMiembros().size());
        assertEquals("Juan", grupo.obtenerMiembros().get(0).getNombre());
        assertEquals("Maria", grupo.obtenerMiembros().get(1).getNombre());
    }

}


    

