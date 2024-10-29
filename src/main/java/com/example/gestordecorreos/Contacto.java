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
        
        @Override
        public void agregarFavoritos(Email emailFavorito) {
            // Buscar en la bandeja de recibidos
            for (Email email : bandeja.getRecibidos()) {
                if (compararEmails(email, emailFavorito)) {
                    bandeja.setFavoritos(emailFavorito);
                    break;
                }
            }

            // Buscar en la bandeja de enviados
            for (Email email : bandeja.getEnviados()) {
                if (compararEmails(email, emailFavorito)) {
                    bandeja.setFavoritos(emailFavorito);
                    break;
                }
            }
        }

        private boolean compararEmails(Email email1, Email email2) {
            // Comparamos los atributos clave de los emails
            boolean mismoAsunto = email1.getAsunto().equals(email2.getAsunto());
            boolean mismoCuerpo = email1.getContenido().equals(email2.getContenido());
            boolean mismoRemitente = email1.getRemitente().equals(email2.getRemitente());

            // Comparar los destinatarios
            boolean mismosDestinatarios = email1.getDestinatarios().size() == email2.getDestinatarios().size() 
                && email1.getDestinatarios().containsAll(email2.getDestinatarios());

            // Si todos los atributos son iguales, entonces los emails son equivalentes
            return mismoAsunto && mismoCuerpo && mismoRemitente && mismosDestinatarios;
        }





/* 
        /////////////////////////
        @Override
        public void agregarFavoritos(Email emailFavorito) {
            
            // Buscar en la bandeja de recibidos

            for (Email email : bandeja.getRecibidos()) {
                if (email.equals(emailFavorito)) {
                    bandeja.setFavoritos(emailFavorito);
                    break;
                }
                
            }

            for (Email email : bandeja.getEnviados()) {
                if (email.equals(emailFavorito)) {
                    bandeja.setFavoritos(emailFavorito);
                    break;
                }
            }

        }*/
        
        @Override
        public ArrayList <Email> getFavoritos(){
            return bandeja.getFavoritos();
        }

    }
