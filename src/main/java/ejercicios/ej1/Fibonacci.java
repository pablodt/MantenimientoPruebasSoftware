package ejercicios.ej1;

public class Fibonacci {
    public int compute(int n) {
        return n < 0 ? -1 : (n == 0 ? 0 : (n == 1 ? 1 : compute(n-1) + compute(n-2)));
    }
}
