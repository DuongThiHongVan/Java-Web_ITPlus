package caulenhlap;
import java.util.*;
public class bai6 {
	public static void main(String[] args) {
        int firstNumber, secondNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ngẫu nhiên: ");
        firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số ngẫu nhiên: ");
        secondNumber = Integer.parseInt(scanner.nextLine());

        int secretNumber;
        if (secondNumber > firstNumber)
            secretNumber = (int) (Math.random() * (secondNumber - firstNumber + 1)) + firstNumber;
        else {
            secretNumber = (int) (Math.random() * (firstNumber - secondNumber + 1)) + secondNumber;

        }

        int countDown = 0;
        System.out.println("Số bí mật: " + secretNumber);
        boolean flag = true;


        while (countDown < 3) {
            System.out.println("Nhập số bạn đoán: ");
            int predictNumber = Integer.parseInt(scanner.nextLine());

            if (countDown == 2 && predictNumber != secretNumber) {
                System.out.println("Bạn đã thua");
                break;
            }

            if (predictNumber == secretNumber) {
                System.out.println("Bạn đã thắng");
                break;
            } else if (predictNumber > secretNumber) System.out.println("Giảm đi");
            else {
                System.out.println("Tăng lên");
            }

            countDown++;
        }
        scanner.close();
    }
}
