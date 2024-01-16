package caulenhdieukien;
import java.util.*;
//Viết chương trình nhập vào điểm của một học viên. Kết quả trả về là xếp loại của học viên đó. 
//Yêu cầu:
//	- Lớn hơn 8 điểm là giỏi 
//	- Lớn hơn 6,5 điểm là khá
//	- Lớn hơn 5 điểm là trung bình
//	- Còn lại là yếu
public class bai2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao diem cua hoc vien: ");
		float Diem = scanner.nextFloat();
		scanner.close();
		if(Diem > 8) {
			System.out.println("Hoc vien xep loại Gioi.");
		}else if( Diem > 6.5) {
			System.out.println("Hoc vien xep loai Kha.");
		}else if( Diem > 5) {
			System.out.println("Hoc vien xep loai Trung binh.");
		}else {
			System.out.println("Hoc vien xep loai Yeu.");
		}
	}
}
