import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TallerFunciones {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

 

    public static void edad() {
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();
        System.out.println("Tu edad es: " + edad + " años");
    }

    public static void suma() {
        System.out.print("Ingrese el primer número: ");
        double num1 = sc.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = sc.nextDouble();
        System.out.println("La suma es: " + (num1 + num2));
    }

    public static void numAleatorio() {
        int numero = rand.nextInt(100) + 1;
        int adivina = 0;
        System.out.println("Adivina el número entre 1 y 100");
        while (adivina != numero) {
            System.out.print("Tu intento: ");
            adivina = sc.nextInt();
            if (adivina < numero)
                System.out.println("El número es mayor.");
            else if (adivina > numero)
                System.out.println("El número es menor.");
            else
                System.out.println("¡Felicitaciones, adivinaste el número!");
        }
    }

    public static void contadorVocales() {
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese una cadena: ");
        String cadena = sc.nextLine().toLowerCase();
        int conteo = 0;
        for (char c : cadena.toCharArray()) {
            if ("aeiou".indexOf(c) != -1)
                conteo++;
        }
        System.out.println("La cadena tiene " + conteo + " vocales.");
    }

    // =========================================
    // 🔹 NIVEL 2 - Con parámetros, sin retorno
    // =========================================

    public static void palindromo(String palabra) {
        palabra = palabra.toLowerCase().replace(" ", "");
        String invertida = new StringBuilder(palabra).reverse().toString();
        System.out.println("¿Es palíndromo? " + palabra.equals(invertida));
    }

    public static void calcularPotencia(double base, double exponente) {
        double resultado = Math.pow(base, exponente);
        System.out.println(base + " elevado a " + exponente + " = " + resultado);
    }

    public static void calcularMedia(List<Double> lista) {
        double suma = 0;
        for (double n : lista)
            suma += n;
        System.out.println("La media es: " + (suma / lista.size()));
    }

    // =========================================
    // 🔹 NIVEL 3 - Con parámetros y retorno
    // =========================================

    public static String invertirCadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }

    public static double mayorDeTresNumeros(double n1, double n2, double n3) {
        return Math.max(n1, Math.max(n2, n3));
    }

    public static double calcularArea(double radio, double altura) {
        return 2 * Math.PI * radio * altura + 2 * Math.PI * Math.pow(radio, 2);
    }

    public static boolean buscarPalabra(String cadena, String palabra) {
        return cadena.toLowerCase().contains(palabra.toLowerCase());
    }

    // =========================================
    // 🔹 NIVEL 4 - Múltiples parámetros y retorno
    // =========================================

    public static double promedio(double... numeros) {
        double suma = 0;
        for (double n : numeros)
            suma += n;
        return suma / numeros.length;
    }

    public static double[] multiplicarLista(double[] lista, double numero) {
        double[] resultado = new double[lista.length];
        for (int i = 0; i < lista.length; i++) {
            resultado[i] = lista[i] * numero;
        }
        return resultado;
    }

    public static double mayorDeVariosNumeros(double... numeros) {
        double mayor = numeros[0];
        for (double n : numeros) {
            if (n > mayor)
                mayor = n;
        }
        return mayor;
    }

    public static double calcularMediana(double... numeros) {
        Arrays.sort(numeros);
        int n = numeros.length;
        if (n % 2 == 0) {
            return (numeros[n / 2 - 1] + numeros[n / 2]) / 2.0;
        } else {
            return numeros[n / 2];
        }
    }

    public static int contarOcurrencias(String cadena, String palabra) {
        String[] palabras = cadena.toLowerCase().split(" ");
        int conteo = 0;
        for (String p : palabras) {
            if (p.equals(palabra.toLowerCase()))
                conteo++;
        }
        return conteo;
    }

    // =========================================
    // 🔸 MENÚ PRINCIPAL
    // =========================================

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== TALLER DE FUNCIONES =====");
            System.out.println("1. Nivel 1 - Sin parámetros ni retorno");
            System.out.println("2. Nivel 2 - Con parámetros sin retorno");
            System.out.println("3. Nivel 3 - Con parámetros y retorno");
            System.out.println("4. Nivel 4 - Múltiples parámetros y retorno");
            System.out.println("0. Salir");
            System.out.print("Seleccione un nivel: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- NIVEL 1 ---");
                    edad();
                    suma();
                    contadorVocales();
                    // numAleatorio(); // opcional (pausa prolongada)
                }
                case 2 -> {
                    System.out.println("\n--- NIVEL 2 ---");
                    palindromo("Anilina");
                    calcularPotencia(2, 5);
                    calcularMedia(Arrays.asList(4.0, 8.0, 12.0));
                }
                case 3 -> {
                    System.out.println("\n--- NIVEL 3 ---");
                    System.out.println("Invertida: " + invertirCadena("Hola Mundo"));
                    System.out.println("Mayor: " + mayorDeTresNumeros(3, 9, 5));
                    System.out.println("Área cilindro: " + calcularArea(3, 5));
                    System.out.println("Buscar palabra: " + buscarPalabra("La casa azul", "casa"));
                }
                case 4 -> {
                    System.out.println("\n--- NIVEL 4 ---");
                    System.out.println("Promedio: " + promedio(4, 8, 10));
                    System.out.println("Mayor de varios: " + mayorDeVariosNumeros(5, 9, 12, 1));
                    System.out.println("Mediana: " + calcularMediana(2, 5, 8, 10));
                    double[] lista = { 1, 2, 3 };
                    System.out.println("Multiplicar lista: " + Arrays.toString(multiplicarLista(lista, 4)));
                    System.out.println("Ocurrencias: " + contarOcurrencias("hola hola mundo hola", "hola"));
                }
                case 0 -> System.out.println("👋 Saliendo del programa...");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }
