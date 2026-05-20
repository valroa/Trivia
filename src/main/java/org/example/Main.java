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
            PreguntaDAO preguntaDAO = new PreguntaDAOImpl(connection);
            PartidaDAO partidaDAO = new PartidaDAOImpl(connection);
            RespuestaDAO respuestaDAO = new RespuestaDAOImpl(connection);
            RankingDAO rankingDAO = new RankingDAOImpl(connection);

            Scanner scanner = new Scanner(System.in);

            int opcion;

            do {

                System.out.println("MENU PRINCIPAL");
                System.out.println("1. Menu Jugador");
                System.out.println("2. Menu Categoria");
                System.out.println("3. Menu Pregunta");
                System.out.println("4. Menu Partida");
                System.out.println("5. Menu Respuesta");
                System.out.println("6. Menu Ranking");
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

                                    jugadorDAO.crear(new Jugador(0, nombre, email, puntaje));
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

                                    categoriaDAO.crear(new Categoria(0, nombreCategoria, descripcion, color));
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

                    case 3:
                        int opPregunta;

                        do {

                            System.out.println("MENU PREGUNTA");
                            System.out.println("1. Crear pregunta");
                            System.out.println("2. Leer pregunta");
                            System.out.println("3. Actualizar pregunta");
                            System.out.println("4. Eliminar pregunta");
                            System.out.println("5. Listar preguntas");
                            System.out.println("0. Volver");

                            System.out.print("Seleccione una opcion: ");
                            opPregunta = scanner.nextInt();
                            scanner.nextLine();

                            switch (opPregunta) {

                                case 1:
                                    System.out.print("ID categoria: ");
                                    int idCategoria = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Texto pregunta: ");
                                    String textoPreg = scanner.nextLine();

                                    System.out.print("Opcion A: ");
                                    String a = scanner.nextLine();

                                    System.out.print("Opcion B: ");
                                    String b = scanner.nextLine();

                                    System.out.print("Opcion C: ");
                                    String c = scanner.nextLine();

                                    System.out.print("Opcion D: ");
                                    String d = scanner.nextLine();

                                    System.out.print("Respuesta correcta (A/B/C/D): ");
                                    String respCorrecta = scanner.nextLine();

                                    System.out.print("Dificultad (facil/medio/dificil): ");
                                    String dificultad = scanner.nextLine();

                                    preguntaDAO.crear(new Pregunta(0, idCategoria, textoPreg, a, b, c, d, respCorrecta, dificultad));
                                    System.out.println("Pregunta registrada.");

                                    break;

                                case 2:

                                    System.out.print("ID pregunta: ");
                                    int idPreguntaLeer = scanner.nextInt();
                                    scanner.nextLine();

                                    Pregunta preguntaLeer = preguntaDAO.leer(idPreguntaLeer);

                                    if (preguntaLeer != null) {

                                        System.out.println(preguntaLeer);

                                    } else {

                                        System.out.println("Categoria no encontrada.");
                                    }

                                    break;

                                case 3:

                                    System.out.print("ID pregunta actualizar: ");
                                    int idPreguntaActualizar = scanner.nextInt();
                                    scanner.nextLine();

                                    Pregunta preguntaActualizar = preguntaDAO.leer(idPreguntaActualizar);

                                    if (preguntaActualizar != null) {

                                        System.out.print("Nuevo ID categoria: ");
                                        preguntaActualizar.setId_categoria(scanner.nextInt());
                                        scanner.nextLine();

                                        System.out.print("Nuevo texto: ");
                                        preguntaActualizar.setTexto_pregunta(scanner.nextLine());

                                        System.out.print("Nueva opcion A: ");
                                        preguntaActualizar.setOpcion_a(scanner.nextLine());

                                        System.out.print("Nueva opcion B: ");
                                        preguntaActualizar.setOpcion_b(scanner.nextLine());

                                        System.out.print("Nueva opcion C: ");
                                        preguntaActualizar.setOpcion_c(scanner.nextLine());

                                        System.out.print("Nueva opcion D: ");
                                        preguntaActualizar.setOpcion_d(scanner.nextLine());

                                        System.out.print("Nueva respuesta correcta: ");
                                        preguntaActualizar.setRespuesta_correcta(scanner.nextLine());

                                        System.out.print("Nueva dificultad: ");
                                        preguntaActualizar.setDificultad(scanner.nextLine());

                                        preguntaDAO.actualizar(preguntaActualizar);

                                        System.out.println("Pregunta actualizada.");

                                    } else {

                                        System.out.println("Pregunta no encontrada.");
                                    }

                                    break;

                                case 4:

                                    System.out.print("ID pregunta a eliminar: ");
                                    int idPreguntaEliminar = scanner.nextInt();
                                    scanner.nextLine();

                                    preguntaDAO.eliminar(idPreguntaEliminar);

                                    System.out.println("Pregunta eliminada.");

                                    break;

                                case 5:

                                    List<Pregunta> listaPreguntas = preguntaDAO.listar();

                                    for (Pregunta preg : listaPreguntas) {

                                        System.out.println(preg);
                                    }

                                    break;

                                case 0:

                                    System.out.println("Volviendo...");
                                    break;

                                default:

                                    System.out.println("Opcion invalida.");
                            }

                        } while (opPregunta != 0);

                        break;

                    case 4:
                        int opPartida;

                        do {

                            System.out.println("MENU PARTIDA");
                            System.out.println("1. Crear partida");
                            System.out.println("2. Leer partida");
                            System.out.println("3. Actualizar partida");
                            System.out.println("4. Eliminar partida");
                            System.out.println("5. Listar partidas");
                            System.out.println("0. Volver");

                            System.out.print("Seleccione una opcion: ");
                            opPartida = scanner.nextInt();
                            scanner.nextLine();

                            switch (opPartida) {

                                case 1:
                                    System.out.print("ID del jugador: ");
                                    int idJugador = scanner.nextInt();

                                    System.out.print("ID de la categoria: ");
                                    int idCategoria = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Dificultad (facil/medio/dificil): ");
                                    String dif = scanner.nextLine();

                                    System.out.print("Puntaje total: ");
                                    int puntajeTotal = scanner.nextInt();

                                    System.out.print("Aciertos: ");
                                    int aciertos = scanner.nextInt();

                                    System.out.print("Total preguntas: ");
                                    int totalPreguntas = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Tiempo duracion (seg): ");
                                    int tiempoDuracion = scanner.nextInt();
                                    scanner.nextLine();

                                    partidaDAO.crear(new Partida(0, idJugador, idCategoria, dif, puntajeTotal, aciertos, totalPreguntas, tiempoDuracion));
                                    System.out.println("Partida registrada.");

                                    break;

                                case 2:

                                    System.out.print("ID partida: ");
                                    int idPartidaLeer = scanner.nextInt();
                                    scanner.nextLine();

                                    Partida partidaLeer = partidaDAO.leer(idPartidaLeer);

                                    if (partidaLeer != null) {

                                        System.out.println(partidaLeer);

                                    } else {

                                        System.out.println("Partida no encontrada.");
                                    }

                                    break;

                                case 3:

                                    System.out.print("ID partida a actualizar: ");
                                    int idPartidaActualizar = scanner.nextInt();
                                    scanner.nextLine();

                                    Partida partidaActualizar = partidaDAO.leer(idPartidaActualizar);

                                    if (partidaActualizar != null) {

                                        System.out.print("Nuevo ID jugador: ");
                                        partidaActualizar.setId_jugador(scanner.nextInt());

                                        System.out.print("Nuevo ID categoria: ");
                                        partidaActualizar.setId_categoria(scanner.nextInt());
                                        scanner.nextLine();

                                        System.out.print("Nueva dificultad: ");
                                        partidaActualizar.setDificultad(scanner.nextLine());

                                        System.out.print("Nuevo puntaje total: ");
                                        partidaActualizar.setPuntaje_total(scanner.nextInt());

                                        System.out.print("Nuevos aciertos: ");
                                        partidaActualizar.setAciertos(scanner.nextInt());

                                        System.out.print("Nuevo total preguntas: ");
                                        partidaActualizar.setTotal_preguntas(scanner.nextInt());
                                        scanner.nextLine();

                                        System.out.print("Nuevo tiempo duracion: ");
                                        partidaActualizar.setTiempo_duracion(scanner.nextInt());
                                        scanner.nextLine();

                                        partidaDAO.actualizar(partidaActualizar);

                                        System.out.println("Partida actualizada.");

                                    } else {

                                        System.out.println("Partida no encontrada.");
                                    }

                                    break;

                                case 4:

                                    System.out.print("ID partida a eliminar: ");
                                    int idPartidaEliminar = scanner.nextInt();
                                    scanner.nextLine();

                                    partidaDAO.eliminar(idPartidaEliminar);

                                    System.out.println("Partida eliminada.");

                                    break;

                                case 5:

                                    List<Partida> listaPartidas = partidaDAO.listar();

                                    for (Partida part : listaPartidas) {

                                        System.out.println(part);
                                    }

                                    break;

                                case 0:

                                    System.out.println("Volviendo...");
                                    break;

                                default:

                                    System.out.println("Opcion invalida.");
                            }

                        } while (opPartida != 0);

                        break;

                    case 5:
                        int opRespuesta;

                        do {

                            System.out.println("MENU RESPUESTA");
                            System.out.println("1. Crear respuesta");
                            System.out.println("2. Leer respuesta");
                            System.out.println("3. Actualizar respuesta");
                            System.out.println("4. Eliminar respuesta");
                            System.out.println("5. Listar respuestas");
                            System.out.println("0. Volver");

                            System.out.print("Seleccione una opcion: ");
                            opRespuesta = scanner.nextInt();
                            scanner.nextLine();

                            switch (opRespuesta) {

                                case 1:
                                    System.out.print("ID de la partida: ");
                                    int idPartida = scanner.nextInt();

                                    System.out.print("ID pregunta: ");
                                    int idPregunta = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Respuesta jugador (A/B/C/D): ");
                                    String respuestaJugador = scanner.nextLine();

                                    System.out.print("Es correcta (true/false): ");
                                    boolean correcta = scanner.nextBoolean();

                                    System.out.print("Tiempo respuesta (seg): ");
                                    int tiempoRespuesta = scanner.nextInt();
                                    scanner.nextLine();

                                    respuestaDAO.crear(new Respuesta(0, idPartida, idPregunta, respuestaJugador, correcta, tiempoRespuesta));
                                    System.out.println("Respuesta registrada.");

                                    break;

                                case 2:

                                    System.out.print("ID respuesta: ");
                                    int idRespuestaLeer = scanner.nextInt();
                                    scanner.nextLine();

                                    Respuesta respuestaLeer = respuestaDAO.leer(idRespuestaLeer);

                                    if (respuestaLeer != null) {

                                        System.out.println(respuestaLeer);

                                    } else {

                                        System.out.println("Respuesta no encontrada.");
                                    }

                                    break;

                                case 3:

                                    System.out.print("ID respuesta a actualizar: ");
                                    int idRespuestaActualizar = scanner.nextInt();
                                    scanner.nextLine();

                                    Respuesta respuestaActualizar = respuestaDAO.leer(idRespuestaActualizar);

                                    if (respuestaActualizar != null) {

                                        System.out.print("Nuevo ID partida: ");
                                        respuestaActualizar.setId_partida(scanner.nextInt());

                                        System.out.print("Nuevo ID pregunta: ");
                                        respuestaActualizar.setId_pregunta(scanner.nextInt());
                                        scanner.nextLine();

                                        System.out.print("Nueva respuesta jugador: ");
                                        respuestaActualizar.setRespuesta_jugador(scanner.nextLine());

                                        System.out.print("Es correcta (true/false): ");
                                        respuestaActualizar.setEs_correcta(scanner.nextBoolean());

                                        System.out.print("Nuevo tiempo respuesta: ");
                                        respuestaActualizar.setTiempo_respuesta(scanner.nextInt());
                                        scanner.nextLine();

                                        respuestaDAO.actualizar(respuestaActualizar);

                                        System.out.println("Respuesta actualizada.");

                                    } else {

                                        System.out.println("Respuesta no encontrada.");
                                    }

                                    break;

                                case 4:

                                    System.out.print("ID respuesta a eliminar: ");
                                    int idRespuestaEliminar = scanner.nextInt();
                                    scanner.nextLine();

                                    respuestaDAO.eliminar(idRespuestaEliminar);

                                    System.out.println("Respuesta eliminada.");

                                    break;

                                case 5:

                                    List<Respuesta> listaRespuestas = respuestaDAO.listar();

                                    for (Respuesta resp : listaRespuestas) {

                                        System.out.println(resp);
                                    }

                                    break;

                                case 0:

                                    System.out.println("Volviendo...");
                                    break;

                                default:

                                    System.out.println("Opcion invalida.");
                            }

                        } while (opRespuesta != 0);

                        break;

                    case 6:
                        int opRanking;

                        do {

                            System.out.println("MENU RANKING");
                            System.out.println("1. Crear registro ranking");
                            System.out.println("2. Leer registro ranking");
                            System.out.println("3. Actualizar ranking");
                            System.out.println("4. Eliminar ranking");
                            System.out.println("5. Listar ranking");
                            System.out.println("0. Volver");

                            System.out.print("Seleccione una opcion: ");
                            opRanking = scanner.nextInt();
                            scanner.nextLine();

                            switch (opRanking) {

                                case 1:
                                    System.out.print("ID del jugador: ");
                                    int idJugador = scanner.nextInt();

                                    System.out.print("Puntaje: ");
                                    int puntaje = scanner.nextInt();

                                    System.out.print("Posicion: ");
                                    int posicion = scanner.nextInt();
                                    scanner.nextLine();

                                    rankingDAO.crear(new Ranking(0, idJugador, puntaje, posicion));
                                    System.out.println("Registro de ranking creado.");

                                    break;

                                case 2:

                                    System.out.print("ID ranking: ");
                                    int idRankingLeer = scanner.nextInt();
                                    scanner.nextLine();

                                    Ranking rankingLeer =rankingDAO.leer(idRankingLeer);

                                    if (rankingLeer != null) {

                                        System.out.println(rankingLeer);

                                    } else {

                                        System.out.println("Registro de ranking no encontrada.");
                                    }

                                    break;

                                case 3:

                                    System.out.print("ID ranking a actualizar: ");
                                    int idRankingActualizar = scanner.nextInt();
                                    scanner.nextLine();

                                    Ranking rankingActualizar = rankingDAO.leer(idRankingActualizar);

                                    if (rankingActualizar != null) {

                                        System.out.print("Nuevo ID jugador: ");
                                        rankingActualizar.setId_jugador(scanner.nextInt());

                                        System.out.print("Nuevo puntaje: ");
                                        rankingActualizar.setPuntaje(scanner.nextInt());

                                        System.out.print("Nueva posicion: ");
                                        rankingActualizar.setPosicion(scanner.nextInt());
                                        scanner.nextLine();

                                        rankingDAO.actualizar(rankingActualizar);

                                        System.out.println("Ranking actualizado.");

                                    } else {

                                        System.out.println("Ranking no encontrado.");
                                    }

                                    break;

                                case 4:

                                    System.out.print("ID ranking a eliminar: ");
                                    int idRankingEliminar = scanner.nextInt();
                                    scanner.nextLine();

                                    respuestaDAO.eliminar(idRankingEliminar);

                                    System.out.println("Ranking eliminado.");

                                    break;

                                case 5:

                                    List<Ranking> listaRanking = rankingDAO.listar();

                                    for (Ranking rank : listaRanking) {

                                        System.out.println(rank);
                                    }

                                    break;

                                case 0:

                                    System.out.println("Volviendo...");
                                    break;

                                default:

                                    System.out.println("Opcion invalida.");
                            }

                        } while (opRanking != 0);

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