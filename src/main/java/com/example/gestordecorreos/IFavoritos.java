package com.example.gestordecorreos;
import java.util.ArrayList;

public interface IFavoritos {


    public void agregarFavoritos(Email emailFavorito, ArrayList <Email> favoritos);

    public ArrayList <Email> getFavoritos(ArrayList <Email> bandejaFavoritos);

}