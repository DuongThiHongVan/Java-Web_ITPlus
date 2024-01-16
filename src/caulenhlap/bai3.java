package caulenhlap;

public class bai3 {
	public static void main(String[] args) {
		int n = 20; // Số lượng số Fibonacci cần in ra

	        // Gọi hàm in ra n số Fibonacci đầu tiên
	        printFibonacci(n);
	    }

	public static void printFibonacci(int n) {
	    int first = 1, second = 1, next;
	    System.out.println("20 số Fibonacci đầu tiên là:");
	        for (int i = 0; i < n; i++) {
	            System.out.print(first + " ");

	            next = first + second;
	            first = second;
	            second = next;
	        }
	    }
}
