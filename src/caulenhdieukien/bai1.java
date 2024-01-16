package caulenhdieukien;
import java.util.*;
//Cho 3 số nguyên. Tìm số lớn nhất trong 3 số đó
public class bai1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao 3 so nguyen la: ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		scanner.close();
		//Gán SLN = a
		int SLN = a;
		// for( int i=1; i<=2; i++)  
		//Vòng lặp for này đảm bảo việc so sánh và tìm số lớn nhất được thực hiện đủ 2 lần để xác định chính xác số lớn nhất trong 3 số a, b, c.
			if(b > SLN){
				SLN = b;
			}
			if(c > SLN) {
				SLN = c;
			}
		System.out.println("So lon nhat trong 3 so da nhap la: " + SLN);
	}
}
