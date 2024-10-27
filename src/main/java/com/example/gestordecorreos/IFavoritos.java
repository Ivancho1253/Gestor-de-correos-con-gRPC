package com.example.gestordecorreos;
import java.util.ArrayList;

public interface IFavoritos {


    public void agregarFavoritos(Email emailFavorito, Bandeja favoritos);

    public ArrayList <Email> getFavoritos(Bandeja favoritos);

}