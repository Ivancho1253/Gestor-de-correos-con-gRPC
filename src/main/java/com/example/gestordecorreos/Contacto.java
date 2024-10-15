package com.example.gestordecorreos;

public class Contacto {

    public String nombre;
    public String apellido;
    public String correo;
    public Bandeja bandeja;
    
  
    public Contacto(String nombre,String apellido, String correo) {  //Constructor con parametros
        setNombre(nombre);
        setApellido(apellido);   
        setCorreo(correo);
        this.bandeja = new Bandeja();
    }

    public String getCorreo() {
        return correo;
    }

    private  void setCorreo(String correo) {

        if (validarCorreo(correo)) {
            this.correo = correo;

        } else {

            throw new IllegalArgumentException("Correo no válido");
            
        }
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean validarCorreo(String correo) {
        // Expresión regular que valida que contiene una arroba
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        return correo.matches(regex);
    }
    

}
