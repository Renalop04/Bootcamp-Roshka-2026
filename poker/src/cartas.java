public class cartas {
    private String valor;
    private String palo;

    public cartas(String valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }

    public String recibirValor() {
        return valor;
    }

    public String recibirPalo() {
        return palo;
    }

    public String paraLaCadena(){
        return  valor + palo;
    }

}
