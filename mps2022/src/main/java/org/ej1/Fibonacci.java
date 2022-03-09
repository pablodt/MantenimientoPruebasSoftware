package org.ej1;

public class Fibonacci {

    public int compute(int n) {

        if (n > 1){
            return compute(n - 1) + compute(n - 2);
        }
        else if (n == 1) {
            return 1;
        }
        else if (n == 0){
            return 0;
        }
        else{
            throw new RuntimeException("El valor debe ser mayor o igual que 0");
        }
    }

}
