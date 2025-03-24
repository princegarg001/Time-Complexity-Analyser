package adaa;
public class analysing {
	    public static void main(String[] args) {
	        int n = 10;
	        for (int i = 0; i < n; i++) {
	            System.out.println(i);
	        }
	        for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	                System.out.println(i + ", " + j);
	            }
	        }
	            for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	            for (int k = 0; k < n; k++) {
	                    System.out.println(i + ", " + j + ", " + k);
	                }
	            }
	        }
	        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
	    }
	    public static int fibonacci(int n) {
	        if (n <= 1) return n;
	        return fibonacci(n - 1) + fibonacci(n - 2);
	    }
	}
