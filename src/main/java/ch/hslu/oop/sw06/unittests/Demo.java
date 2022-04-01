package ch.hslu.oop.sw06.unittests;

public class Demo {
    public int quotient(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Y cannot be zero");
        }
        return x / y;
    }

    public static int maximum(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public int max1(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public int max2(int a, int b, int c) {
        int maxAB = maximum(a, b);
        int maxABC = maximum(maxAB, c);
        return maxABC;
    }

    public int max5(int a, int b, int c, int d, int e) {
        int maxPosition = 0;
        int[] values = new int[]{a, b, c, d, e};

        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[maxPosition]) {
                maxPosition = i;
            }
        }

        return values[maxPosition];
    }

    public void printNumbersWithFor() {
        System.out.println("Ausgabe 1 - 10 mit for-Schleife");
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }

    public void printNumbersWithWhile() {
        System.out.println("Ausgabe 1 - 10 mit while-Schleife");
        int i = 1;

        while (i < 11) {
            System.out.println(i);
            i++;
        }
    }

    public void printNumbersWithDoWhile() {
        System.out.println("Ausgabe 1 - 10 mit do-while-Schleife");
        int i = 1;

        do {
            System.out.println(i);
            i++;
        } while (i < 11);

    }

    public void floatAdditionTest() {
        float num = 0.9f;
        int counter = 0;
        while (!(num >= 1.0f)) {
            num += 0.000025f;
            counter++;
        }
        System.out.println("Ergebnis:\t" + num);
        System.out.println("Anzahl Additionen:\t" + counter);
        System.out.println("Ich bin fertig");
    }

    /*
        Wenn genaueres Resultat erwünscht:

        -Multiplikation rechnet genauer als Addition

        -Wertebereich in int-Bereich verschieben (* am Anfang, : am Schluss)
    */
    public void floatAdditionWithFor() {
        float num = 0.9f;
        int counter = 0;
        for (int i = 0; i <= 4000; i++) {
            num += 0.000025f;
            counter = i;
        }
        System.out.println("Ergebnis:\t" + num);
        System.out.println("Anzahl Additionen:\t" + counter);
        System.out.println("Ich bin fertig");
    }

    public void printBox(int height, int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("#");
        }
        System.out.println();
        for (int y = 0; y < (height - 2); y++) {
            for (int k = 0; k < width; k++) {
                if (k == 0 || k == (width - 1)) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < width; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    public void printBox2(int height, int width) {
        for (int y = 0; y < height; y++) {
            if (y == 0 || y == (height - 1)) {
                for (int i = 0; i < width; i++) {
                    System.out.print("#");
                }
            } else {
                for (int k = 0; k < width; k++) {
                    if (k == 0 || k == (width - 1)) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void printCross(int height, int width) {
        for (int i = 1; i < height + 1; i++) {
            if (i != (height / 2 + 1)) {
                for (int k = 1; k < width + 1; k++) {
                    if (k != (width / 2 + 1)) {
                        System.out.print("0");
                    } else {
                        System.out.print("+");
                    }
                }
            } else {
                for (int y = 1; y < width + 1; y++) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }
}
