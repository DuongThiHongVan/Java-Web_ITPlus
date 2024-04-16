import java.util.Scanner;

public class Input {

	Scanner scanner = new Scanner(System.in);

	public int inputScannerInt() {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Nhập lại một số nguyên");
			}
		}
	}

	public String inputScannerString() {
		while (true) {
			String input = scanner.nextLine();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.out.println("Nhập lại một chuỗi.");
			}
		}
	}
}
