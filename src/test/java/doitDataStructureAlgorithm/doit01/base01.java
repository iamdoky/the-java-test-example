package doitDataStructureAlgorithm.doit01;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class base01 {
    @Test
    static int maxTest ( int a, int b, int c ) {
        int max = a;
        if ( b > max ) { max = b; }
        if ( c > max  ) { max = c;}

        return max;
    }
    @Test
    static int minTest ( int a, int b, int c ) {
        int min = a;
        if ( b < min ) min = b;
        if ( c < min ) min = c;

        return min;
    }

    @Test
    static int middleTest ( int a, int b, int c ) {
        if ( a >= b ) {
            if ( b >= c ) {
                return b;
            } else if ( a <= c ) {
                return a;
            } else {
                return c;
            }
        } else if ( a > c ) {
            return a;
        } else if ( b > c ) {
            return c;
        } else {
            return b;
        }
    }


    public static void main(String[] args) {
        System.out.println( maxTest( 3, 5, 3 ));
        System.out.println( minTest( 3, 5, 2 ));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println( middleTest( a,b,c));
    }
}
