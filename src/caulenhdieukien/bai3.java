package caulenhdieukien;
import java.util.*;
//Viết chương trình nhập vào 1 số. Nếu số đó lớn hơn 0 thì in ra chuỗi "Positive", nhỏ hơn 0 thì in chuỗi "Negative", bằng 0 thì in ra chính số 0
public class bai3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao 1 so bat ky: ");
		int number = scanner.nextInt();
		scanner.close();
		if(number > 0) {
			System.out.println("Positive");
		}else if(number < 0){
			System.out.println("Negative");
		}else {
			System.out.println("0");
		}
	}
}
