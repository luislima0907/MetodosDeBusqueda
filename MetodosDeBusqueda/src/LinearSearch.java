public class LinearSearch {
    public static int search(int[] arr, int target) {
        System.out.println("\nMétodo de Búsqueda Lineal");
        System.out.println("\nBuscando el número: " + target);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Paso " + (i+1) + ": Comparando con posición " + i + " -> " + arr[i]);
            if (arr[i] == target) {
                System.out.println("\n¡Número encontrado en la posición " + i + "!");
                return i;
            }
        }
        System.out.println("\nEl número no fue encontrado en el arreglo.");
        return -1;
    }
}
