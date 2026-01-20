package Objetos;

public class Colegio {
    private int Id_colegio;
    private String nombre;

    public Colegio(int Id_colegio, String nombre){
        this.Id_colegio = Id_colegio;
        this.nombre = nombre;
    }

    public int getId_colegio() {
        return Id_colegio;
    }

    public String getNombre() {
        return nombre;
    }
}
