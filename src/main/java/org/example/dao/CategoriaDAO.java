package org.example.dao;

import org.example.model.Categoria;

import java.util.List;

public interface CategoriaDAO {

    void crear(Categoria categoria);

    Categoria leer(int id);

    void actualizar(Categoria categoria);

    void eliminar(int id);

    List<Categoria> listar();
}