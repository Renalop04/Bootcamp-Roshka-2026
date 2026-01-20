package org.example;

public class Main {
    public static void main(String[] args) {

        UniversalDao dao = new UniversalDao();

        // ========= INSERTS BÁSICOS =========
        dao.insertar("Colegio", 1, "Colegio Nacional", "id_colegio", "nombre");
        dao.insertar("Profesor", 1, "Juan Pérez", "id_profesor", "nombre");
        dao.insertar("Asignatura", 1, "Matemática", "id_asignatura", "nombre");
        dao.insertar("Curso", 1, "3ro A", "id_curso", "nombre");
        dao.insertar("Aula", 1, "Aula 101", "id_aula", "nombre");
        dao.insertar("Editorial", 1, "Santillana", "id_editorial", "nombre");

        // ========= LISTAR =========
        dao.listar("Profesor", "id_profesor", "nombre");
        dao.listar("Asignatura", "id_asignatura", "nombre");

        // ========= INSERTS CON FK =========
        dao.insertarLibro(1, "Álgebra Básica", 1);
        dao.insertarDocencia(1, 1, 1, 1, 1);
        dao.insertarPrestamo(1, "2026-01-19", 1, 1, 1);

        // ========= JOINS =========
        dao.listarLibrosConEditorial();
        dao.listarDocenciasCompletas();
        dao.listarPrestamosCompletos();

        // ========= RESUMEN =========
        dao.resumenCompletoPorProfesor(1);
    }
}
