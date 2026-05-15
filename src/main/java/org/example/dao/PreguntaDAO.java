package org.example.dao;

import org.example.model.Pregunta;

import java.util.List;

public interface PreguntaDAO {

    void crear(Pregunta pregunta);

    Pregunta leer(int id);

    void actualizar(Pregunta pregunta);

    void eliminar(int id);

    List<Pregunta> listar();
}
