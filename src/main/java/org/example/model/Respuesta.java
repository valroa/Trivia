package org.example.model;

public class Respuesta {

    private int id_respuesta;
    private int id_partida;
    private int id_pregunta;
    private String respuesta_jugador;
    private boolean es_correcta;
    private int tiempo_respuesta;

    public Respuesta() {
    }

    public Respuesta(int id_respuesta, int id_partida, int id_pregunta, String respuesta_jugador, boolean es_correcta, int tiempo_respuesta) {
        this.id_respuesta = id_respuesta;
        this.id_partida = id_partida;
        this.id_pregunta = id_pregunta;
        this.respuesta_jugador = respuesta_jugador;
        this.es_correcta = es_correcta;
        this.tiempo_respuesta = tiempo_respuesta;
    }

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta_jugador() {
        return respuesta_jugador;
    }

    public void setRespuesta_jugador(String respuesta_jugador) {
        this.respuesta_jugador = respuesta_jugador;
    }

    public boolean isEs_correcta() {
        return es_correcta;
    }

    public void setEs_correcta(boolean es_correcta) {
        this.es_correcta = es_correcta;
    }

    public int getTiempo_respuesta() {
        return tiempo_respuesta;
    }

    public void setTiempo_respuesta(int tiempo_respuesta) {
        this.tiempo_respuesta = tiempo_respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "id_respuesta=" + id_respuesta +
                ", id_partida=" + id_partida +
                ", id_pregunta=" + id_pregunta +
                ", respuesta_jugador='" + respuesta_jugador + '\'' +
                ", es_correcta=" + es_correcta +
                ", tiempo_respuesta=" + tiempo_respuesta +
                '}';
    }
}