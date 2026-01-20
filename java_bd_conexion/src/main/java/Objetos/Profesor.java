package Objetos;

public class Profesor {
    private int IDprofesor;
    private String nombre;

    public Profesor(int IDprofesor, String nombre){
        this.IDprofesor = IDprofesor;
        this.nombre = nombre;
    }

    public int getIDprofesor() {
        return IDprofesor;
    }

    public String getNombre(){
        return nombre;
    }
}
