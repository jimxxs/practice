package recursion;

public class Recursion {
    int v ;
    public int fibonacci(int n) {
        if (n <= 1) {  // Base case
            return n;
        } else {  // Recursive case
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
       Recursion r = new Recursion();
       r.v =23;
       System.out.println(r.fibonacci(23));
        
    }
}
