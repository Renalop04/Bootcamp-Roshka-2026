package Objetos;

public class Docencia {
    private int id_profesor;
    private int id_asignatura;
    private int id_curso;
    private int id_aula;
    private int id_colegio;

    public void Docencia(){
        this.id_profesor = id_profesor;
        this.id_asignatura = id_asignatura;
        this.id_curso = id_curso;
        this.id_aula = id_aula;
        this.id_colegio = id_colegio;
    }

    public int getId_profesor(){
        return id_profesor;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public int getId_curso() {
        return id_curso;
    }

    public int getId_aula() {
        return id_aula;
    }

    public int getId_colegio() {
        return id_colegio;
    }
}
