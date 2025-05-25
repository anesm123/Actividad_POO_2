import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Persona> personas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        capturarDatos();
        mostrarNombreYGenero();
        System.out.println("Promedio de edades: " + calcularPromedioEdad());
        System.out.println("Cantidad de personas género Masculino: " + contarGenero("Masculino"));
        System.out.println("Cantidad de personas género Femenino: " + contarGenero("Femenino"));
    }

    // Método para capturar datos
    public static void capturarDatos() {
        String continuar;
        do {
            System.out.println("Ingrese los datos de la persona " + (personas.size() + 1));

            String nombre;
            do {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                if (nombre.trim().isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            } while (nombre.trim().isEmpty());

            String apellido;
            do {
                System.out.print("Apellido: ");
                apellido = scanner.nextLine();
                if (apellido.trim().isEmpty()) {
                    System.out.println("El apellido no puede estar vacío.");
                }
            } while (apellido.trim().isEmpty());

            String genero;
            while (true) {
                System.out.print("Género (Masculino/Femenino): ");
                genero = scanner.nextLine();
                if (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino")) break;
                System.out.println("Ingrese 'Masculino' o 'Femenino'.");
            }

            int edad;
            while (true) {
                System.out.print("Edad: ");
                try {
                    edad = Integer.parseInt(scanner.nextLine());
                    if (edad > 0) break;
                    System.out.println("La edad debe ser un número positivo.");
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido para la edad.");
                }
            }

            personas.add(new Persona(nombre, apellido, genero, edad));

            System.out.print("¿Agregar otra persona? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
    }

    // Mostrar nombre y género de las personas
    public static void mostrarNombreYGenero() {
        System.out.println("\nNombres y géneros de las personas:");
        for (Persona persona : personas) {
            System.out.println("Nombre completo: " + persona.getNombre() + " " + persona.getApellido() + " - Género: " + persona.getGenero());
        }
    }

    // Calcular promedio de edades
    public static double calcularPromedioEdad() {
        if (personas.isEmpty()) return 0;
        int suma = 0;
        for (Persona persona : personas) {
            suma += persona.getEdad();
        }
        return (double) suma / personas.size();
    }

    // Contar personas por género
    public static int contarGenero(String generoBuscado) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona.getGenero().equalsIgnoreCase(generoBuscado)) {
                contador++;
            }
        }
        return contador;
    }
}