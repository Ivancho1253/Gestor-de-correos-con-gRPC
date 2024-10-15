package com.example.gestordecorreos;
import java.util.List;

public final class LosPibes 
            extends Grupo {

    public LosPibes(List<Contacto> contactos) {
        super(contactos); // Llamar al constructor de Grupo que acepta una lista de contactos

    }
    
    public LosPibes(){
        super();
        agregarMiembro(new Contacto("Augusto", "Ojeda", "augustojedamathe@gmail.com"));
        agregarMiembro(new Contacto("Ivan", "Cabrera", "ivangonzalo1253@gmail.com"));
        agregarMiembro(new Contacto("Rodrigo", "Magallanes", "rodri123@gmail.com"));
        agregarMiembro(new Contacto("Joaquin", "Flores", "joaco123@gmail.com"));
    }

    public void agregarMiembro(Contacto contacto) {
        super.agregarContacto(contacto); 

    }

    public List<Contacto> obtenerMiembros() {
        return getContactos(); 
    }
}
