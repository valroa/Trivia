package org.example;

import org.example.dao.*;
import org.example.model.*;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection connection = ConexionBD.obtenerConexion()) {

            JugadorDAO jugadorDAO = new JugadorDAOImpl(connection);
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl(connection);

            Scanner scanner = new Scanner(System.in);

            int opcion;

            do {

                System.out.println("MENU PRINCIPAL");
                System.out.println("1. Menu Jugador");
                System.out.println("2. Menu Categoria");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opcion: ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {

                    case 1:

                        int opJugador;

                        do {

                            System.out.println("MENU JUGADOR");
                            System.out.println("1. Crear jugador");
                            System.out.println("2. Leer jugador");
                            System.out.println("3. Actualizar jugador");
                            System.out.println("4. Eliminar jugador");
                            System.out.println("5. Listar jugadores");
                            System.out.println("0. Volver");

                            System.out.print("Seleccione una opcion: ");
                            opJugador = scanner.nextInt();
                            scanner.nextLine();

                            switch (opJugador) {

                                case 1:

                                    System.out.print("Nombre: ");
                                    String nombre = scanner.nextLine();

                                    System.out.print("Email: ");
                                    String email = scanner.nextLine();

                                    System.out.print("Puntaje total: ");
                                    int puntaje = scanner.nextInt();
                                    scanner.nextLine();

                                    Jugador jugador = new Jugador(
                                            0,
                                            nombre,
                                            email,
                                            puntaje
                                    );

                                    jugadorDAO.crear(jugador);

                                    System.out.println("Jugador registrado.");
                                    break;

                                case 2:

                                    System.out.print("ID del jugador: ");
                                    int idLeer = scanner.nextInt();
                                    scanner.nextLine();

                                    Jugador jugadorLeer = jugadorDAO.leer(idLeer);

                                    if (jugadorLeer != null) {

                                        System.out.println(jugadorLeer);

                                    } else {

                                        System.out.println("Jugador no encontrado.");
                                    }

                                    break;

                                case 3:

                                    System.out.print("ID del jugador a actualizar: ");
                                    int idActualizar = scanner.nextInt();
                                    scanner.nextLine();

                                    Jugador jugadorActualizar = jugadorDAO.leer(idActualizar);

                                    if (jugadorActualizar != null) {

                                        System.out.print("Nuevo nombre: ");
                                        jugadorActualizar.setNombre(scanner.nextLine());

                                        System.out.print("Nuevo email: ");
                                        jugadorActualizar.setEmail(scanner.nextLine());

                                        System.out.print("Nuevo puntaje: ");
                                        jugadorActualizar.setPuntaje_total(scanner.nextInt());
                                        scanner.nextLine();

                                        jugadorDAO.actualizar(jugadorActualizar);

                                        System.out.println("Jugador actualizado.");

                                    } else {

                                        System.out.println("Jugador no encontrado.");
                                    }

                                    break;

                                case 4:

                                    System.out.print("ID del jugador a eliminar: ");
                                    int idEliminar = scanner.nextInt();
                                    scanner.nextLine();

                                    jugadorDAO.eliminar(idEliminar);

                                    System.out.println("Jugador eliminado.");

                                    break;

                                case 5:

                                    List<Jugador> listaJugadores = jugadorDAO.listar();

                                    for (Jugador j : listaJugadores) {

                                        System.out.println(j);
                                    }

                                    break;

                                case 0:

                                    System.out.println("Volviendo...");
                                    break;

                                default:

                                    System.out.println("Opcion invalida.");
                            }

                        } while (opJugador != 0);

                        break;

                    case 2:

                        int opCategoria;

                        do {

                            System.out.println("MENU CATEGORIA");
                            System.out.println("1. Crear categoria");
                            System.out.println("2. Leer categoria");
                            System.out.println("3. Actualizar categoria");
                            System.out.println("4. Eliminar categoria");
                            System.out.println("5. Listar categorias");
                            System.out.println("0. Volver");

                            System.out.print("Seleccione una opcion: ");
                            opCategoria = scanner.nextInt();
                            scanner.nextLine();

                            switch (opCategoria) {

                                case 1:

                                    System.out.print("Nombre: ");
                                    String nombreCategoria = scanner.nextLine();

                                    System.out.print("Descripcion: ");
                                    String descripcion = scanner.nextLine();

                                    System.out.print("Color: ");
                                    String color = scanner.nextLine();

                                    Categoria categoria = new Categoria(
                                            0,
                                            nombreCategoria,
                                            descripcion,
                                            color
                                    );

                                    categoriaDAO.crear(categoria);

                                    System.out.println("Categoria registrada.");

                                    break;

                                case 2:

                                    System.out.print("ID categoria: ");
                                    int idCategoriaLeer = scanner.nextInt();
                                    scanner.nextLine();

                                    Categoria categoriaLeer = categoriaDAO.leer(idCategoriaLeer);

                                    if (categoriaLeer != null) {

                                        System.out.println(categoriaLeer);

                                    } else {

                                        System.out.println("Categoria no encontrada.");
                                    }

                                    break;

                                case 3:

                                    System.out.print("ID categoria actualizar: ");
                                    int idCategoriaActualizar = scanner.nextInt();
                                    scanner.nextLine();

                                    Categoria categoriaActualizar = categoriaDAO.leer(idCategoriaActualizar);

                                    if (categoriaActualizar != null) {

                                        System.out.print("Nuevo nombre: ");
                                        categoriaActualizar.setNombre(scanner.nextLine());

                                        System.out.print("Nueva descripcion: ");
                                        categoriaActualizar.setDescripcion(scanner.nextLine());

                                        System.out.print("Nuevo color: ");
                                        categoriaActualizar.setColor(scanner.nextLine());

                                        categoriaDAO.actualizar(categoriaActualizar);

                                        System.out.println("Categoria actualizada.");

                                    } else {

                                        System.out.println("Categoria no encontrada.");
                                    }

                                    break;

                                case 4:

                                    System.out.print("ID categoria eliminar: ");
                                    int idCategoriaEliminar = scanner.nextInt();
                                    scanner.nextLine();

                                    categoriaDAO.eliminar(idCategoriaEliminar);

                                    System.out.println("Categoria eliminada.");

                                    break;

                                case 5:

                                    List<Categoria> listaCategorias = categoriaDAO.listar();

                                    for (Categoria c : listaCategorias) {

                                        System.out.println(c);
                                    }

                                    break;

                                case 0:

                                    System.out.println("Volviendo...");
                                    break;

                                default:

                                    System.out.println("Opcion invalida.");
                            }

                        } while (opCategoria != 0);

                        break;

                    case 0:

                        System.out.println("Saliendo...");
                        break;

                    default:

                        System.out.println("Opcion invalida.");
                }

            } while (opcion != 0);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}