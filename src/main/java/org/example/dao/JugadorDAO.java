package org.example.dao;

import org.example.model.Jugador;

import java.util.List;

public interface JugadorDAO {

    void crear(Jugador jugador);

    Jugador leer(int id);

    void actualizar(Jugador jugador);

    void eliminar(int id);

    List<Jugador> listar();
}