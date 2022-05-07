package doitDataStructureAlgorithm.doit01;

import java.util.Scanner;

public class base04 {

    static boolean eqals ( int[] a, int[] b ) {
        if ( a.length != b.length ) {
            return false;
        }

        for ( int i = 0; i < a.length; i++ ) {
            if ( a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println( " array a Element : " );
        int na = sc.nextInt();
        int[] a = new int[na];
        for ( int i = 0; i < na; i++) {
            System.out.println("a[" + i + "] : ");
            a[i] = sc.nextInt();
        }

        System.out.println( " Array B Element : " );
        int nb = sc.nextInt();
        int[] b = new int[nb];

        for ( int i = 0; i < nb; i++ ) {
            System.out.println("b["+ i + "] : ");
            b[i] = sc.nextInt();
        }

        System.out.println(" Array A and B " + (eqals(a, b) ? "equals" : "!equals"));

    }
}
