package org.example.model;

public class Jugador {

    private int id_jugador;
    private String nombre;
    private String email;
    private int puntaje_total;

    public Jugador() {
    }

    public Jugador(int id_jugador, String nombre, String email, int puntaje_total) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.email = email;
        this.puntaje_total = puntaje_total;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntaje_total() {
        return puntaje_total;
    }

    public void setPuntaje_total(int puntaje_total) {
        this.puntaje_total = puntaje_total;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id_jugador=" + id_jugador +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", puntaje_total=" + puntaje_total +
                '}';
    }
}