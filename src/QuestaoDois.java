import java.util.Scanner;

public class QuestaoDois {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int numero = scanner.nextInt();

        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }

    public static boolean isFibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return true;
        }

        int a = 0;
        int b = 1;
        int c = a + b;

        while (c <= numero) {
            if (c == numero) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }

        return false;
    }
}