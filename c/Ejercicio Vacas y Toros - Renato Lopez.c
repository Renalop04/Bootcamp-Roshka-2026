#include <stdio.h>
#include <time.h>
#include <stdlib.h> 
#include <stdbool.h>

void numero_jugador(char numero_ingresado[], bool *bandera_1, bool *valido);
void comparacion_numeros(char numero_ingresado[], char numeros[], int *vaca, int *toro);

int main(){
    //Entrada creacion de variables y lista de numero random
    srand(time(NULL));
    bool bandera = true, bandera_1 = true, valido = false;
    char numeros[5];
    char numero_ingresado[10];
    int i, j,vaca = 0, toro = 0;
    
    //proceso
    printf("Te desafio a adivinar un numero de 4 digitos\n");
    for (i = 0; i < 4; i++) {
    bool repetido;
    char nuevo;

        do {
            repetido = false;
            nuevo = (rand() % 10) + '0';

            for (j = 0; j < i; j++) {
                if (numeros[j] == nuevo) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);

        numeros[i] = nuevo;
    }

    numeros[4] = '\0';  

    do{
        bandera_1 = true;   
        numero_jugador(numero_ingresado, &bandera_1, &valido);
        comparacion_numeros(numero_ingresado, numeros, &vaca, &toro);
        //salida
        if(vaca == 4){
            printf("Felicidades! El número secreto era: %c%c%c%c\n",numeros[0],numeros[1],numeros[2],numeros[3]);
            printf("Cantidad de vacas: %d\n", vaca);
            printf("Cantidad de toros: %d\n", toro);
            bandera = false;
        }else{
            printf("Tu puedes sigue intentando\n");
            printf("Cantidad de vacas: %d\n", vaca);
            printf("Cantidad de toros: %d\n", toro);
        }
    }while (bandera);
    
    return 0;
}

//creacion de funciones
void numero_jugador(char numero_ingresado[], bool *bandera_1, bool *valido){
    int i;

    while (*bandera_1) {
        *valido = true;

        printf("Ingrese un numero de 4 digitos:\n");
        fgets(numero_ingresado, 10, stdin);

        for (i = 0; numero_ingresado[i] != '\0'; i++) {
            if (numero_ingresado[i] == '\n') {
                numero_ingresado[i] = '\0';
                break;
            }
        }

        if (i != 4)
            *valido = false;

        for (i = 0; numero_ingresado[i] != '\0'; i++) {
            if (numero_ingresado[i] < '0' || numero_ingresado[i] > '9') {
                *valido = false;
                break;
            }
        }

        if (*valido)
            *bandera_1 = false;
        else
            printf("El numero ingresado es incorrecto, ingreselo nuevamente\n");
    }
}


void comparacion_numeros(char numero_ingresado[], char numeros[], int *vaca, int *toro){
    int i, j;
    bool usado_secreto[4] = {false};
    bool usado_jugador[4] = {false};

    *vaca = 0;
    *toro = 0;

    for (i = 0; i < 4; i++) {
        if (numero_ingresado[i] == numeros[i]) {
            (*vaca)++;
            usado_secreto[i] = true;
            usado_jugador[i] = true;
        }
    }

    for (i = 0; i < 4; i++) {
        if (usado_jugador[i]) continue;

        for (j = 0; j < 4; j++) {
            if (usado_secreto[j]) continue; 
            if (numero_ingresado[i] == numeros[j]) {
                (*toro)++;
                usado_secreto[j] = true; 
                break;
            }
        }
    }
}
