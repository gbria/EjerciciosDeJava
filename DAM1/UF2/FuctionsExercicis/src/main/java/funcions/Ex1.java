package funcions;

import java.util.Scanner;
/**Creeu un programa que calculi la multiplicaci√≥ de dos nombres. Instruccions que cal seguir:*/
public class Ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueixi primer multiplicant: ");
        int num1 = sc.nextInt();
        System.out.print("Introdueixi segon multiplicant: ");
        int num2 = sc.nextInt();

        System.out.println("El resultat de la multiplicaci√≥: " + multiplicarNumero(num1, num2));
    }
    private static int multiplicarNumero(int num1, int num2) {
        return num1 * num2;
    }
}
