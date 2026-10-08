import java.text.Normalizer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Verifica se um texto é palíndromo e se duas palavras são anagramas,
 * ignorando espaços, acentos, pontuação e maiúsculas.
 */
public class PalindromosAnagramas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Verificar palíndromo");
            System.out.println("2. Verificar anagrama");
            System.out.println("3. Sair");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine().trim();

            if (opcao.equals("1")) {
                System.out.print("Digite o texto: ");
                String texto = scanner.nextLine();
                System.out.println(isPalindromo(texto) ? "É palíndromo!" : "Não é palíndromo.");
            } else if (opcao.equals("2")) {
                System.out.print("Primeira palavra: ");
                String palavra1 = scanner.nextLine();
                System.out.print("Segunda palavra: ");
                String palavra2 = scanner.nextLine();
                System.out.println(isAnagrama(palavra1, palavra2) ? "São anagramas!" : "Não são anagramas.");
            } else if (opcao.equals("3")) {
                rodando = false;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    /**
     * Deixa o texto em minúsculas, sem acentos e só com letras e números.
     * Ex: "A sogra má e amargosa!" -> "asogramaeamargosa"
     */
    public static String normalizar(String texto) {
        // separa a letra do acento ("é" vira "e" + acento) e remove o acento
        String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        return semAcentos.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    public static boolean isPalindromo(String texto) {
        String limpo = normalizar(texto);

        if (limpo.isEmpty()) {
            return false;
        }

        String invertido = new StringBuilder(limpo).reverse().toString();
        return limpo.equals(invertido);
    }

    /**
     * Duas palavras são anagramas se têm as mesmas letras, na mesma
     * quantidade, em qualquer ordem. Aqui ordenamos os caracteres das duas
     * e comparamos.
     */
    public static boolean isAnagrama(String palavra1, String palavra2) {
        String a = normalizar(palavra1);
        String b = normalizar(palavra2);

        if (a.isEmpty() || a.length() != b.length()) {
            return false;
        }

        char[] letrasA = a.toCharArray();
        char[] letrasB = b.toCharArray();

        Arrays.sort(letrasA);
        Arrays.sort(letrasB);

        return Arrays.equals(letrasA, letrasB);
    }
}
