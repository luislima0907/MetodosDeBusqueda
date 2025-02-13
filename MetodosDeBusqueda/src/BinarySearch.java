public class BinarySearch {
    public static int search(int[] arr, int target) {
        System.out.println("\nMétodo de Búsqueda Binaria");
        int low = 0;
        int high = arr.length - 1;
        int step = 1;

        System.out.println("\nBuscando el valor: " + target);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("\nPaso " + step + ":");
            System.out.println("Rango de búsqueda: [" + low + " - " + high + "]");
            System.out.println("Valor medio en posición " + mid + ": " + arr[mid]);

            if (arr[mid] == target) {
                System.out.println("¡Valor encontrado!");
                return mid;
            } else if (arr[mid] < target) {
                System.out.println("El valor buscado es mayor, moviendo a la derecha");
                low = mid + 1;
            } else {
                System.out.println("El valor buscado es menor, moviendo a la izquierda");
                high = mid - 1;
            }
            step++;
        }

        System.out.println("\nValor no encontrado");
        return -1;
    }
}
