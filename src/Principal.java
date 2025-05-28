import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int primeiro = 0, segundo = 0;
        boolean continuar = true;

        while (continuar) {

            try {
                System.out.print("Digite o valor do primeiro numero: ");
                primeiro = sc.nextInt();

                if (primeiro < 0) {
                    throw new NumeroNegativo("Erro: o primeiro número não pode ser negativo.");
                }

                System.out.print("Digite o valor do segundo numero: ");
                segundo = sc.nextInt();

                if (segundo < 0) {
                    throw new NumeroNegativo("Erro: o segundo número não pode ser negativo.");
                }

                continuar = false;

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                sc.nextLine();

            } catch (NumeroNegativo e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }


        }

        Calculadora calculadora = new Calculadora(primeiro, segundo);

        System.out.println(primeiro + " + " + segundo + " = " + calculadora.soma());
        System.out.println(primeiro + " - " + segundo + " = " + calculadora.subtracao());
        System.out.println(primeiro + " * " + segundo + " = " + calculadora.multiplicacao());
        System.out.println(primeiro + " / " + segundo + " = " + calculadora.divisao());
    }
}
