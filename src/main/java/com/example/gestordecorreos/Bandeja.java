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

    public void setFavoritos(Email emailFavorito){
        this.favoritos.add(emailFavorito);
    }

    public ArrayList<Email> getFavoritos() {
        return favoritos;
    }

    
}
