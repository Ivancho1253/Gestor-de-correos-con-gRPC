package com.example.gestordecorreos;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Filtro {
    
    public String nombre;
    public Predicate <Email> predicado;

    public Filtro(String nombre,Predicate<Email>predicado){
        setNombre(nombre);
        setPredicado(predicado);
    }
    public Filtro(){
        
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Predicate<Email> getPredicado(){
        return predicado;
    }

    private void setPredicado(Predicate<Email> predicado) {
        this.predicado = predicado;
    }
    //Filtro para buscar email por remitente 
    public List <Email> filtrarPorRemitente(Contacto persona, List <Email> bandejaFiltrada) {
        
        return bandejaFiltrada.stream()
                      .filter(email -> email.getRemitente().equals(persona))
                      .collect(Collectors.toList());
    }
    

    //Filtro para buscar email por destinatario 
    public List<Email> filtrarPorDestinatario(Contacto persona, List<Email> bandejaFiltrada) {
    return bandejaFiltrada.stream()
            .filter(email -> email.getDestinatarios().stream()
                                  .anyMatch(destinatario -> destinatario.equals(persona)))
            .collect(Collectors.toList());
}
   

    //Filtro para buscar un email por Asunto
    public List<Email> filtrarPorAsunto(String asunto, List<Email> bandejaFiltrada) {
        String asuntoLower = asunto.toLowerCase();
        return bandejaFiltrada.stream()
                    .filter(email -> email.getAsunto().toLowerCase().contains(asuntoLower))
                    .collect(Collectors.toList());
    }

    
    //Filtro para buscar un email por palabras claves (plabra u oracion)
    public List<Email> filtrarPorPalabrasClaves(String palabraClave, List<Email> bandejaFiltrada) {
        String palabraClaveLower = palabraClave.toLowerCase(); // Transformar la palabra clave a minúsculas
        return bandejaFiltrada.stream()
                  .filter(email -> email.getContenido().toLowerCase().contains(palabraClaveLower)) // Buscar palabra en el contenido
                  .collect(Collectors.toList());
    }
    

    // Método para buscar emails según un filtro
    public List<Email> buscarConFiltro(Filtro filtro, List<Email> bandejaFiltrada) {
        // Aplica el predicado del filtro a la bandeja de correos
        Predicate<Email> predicado = filtro.getPredicado();
        return bandejaFiltrada.stream()
                              .filter(predicado)
                              .collect(Collectors.toList());
    }

    

}
