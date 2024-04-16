import java.util.Scanner;

public class MainBook {

	// main task 1
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		BookBackend bookController = new BookBackend();

		bookController.menu();

		scanner.close();
	}
}