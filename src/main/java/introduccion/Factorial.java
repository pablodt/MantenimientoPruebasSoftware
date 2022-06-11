package introduccion;

public class Factorial {
    public int compute(int n) {
        return n == 0 ? 1 : compute(n-1) * n;
    }
}
