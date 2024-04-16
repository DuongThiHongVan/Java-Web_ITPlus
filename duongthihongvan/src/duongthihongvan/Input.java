package duongthihongvan;

import java.util.Scanner;



public class Input {
	// hàm nhập từ bàn phím số nguyên *nếu không phải số nguyên thì nhập lại*
	public int inputScannerInt () {
		
		int input;
		Scanner scanner = new Scanner(System.in);
	
        while (true) {
            try {
                System.out.print("Nhập một số nguyên: ");
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai! Hãy nhập lại một số nguyên.");
            }
        }
        return input;
	}
	
	
	// hàm nhập từ bàn phím số nguyên *nếu không phải chuỗi thì nhập lại*
	
	  public static String inputScannerString() {
	        String input;
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            try {
	                System.out.print("Nhập một chuỗi: ");
	                input = scanner.nextLine();
	                break;
	            } catch (Exception e) {
	                System.out.println("Nhập sai! Hãy nhập lại một chuỗi.");
	            }
	        }
	        return input;
	    }

}
