package com.example.gestordecorreos;
import java.util.ArrayList;

public class Bandeja {

    ArrayList <Email> recibidos;
    ArrayList <Email> enviados;
    
    public Bandeja() {
        this.recibidos = new ArrayList<>();
        this.enviados = new ArrayList<>();
    }

    public ArrayList<Email> getRecibidos() {
        return recibidos;
    }

    public ArrayList<Email> getEnviados() {
        return enviados;
    }

    
}
