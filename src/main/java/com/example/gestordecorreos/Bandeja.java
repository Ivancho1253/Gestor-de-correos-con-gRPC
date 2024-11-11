package com.example.gestordecorreos;
import java.util.ArrayList;

public class Bandeja {

    ArrayList <Email> recibidos;
    ArrayList <Email> enviados;
    ArrayList <Email> favoritos;

    public Bandeja() {
        this.recibidos = new ArrayList<>();
        this.enviados = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    public ArrayList<Email> getRecibidos() {
        return recibidos;
    }

    public ArrayList<Email> getEnviados() {
        return enviados;
    }

    public ArrayList<Email> getFavoritos() {

        return favoritos;
    }

    public void setFavoritos(Email emailFavorito){

        if (!favoritos.contains(emailFavorito)) {
            favoritos.add(emailFavorito);
            System.out.println("Correo marcado como favorito.");

        }else{
            System.out.println("Este correo ya está en favoritos.");

        }
           
    }

    
}