package org.example.model;

public class Ranking {

    private int id_ranking;
    private int id_jugador;
    private int puntaje;
    private int posicion;

    public Ranking() {
    }

    public Ranking(int id_ranking, int id_jugador, int puntaje, int posicion) {
        this.id_ranking = id_ranking;
        this.id_jugador = id_jugador;
        this.puntaje = puntaje;
        this.posicion = posicion;
    }

    public int getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id_ranking=" + id_ranking +
                ", id_jugador=" + id_jugador +
                ", puntaje=" + puntaje +
                ", posicion=" + posicion +
                '}';
    }
}
