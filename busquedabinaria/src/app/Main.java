package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author ant & móncia
 * @param <T> 
 */

public class Main<T extends Comparable<T>> {

    private static Scanner in = new Scanner(System.in);

    public static List<Sales> ventas = new ArrayList<>();

    private static Sales venta;

    public static void main(String[] args) {
        System.out.println("Ingrese el numero de ventas: ");
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            int mes = getNum(0, 13);
            int dia = getDia(mes);
            venta = new Sales(mes, dia, DgetNum(0, 10001));
            ventas.add(venta);
            System.out.println(ventas.get(i).toString());
        }
        CocktailSort();
        System.out.println();
        for (Sales s : ventas) {
            System.out.println(s.toString());
        }

        System.out.println("Ingrese el valor a buscar en el ArrayList: ");
        Double bu = in.nextDouble();
        int index = Search(bu);
        if (index != -1) {
            System.out.println("El índice del valor es: " + index);
            System.out.println(ventas.get(index).toString());
        } else {
            System.out.println("El valor no se encuentra en el arreglo.");
        }
    }

    public static int Search(Double value) {
        return binarySearch(value,0, ventas.size());
    }

    public static int binarySearch(Double value, int L, int R) {
        if (R >= L) {
            int M = L + (R - L) / 2;
            if (ventas.get(M).getValor().equals(value)) {
                return M;
            }
            if (ventas.get(M).getValor().compareTo(value) > 0) {
                return binarySearch(value,L, --M);
            }
            return binarySearch(value, ++M, R);
        }
        return -1;
    }

    public static void CocktailSort() {

        boolean swapped = true;
        int start = 0;
        int end = ventas.size();

        while (swapped) {

            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (ventas.get(i).getValor().compareTo(ventas.get(i + 1).getValor()) > 0) {
                    Sales temp = ventas.get(i);
                    ventas.set(i, ventas.get(i + 1));
                    ventas.set(i + 1, temp);
                    swapped = true;
                }
            }

            if (swapped == false)
                break;

            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (ventas.get(i).getValor().compareTo(ventas.get(i + 1).getValor()) > 0) {
                    Sales temp = ventas.get(i);
                    ventas.set(i, ventas.get(i + 1));
                    ventas.set(i + 1, temp);
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    public static int getNum(int x, int y) {
        return (int) (Math.abs(Math.floor(Math.random() * (x - y + 1) + y)));
    }

    public static double DgetNum(int x, int y){
        return Math.round(ThreadLocalRandom.current().nextDouble(x, y) * 100.0) / 100.0;
    }

    public static int getDia(int mes) {
        switch (mes) {
            case 1:
                return getNum(0, 32);
            case 2:
                return getNum(0, 29);
            case 3:
                return getNum(0, 32);
            case 4:
                return getNum(0, 31);
            case 5:
                return getNum(0, 32);
            case 6:
                return getNum(0, 31);
            case 7:
                return getNum(0, 32);
            case 8:
                return getNum(0, 32);
            case 9:
                return getNum(0, 31);
            case 10:
                return getNum(0, 32);
            case 11:
                return getNum(0, 31);
            case 12:
                return getNum(0, 32);
            default:
                return getDia(mes);
        }
    }
}
