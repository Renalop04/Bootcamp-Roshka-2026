package Objetos;

public class Prestamo_Libro {
    private int id_prestamo;
    private String fecha_prestamo;
    private int id_libro;
    private int id_profesor;
    private int id_colegio;

    public void Prestamos_Libro(){
        this.id_prestamo = id_prestamo;
        this.fecha_prestamo = fecha_prestamo;
        this.id_libro = id_libro;
        this.id_profesor = id_profesor;
        this.id_colegio = id_colegio;
    }

    public int getId_colegio() {
        return id_colegio;
    }

    public int getId_libro() {
        return id_libro;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }
}

