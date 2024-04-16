package duongthihongvan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassroomController extends Input implements Activity {

	private List<Classroom> listClassroom;

	/**
	 * o displayAll(): cho phép người dùng hiển thị thông tin của danh sách lớp học,
	 * các thông tin mô tả dưới bảng. (5 điểm) menu(): Hiển thị danh sách menu chức
	 * năng, khi nhập số từ bàn phím thì gọi ra chức năng tương ứng: (5 điểm) ▪ 1:
	 * Hiển thị ▪ 2: Thêm ▪ 3: Sửa ▪ 0: Thoát o add(): Cho phép người dùng nhập
	 * thông tin của lớp học, các thông tin được mô tả dưới bảng. (5 điểm) o edit():
	 * Cho phép người dụng nhập mã (ID) cần sửa, nếu mã trùng thì cho phép nhập
	 * thông tin tên lớp học mới, nếu không trùng thì thông báo “Không trùng mã”. (5
	 * điểm)
	 */

	
	public List<Classroom> getListClassroom() {
		return listClassroom;
	}

	public void setListClassroom(List<Classroom> listClassroom) {
		this.listClassroom = listClassroom;
	}

	public ClassroomController() {
		this.listClassroom = new ArrayList<>();
	}
	
	
	
	@Override
	public void add() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập thông tin của lớp học:");
		System.out.println("Nhập id lớp: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		for (Classroom cls: this.listClassroom) {
			if (cls.getId()== id) {
				System.out.println("Nhập lại id");
				id = Integer.parseInt(scanner.nextLine());
			}
		}
		
		System.out.println("Nhập tên lớp: ");
		String name = scanner.nextLine();
		
		Classroom classroom = new Classroom(id, name);
		this.listClassroom.add(classroom);
		

		System.out.println("Lớp học đã được thêm vào danh sách.");
	}


	@Override
	public void edit() {
        if (this.listClassroom.isEmpty()) {
            System.out.println("Danh sách lớp học rỗng. Không có gì để sửa.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập id lớp: ");
		int id = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (Classroom classroom : this.listClassroom) {
            if (classroom.getId() == id) {
            	System.out.println("Nhập tên lớp: ");
        		String name = scanner.nextLine();
                classroom.setName(name);
                System.out.println("Thông tin lớp học đã được sửa.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy mã (ID) trong danh sách.");
        }
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	public void displayAll() {
		if (this.listClassroom.isEmpty()) {
			System.out.println("Danh sách lớp học rỗng.");
		} else {
			
			for (Classroom classroom : this.listClassroom) {
				System.out.println(classroom);
			}
		}
	}

	public void menu() {
		System.out.println("Menu:");
		System.out.println("1: Hiển thị");
		System.out.println("2: Thêm");
		System.out.println("3: Sửa");
		System.out.println("0: Thoát");

		int choice = inputScannerInt();
		boolean flag = true;
		while(flag) {
			switch (choice) {
			case 1:
				if (this.listClassroom.isEmpty()) {
					System.out.println("Danh sách rỗng");
					flag = false;
					break;
					
				}
				else {
					displayAll();
					break;
					
				}
				
				
				
			case 2:
				add();
				break;
			case 3:
				edit();
				break;
			case 0:
				System.out.println("Thoát chương trình.");
				System.exit(0);
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ.");
				break;
			}
			
		}
	
	}

}
