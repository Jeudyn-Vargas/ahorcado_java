import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) throws Exception {

        //  Array de palabras posibles aleatorias
        String[] palabras = {
                "java", "programacion", "computadora", "teclado", "mouse",
                "algoritmo", "variable", "objeto", "clase", "metodo"
        };

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = palabras[random.nextInt(palabras.length)].toLowerCase();

        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        boolean palabraAdivinada = false;

        int intentos = 0;
        int intestosMaximos = 6; 

        //  Bucle principal 
        while (!palabraAdivinada && intentos < intestosMaximos) {

            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));
            System.out.println("Introduce una letra, por favor");

            // Usamos la clase scanner para pedir una letra
            char letra = scanner.next().charAt(0);
            letra = Character.toLowerCase(letra);

            boolean letraCorrecta = false;

            // Estructura de control : Iterativa(Bucle)
            for (int i = 0; i < palabraSecreta.length(); i++) {
                // Estructura de control condicional
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Letra incorrecta!, te quedan " + (intestosMaximos - intentos) + " intentos");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades crack, has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        //  Resultado final 
        if (!palabraAdivinada) {
            System.out.println("Perdiste, la palabra secreta era: " + palabraSecreta);
        }

        scanner.close();
    }
}