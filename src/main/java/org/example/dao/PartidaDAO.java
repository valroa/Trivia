package org.example.dao;

import org.example.model.Partida;

import java.util.List;

public interface PartidaDAO {

    void crear(Partida partida);

    Partida leer(int id);

    void actualizar(Partida partida);

    void eliminar(int id);

    List<Partida> listar();
}