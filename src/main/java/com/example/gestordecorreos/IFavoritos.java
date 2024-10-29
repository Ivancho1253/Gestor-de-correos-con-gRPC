package com.example.gestordecorreos;
import java.util.ArrayList;

public interface IFavoritos {

    public void agregarFavoritos(Email emailFavorito);

    public ArrayList <Email> getFavoritos();

}