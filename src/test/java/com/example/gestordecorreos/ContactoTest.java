package com.example.gestordecorreos;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        List<Contacto> LosPibes = new ArrayList<>();
        LosPibes.add(c1);
        LosPibes.add(c2);
        LosPibes.add(c3);

        // Crear el grupo con esa lista de contactos

        assertEquals(3, LosPibes.size()); 
        assertTrue(LosPibes.contains(c1));
        assertTrue(LosPibes.contains(c2));
        assertTrue(LosPibes.contains(c3)); 
    }
    @Test
    public void crearContactoConPibes() {
        List<Contacto> listaContactos = new ArrayList<>();
        listaContactos.add(new Contacto("Juan", "Perez", "juanperez@gmail.com"));
        listaContactos.add(new Contacto("Maria", "Gomez", "mariagomez@gmail.com"));

        LosPibes grupo = new LosPibes(listaContactos);
        assertEquals(2, grupo.obtenerMiembros().size());
        assertEquals("Juan", grupo.obtenerMiembros().get(0).getNombre());
        assertEquals("Maria", grupo.obtenerMiembros().get(1).getNombre());
    }

}


    

