package org.example;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UniversalDao {

    // insertar generico
    public void insertar(String tabla, int id, String nombre, String campoId, String campoNombre) {
        String sql = "INSERT INTO \"Ejercicio_5\".\"" + tabla + "\" (" + campoId + ", " + campoNombre + ") VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.executeUpdate();
            System.out.println("✅ " + tabla + " insertado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Listar generico
    public void listar(String tabla, String campoId, String campoNombre) {
        String sql = "SELECT * FROM \"Ejercicio_5\".\"" + tabla + "\"";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\n=== LISTA DE " + tabla.toUpperCase() + " ===");
            while (rs.next()) {
                System.out.println(rs.getInt(campoId) + " - " + rs.getString(campoNombre));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Actualizar generico
    public void actualizar(String tabla, int id, String nuevoNombre, String campoId, String campoNombre) {
        String sql = "UPDATE \"Ejercicio_5\".\"" + tabla + "\" SET " + campoNombre + " = ? WHERE " + campoId + " = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoNombre);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("✅ " + tabla + " actualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar generico
    public void eliminar(String tabla, int id, String campoId) {
        String sql = "DELETE FROM \"Ejercicio_5\".\"" + tabla + "\" WHERE " + campoId + " = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println( tabla + " eliminado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Joins*/
    /*Join editorial a libros*/
    // ============ LIBROS CON EDITORIAL ============
    public void listarLibrosConEditorial() {
        String sql = "SELECT " +
                "l.id_libro, " +
                "l.titulo, " +
                "e.id_editorial, " +
                "e.nombre AS editorial " +
                "FROM \"Ejercicio_5\".\"Libro\" l " +
                "INNER JOIN \"Ejercicio_5\".\"Editorial\" e " +
                "ON l.id_editorial = e.id_editorial";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== 📚 LIBROS CON EDITORIAL ===");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id_libro") +
                                " | Título: " + rs.getString("titulo") +
                                " | Editorial: " + rs.getString("editorial")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*============ Aula con docencia ============*/
    // ============ DOCENCIAS COMPLETAS (CON AULA Y TODO) ============
    public void listarDocenciasCompletas() {
        String sql = "SELECT " +
                "pr.nombre AS profesor, " +
                "a.nombre AS asignatura, " +
                "cu.nombre AS curso, " +
                "au.nombre AS aula, " +
                "co.nombre AS colegio " +
                "FROM \"Ejercicio_5\".\"Docencia\" d " +
                "INNER JOIN \"Ejercicio_5\".\"Profesor\" pr ON d.id_profesor = pr.id_profesor " +
                "INNER JOIN \"Ejercicio_5\".\"Asignatura\" a ON d.id_asignatura = a.id_asignatura " +
                "INNER JOIN \"Ejercicio_5\".\"Curso\" cu ON d.id_curso = cu.id_curso " +
                "INNER JOIN \"Ejercicio_5\".\"Aula\" au ON d.id_aula = au.id_aula " +
                "INNER JOIN \"Ejercicio_5\".\"Colegio\" co ON d.id_colegio = co.id_colegio " +
                "ORDER BY co.nombre, au.nombre";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== 👨‍🏫 ASIGNACIONES DE DOCENCIA COMPLETAS ===");
            System.out.println("Formato: Colegio | Aula | Profesor | Asignatura | Curso\n");

            while (rs.next()) {
                System.out.println(
                        "🏫 " + rs.getString("colegio") +
                                " | 🚪 " + rs.getString("aula") +
                                " | 👨‍🏫 " + rs.getString("profesor") +
                                " | 📚 " + rs.getString("asignatura") +
                                " | 🎓 " + rs.getString("curso")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Necesarios
    // ============ INSERTAR LIBRO ============
    public void insertarLibro(int idLibro, String titulo, int idEditorial) {
        String sql = "INSERT INTO \"Ejercicio_5\".\"Libro\" (id_libro, titulo, id_editorial) " +
                "VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            ps.setString(2, titulo);
            ps.setInt(3, idEditorial);
            ps.executeUpdate();

            System.out.println("✅ Libro insertado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ INSERTAR DOCENCIA ============
    public void insertarDocencia(int idProfesor, int idAsignatura, int idCurso, int idAula, int idColegio) {
        String sql = "INSERT INTO \"Ejercicio_5\".\"Docencia\" " +
                "(id_profesor, id_asignatura, id_curso, id_aula, id_colegio) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idProfesor);
            ps.setInt(2, idAsignatura);
            ps.setInt(3, idCurso);
            ps.setInt(4, idAula);
            ps.setInt(5, idColegio);
            ps.executeUpdate();

            System.out.println("✅ Docencia asignada");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ INSERTAR PRÉSTAMO ============
    public void insertarPrestamo(int idPrestamo, String fecha, int idLibro, int idProfesor, int idColegio) {
        String sql = "INSERT INTO \"Ejercicio_5\".\"Prestamo_Libro\" " +
                "(id_prestamo, fecha_prestamo, id_libro, id_profesor, id_colegio) " +
                "VALUES (?, ?::date, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPrestamo);
            ps.setString(2, fecha);  // Formato: "2026-01-19"
            ps.setInt(3, idLibro);
            ps.setInt(4, idProfesor);
            ps.setInt(5, idColegio);
            ps.executeUpdate();

            System.out.println("✅ Préstamo registrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ ASIGNATURAS EN DOCENCIA ============
    public void listarAsignaturasEnDocencia() {
        String sql = "SELECT " +
                "a.id_asignatura, " +
                "a.nombre AS asignatura, " +
                "pr.nombre AS profesor, " +
                "cu.nombre AS curso, " +
                "au.nombre AS aula, " +
                "co.nombre AS colegio " +
                "FROM \"Ejercicio_5\".\"Asignatura\" a " +
                "INNER JOIN \"Ejercicio_5\".\"Docencia\" d ON a.id_asignatura = d.id_asignatura " +
                "INNER JOIN \"Ejercicio_5\".\"Profesor\" pr ON d.id_profesor = pr.id_profesor " +
                "INNER JOIN \"Ejercicio_5\".\"Curso\" cu ON d.id_curso = cu.id_curso " +
                "INNER JOIN \"Ejercicio_5\".\"Aula\" au ON d.id_aula = au.id_aula " +
                "INNER JOIN \"Ejercicio_5\".\"Colegio\" co ON d.id_colegio = co.id_colegio " +
                "ORDER BY a.nombre";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== 📚 ASIGNATURAS DICTADAS ===");
            while (rs.next()) {
                System.out.println(
                        "Asignatura: " + rs.getString("asignatura") +
                                " | Profesor: " + rs.getString("profesor") +
                                " | Curso: " + rs.getString("curso") +
                                " | Aula: " + rs.getString("aula") +
                                " | Colegio: " + rs.getString("colegio")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ RESUMEN COMPLETO POR PROFESOR ============
    public void resumenCompletoPorProfesor(int idProfesor) {
        // Parte 1: Datos del profesor
        String sqlProfesor = "SELECT nombre FROM \"Ejercicio_5\".\"Profesor\" WHERE id_profesor = ?";

        // Parte 2: Sus docencias
        String sqlDocencias = "SELECT " +
                "a.nombre AS asignatura, " +
                "cu.nombre AS curso, " +
                "au.nombre AS aula " +
                "FROM \"Ejercicio_5\".\"Docencia\" d " +
                "JOIN \"Ejercicio_5\".\"Asignatura\" a ON d.id_asignatura = a.id_asignatura " +
                "JOIN \"Ejercicio_5\".\"Curso\" cu ON d.id_curso = cu.id_curso " +
                "JOIN \"Ejercicio_5\".\"Aula\" au ON d.id_aula = au.id_aula " +
                "WHERE d.id_profesor = ?";

        // Parte 3: Sus préstamos
        String sqlPrestamos = "SELECT " +
                "l.titulo AS libro, " +
                "p.fecha_prestamo " +
                "FROM \"Ejercicio_5\".\"Prestamo_Libro\" p " +
                "JOIN \"Ejercicio_5\".\"Libro\" l ON p.id_libro = l.id_libro " +
                "WHERE p.id_profesor = ?";

        try (Connection conn = Conexion.getConexion()) {

            // Obtener nombre del profesor
            PreparedStatement ps1 = conn.prepareStatement(sqlProfesor);
            ps1.setInt(1, idProfesor);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                String nombreProfesor = rs1.getString("nombre");
                System.out.println("\n╔════════════════════════════════════════╗");
                System.out.println("║  RESUMEN: " + nombreProfesor);
                System.out.println("╚════════════════════════════════════════╝");

                // Mostrar docencias
                System.out.println("\n📚 DOCENCIAS:");
                PreparedStatement ps2 = conn.prepareStatement(sqlDocencias);
                ps2.setInt(1, idProfesor);
                ResultSet rs2 = ps2.executeQuery();

                int countDocencias = 0;
                while (rs2.next()) {
                    countDocencias++;
                    System.out.println(
                            "  " + countDocencias + ". " + rs2.getString("asignatura") +
                                    " - " + rs2.getString("curso") +
                                    " (Aula: " + rs2.getString("aula") + ")"
                    );
                }
                if (countDocencias == 0) System.out.println("  ⚠️ Sin docencias asignadas");

                // Mostrar préstamos
                System.out.println("\n📖 PRÉSTAMOS:");
                PreparedStatement ps3 = conn.prepareStatement(sqlPrestamos);
                ps3.setInt(1, idProfesor);
                ResultSet rs3 = ps3.executeQuery();

                int countPrestamos = 0;
                while (rs3.next()) {
                    countPrestamos++;
                    System.out.println(
                            "  " + countPrestamos + ". " + rs3.getString("libro") +
                                    " (Fecha: " + rs3.getDate("fecha_prestamo") + ")"
                    );
                }
                if (countPrestamos == 0) System.out.println("  ⚠️ Sin préstamos");

                System.out.println("\n" + "═".repeat(44));
                System.out.println("Total docencias: " + countDocencias + " | Total préstamos: " + countPrestamos);

            } else {
                System.out.println("❌ Profesor no encontrado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ PRÉSTAMOS COMPLETOS ============
    public void listarPrestamosCompletos() {
        String sql = "SELECT " +
                "p.id_prestamo, " +
                "p.fecha_prestamo, " +
                "l.titulo AS libro, " +
                "e.nombre AS editorial, " +
                "pr.nombre AS profesor, " +
                "c.nombre AS colegio " +
                "FROM \"Ejercicio_5\".\"Prestamo_Libro\" p " +
                "INNER JOIN \"Ejercicio_5\".\"Libro\" l ON p.id_libro = l.id_libro " +
                "INNER JOIN \"Ejercicio_5\".\"Editorial\" e ON l.id_editorial = e.id_editorial " +
                "INNER JOIN \"Ejercicio_5\".\"Profesor\" pr ON p.id_profesor = pr.id_profesor " +
                "INNER JOIN \"Ejercicio_5\".\"Colegio\" c ON p.id_colegio = c.id_colegio " +
                "ORDER BY p.fecha_prestamo DESC";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== 📖 HISTORIAL DE PRÉSTAMOS ===");
            while (rs.next()) {
                System.out.println(
                        "Préstamo #" + rs.getInt("id_prestamo") +
                                " | 📅 " + rs.getDate("fecha_prestamo") +
                                " | 📚 " + rs.getString("libro") +
                                " (" + rs.getString("editorial") + ")" +
                                " | 👨‍🏫 " + rs.getString("profesor") +
                                " | 🏫 " + rs.getString("colegio")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

