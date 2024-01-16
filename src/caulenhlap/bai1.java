package caulenhlap;
import java.util.*;
//Viết chương trình tính giai thừa của 1 số
//Giai thừa của 0 và 1 = 1
public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao mot so bat ky: ");
		int n = sc.nextInt();
		int gt = 1; // khai báo để lưu trữ giá trị giai thừa
		sc.close();
		for(int i=1; i<=n; i++) {
			gt *= i;
		}
		System.out.println("Giai thua cua so " + n + " la: " + gt);
	}
}
