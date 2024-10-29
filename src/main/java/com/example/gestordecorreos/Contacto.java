    package com.example.gestordecorreos;
    import java.util.ArrayList;

    public class Contacto 
            implements IFavoritos{

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
        

        /////////////////////////
        @Override
        public void agregarFavoritos(Email emailFavorito) {
            
            for (Email email : bandeja.getRecibidos()) {

                if (email.equals(emailFavorito)) {
                    bandeja.setFavoritos(emailFavorito);
                    return; // Se encontró y agregó, no es necesario seguir buscando
                }
            }
        
            for (Email email : bandeja.getEnviados()) {

                if (email.equals(emailFavorito)) {
                    bandeja.setFavoritos(emailFavorito);
                    return;
                }
            }
        }
        
        


        @Override
        public ArrayList <Email> getFavoritos(){
            return bandeja.getFavoritos();
        }

    }
