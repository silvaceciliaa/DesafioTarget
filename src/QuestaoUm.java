public class QuestaoUm {

    public static void main(String[] args) {

        int indice = 13, soma = 0, k = 0;

        while( k < indice){
            k = k + 1; soma = soma + k;

            System.out.println(soma);
        }
        System.out.print("Ao final do processamento, o valor da variável SOMA é igual a: " + soma);
    }
}