package org.example.model;

public class Partida {

    private int id_partida;
    private int id_jugador;
    private int id_categoria;
    private String dificultad;
    private int puntaje_total;
    private int aciertos;
    private int total_preguntas;

    public Partida() {
    }

    public Partida(int id_partida, int id_jugador, int id_categoria, String dificultad, int puntaje_total, int aciertos, int total_preguntas) {
        this.id_partida = id_partida;
        this.id_jugador = id_jugador;
        this.id_categoria = id_categoria;
        this.dificultad = dificultad;
        this.puntaje_total = puntaje_total;
        this.aciertos = aciertos;
        this.total_preguntas = total_preguntas;
    }

    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getPuntaje_total() {
        return puntaje_total;
    }

    public void setPuntaje_total(int puntaje_total) {
        this.puntaje_total = puntaje_total;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getTotal_preguntas() {
        return total_preguntas;
    }

    public void setTotal_preguntas(int total_preguntas) {
        this.total_preguntas = total_preguntas;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id_partida=" + id_partida +
                ", id_jugador=" + id_jugador +
                ", id_categoria=" + id_categoria +
                ", dificultad='" + dificultad + '\'' +
                ", puntaje_total=" + puntaje_total +
                ", aciertos=" + aciertos +
                ", total_preguntas=" + total_preguntas +
                '}';
    }
}