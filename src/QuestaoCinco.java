import java.util.Scanner;

public class QuestaoCinco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a string para inverter: ");
        String original = scanner.nextLine();

        String invertida = inverterString(original);

        System.out.println("String original: " + original);
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }

    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int length = caracteres.length;

        char[] invertida = new char[length];

        for (int i = 0; i < length; i++) {
            invertida[i] = caracteres[length - 1 - i];
        }

        return new String(invertida);
    }

}
