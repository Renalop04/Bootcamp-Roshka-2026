//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ejercicio que quiera ver (Ejercicioxx del 1 al 10)");
        String ejercicio = sc.nextLine();
        ejercicio.toLowerCase();

        switch (ejercicio){
            case "ejercicio01":
                int a = 32;
                int b = 64;
                System.out.println("La suma de a y b es: "+ ( a + b ));
                System.out.println("La resta de a y b es: "+ ( a - b ));
                System.out.println("La multiplicacion de a y b es: "+ ( a * b ));
                System.out.println("La division de b y a es: "+ ( b / a ));
                System.out.println("El modulo a y b es: "+ ( a % b ));
                break;

            case "ejercicio02":
                 a = 32;
                 b = 64;
                if (a == b){
                    System.out.println("Las letras a y b son iguales");
                }else if ( a > b) {
                    System.out.println("Las letra a es mayor a b");
                }else{
                    System.out.println("La letra b es mayor a a");
                }

                break;
            case "ejercicio03":
                String nombre = "Renato";
                System.out.println("Bienvenido " + nombre);
                break;

            case "ejercicio04":
                String nnombre = sc.nextLine();
                System.out.println("Bienvenido " + nnombre);
                break;

            case "ejercicio05":
                int numero = sc.nextInt();
                if ( numero % 2 == 0 ){
                    System.out.println("El numero es divisible por 2");
                }else{
                    System.out.println("El numero no es divisible por 2");
                }
                break;

            case "ejercicio06":
                        numero = sc.nextInt();
                    int precio = (numero * 10) / 100;
                System.out.println("El precio final es: "+ (numero + precio) );
                break;

            case "ejercicio07":
                int i;
                for (i = 0 ; i < 101 ; i++){
                    if(i % 2 == 0 && i % 3 == 0){
                        System.out.println("Los numeros divisibles por 2 y 3 son " + i);
                    }
                }
                break;

            case "ejercicio08":
                System.out.println("Ingrese un numero");
                do{
                    numero = sc.nextInt();
                    if(numero < 0){
                        System.out.println("El numero es incorrecto ingresa un numero mayor a 0");
                    }
                }while (numero < 0);

                break;

            case "ejercicio09":
                String contrasenha = "Roshka";
                String contra;
                    i = 0;
                boolean bandera = true;
                System.out.println("Adivina la contrasenha tiene 3 intentos");

                do{
                    i++;
                    contra = sc.nextLine();
                    if(!contra.equals(contrasenha)){
                        System.out.println("Contrasenha incorrecta tiene " + (3-i) + " intentos");
                        if(i == 3){
                            bandera = false;
                        }
                    }else{
                        System.out.println("Felicidades acertaste la contrasenha");
                        bandera = false;
                    }
                }while (bandera);
                break;

            case "ejercicio10":
                System.out.println("Ingrese un dia de la semana y le dire si es dia laboral");
                String dia = sc.nextLine();
                dia.toLowerCase();

                switch (dia){
                    case "lunes":
                        System.out.println("El dia lunes es dia laboral");
                        break;
                    case "martes":
                        System.out.println("El dia martes es dia laboral");
                        break;
                    case "miercoles":
                        System.out.println("El dia miercoles es dia laboral");
                        break;
                    case "jueves":
                        System.out.println("El dia jueves es dia laboral");
                        break;
                    case "viernes":
                        System.out.println("El dia viernes es dia laboral");
                        break;
                    case "sabado":
                        System.out.println("El dia sabado no es dia laboral");
                        break;
                    case "domingo":
                        System.out.println("El dia domingo no es dia laboral");
                        break;
                    default:
                        System.out.println("No existe un dia de la semana con ese nombre");
                }

                break;

            default:
                System.out.println("No existe un ejercicio con ese nombre");
        }
    }
}