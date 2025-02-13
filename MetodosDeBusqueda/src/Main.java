import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        buscarProducto();
    }

    public static void buscarProducto() {
        int[] inventario = {101, 103, 105, 107, 109, 111, 113, 115, 117, 119};
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            int target;
            while (true) {
                try {
                    System.out.print("\nIngrese el ID del producto a buscar: ");
                    target = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Por favor ingrese un número entero válido.\n");
                    scanner.nextLine();
                }
            }

            boolean opcionValida = false;
            while (!opcionValida) {
                System.out.println("\nSeleccione el método de búsqueda:");
                System.out.println("1. Búsqueda Lineal");
                System.out.println("2. Búsqueda Binaria");
                System.out.println("3. Salir");

                try {
                    int opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            int indiceLineal = LinearSearch.search(inventario, target);
                            if (indiceLineal != -1) {
                                System.out.println("\nEl producto con ID " + target + " se encontró en la posición " + indiceLineal + " (búsqueda lineal).");
                            } else {
                                System.out.println("\nEl producto con ID " + target + " no se encontró (búsqueda lineal).");
                            }
                            opcionValida = true;
                            continuar = preguntarContinuar(scanner);
                            break;

                        case 2:
                            int indiceBinario = BinarySearch.search(inventario, target);
                            if (indiceBinario != -1) {
                                System.out.println("\nEl producto con ID " + target + " se encontró en la posición " + indiceBinario + " (búsqueda binaria).");
                            } else {
                                System.out.println("\nEl producto con ID " + target + " no se encontró (búsqueda binaria).");
                            }
                            opcionValida = true;
                            continuar = preguntarContinuar(scanner);
                            break;

                        case 3:
                            continuar = false;
                            opcionValida = true;
                            break;

                        default:
                            System.out.println("Opción no válida. Por favor, seleccione 1, 2 o 3.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Por favor ingrese una opción válida (1, 2 o 3).");
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
    }

    private static boolean preguntarContinuar(Scanner scanner) {
        while (true) {
            System.out.println("\n¿Desea continuar usando el programa?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            try {
                int respuesta = scanner.nextInt();
                if (respuesta == 1) {
                    return true;
                } else if (respuesta == 2) {
                    return false;
                } else {
                    System.out.println("Por favor, seleccione 1 (Sí) o 2 (No)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese una opción válida (1 o 2)");
                scanner.nextLine();
            }
        }
    }
}