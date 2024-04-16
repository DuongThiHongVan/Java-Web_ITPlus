package duongthihongvan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * menu(): Hiển thị danh sách menu chức năng, khi nhập số từ bàn phím thì gọi ra
 * chức năng tương ứng: (5 điểm) ▪ 1: Hiển thị ▪ 2: Hiển thị theo loại ▪ 3: Thêm
 * ▪ 4: Sửa ▪ 5: Xoá ▪ 6: Tìm kiếm ▪ 0: Thoát o displayAll(): cho phép người
 * dùng hiển thị thông tin của danh sách học sinh, các thông tin mô tả dưới
 * bảng. (5 điểm) o displayByClassroom(): cho phép người dùng hiển thị thông tin
 * của danh sách học sinh theo lớp học. Lớp học được chọn từ dach sách có sẵn (5
 * điểm) o add(): Cho phép người dùng nhập thông tin của học sinh, các thông tin
 * được mô tả dưới bảng. Lưu ý: lớp học sẽ được lấy từ danh sách có sẵn. (5
 * điểm) o edit(): Cho phép người dụng nhập mã (ID) cần sửa, nếu mã trùng thì
 * cho phép nhập thông tin tên học sinh mới, tuổi mới, lớp học mới nếu không
 * trùng thì thông báo “Không trùng mã”. Lưu ý: lớp học sẽ được lấy từ danh sách
 * có sẵn. (5 điểm) o remove(): Cho phép nhập mã (ID) cần xoá, nếu mã trùng thì
 * xoá sách theo id, nếu không trùng thì thông báo “Không trùng mã”. (5 điểm)
 * searchByName (String name): Tìm kiếm thông tin học sinh theo tên gần đúng
 * không phân biệt hoa thường, không cần viết đủ tên học sinh. Nếu có hiện thị
 * thông tin tất cả các sách có tên gần đúng như từ khoá tìm kiếm. Nếu không có
 * hiển thị thông báo “Không tìm thấy”. (5 điểm)
 */

public class StudentController extends Input implements Activity, Search {
	private List<Student> listStudent;

	public StudentController() {
		this.listStudent = new ArrayList<>();
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	@Override
	public void searchByName(String name) {
		if (this.listStudent.isEmpty()) {
			System.out.println("Danh sách lớp học rỗng. Không có thông tin để tìm kiếm.");
			return;
		}
		List<Student> findList = new ArrayList<>();

		boolean found = false;
		String lowercaseName = name.toLowerCase();
		System.out.println("Kết quả tìm kiếm:");
		for (Student stu : this.listStudent) {
			if (stu.getName().toLowerCase().contains(lowercaseName)) {
				findList.add(stu);

			}
		}
		if (findList.isEmpty()) {
			System.out.println("Không tìm thấy thông tin học sinh.");
		}

	}

	public void displayAll() {
		if (this.listStudent.isEmpty()) {
			System.out.println("Danh sách học sinh rỗng.");
			
		} else {
			System.out.println("Danh sách học sinh:");

			for (Student student : this.listStudent) {
				System.out.println(student);

			}
		}
	}

	public void displayByClassroom() {
		if (this.listStudent.isEmpty()) {
            System.out.println("Danh sách học sinh rỗng.");
            return;
        }
		
		ArrayList<Classroom> availableClassrooms = new ArrayList<>();

        // Hiển thị danh sách các lớp học có sẵn để người dùng chọn
        System.out.println("Danh sách các lớp học có sẵn:");
        for (Student st: this.listStudent) {
        	availableClassrooms.add(st.getClassroom());
        }
        
        
        	
        Scanner scan = new Scanner(System.in);
        System.out.println("Chọn một lớp học từ danh sách: ");
        
        // Người dùng chọn một lớp học từ danh sách
        int choice = Integer.parseInt(scan.nextLine());
        if (choice < 1 || choice > availableClassrooms.size()) {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        Classroom selectedClassroom = availableClassrooms.get(choice - 1);

        // Hiển thị thông tin của các học sinh trong lớp học đã chọn
        System.out.println("Thông tin của các học sinh trong lớp " + selectedClassroom + ":");
        System.out.println("------------------------------------------");
        for (Student student : this.listStudent) {
            if (student.getClassroom().equals(selectedClassroom)) {
                System.out.println(student);
            }
        }
    }


	

	public void menu() {
		System.out.println("Menu:");
		System.out.println("1: Hiển thị");
		System.out.println("2: Hiện thị theo loại");
		System.out.println("3: Thêm");
		System.out.println("4: Sửa");
		System.out.println("5: Xóa");
		System.out.println("6: Tìm kiếm");
		System.out.println("0: Thoát");

		int choice = inputScannerInt();
		boolean flag = true;
		while(flag) {
			switch (choice) {
			case 1:
				if (this.listStudent.isEmpty()) {
					System.out.println("Danh sách rỗng");
					flag = false;
					break;
					
				}
				else {
					displayAll();
					break;
					
				}
				
				
			case 2:
				if (this.listStudent.isEmpty()) {
					System.out.println("Danh sách rỗng");
					break;
					
				}
				else {
					displayByClassroom();
					break;
					
				}
				
			
				
			case 3:
				add();
				break;

			case 4:
				edit();
				break;
			case 5:
				remove();
				break;
				
				
			case 6:
				Scanner scanner = new Scanner(System.in);
				String name = scanner.nextLine();
				searchByName(name);
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

	@Override
	public void add() {
		if (this.listStudent.isEmpty()) {
            System.out.println("Danh sách học sinh rỗng.");
            return;
        }
		
		ArrayList<Classroom> availableClassrooms = new ArrayList<>();

        // Hiển thị danh sách các lớp học có sẵn để người dùng chọn
        System.out.println("Danh sách các lớp học có sẵn:");
        for (Student st: this.listStudent) {
        	availableClassrooms.add(st.getClassroom());
        }
        
        
        	
        Scanner scan = new Scanner(System.in);
        System.out.println("Chọn một lớp học từ danh sách: ");
        // Người dùng chọn một lớp học từ danh sách
        int choice = inputScannerInt();
        if (choice < 1 || choice > availableClassrooms.size()) {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        
        System.out.println("Chọn một lớp học từ danh sách: ");
        choice = inputScannerInt();
        Classroom selectedClassroom = availableClassrooms.get(choice - 1);
        // Người dùng chọn một lớp học từ danh sách
        
        
       
        System.out.println("Nhập id: ");
        int id = inputScannerInt();
        
        System.out.println("Nhập tên: ");
        // Người dùng chọn một lớp học từ danh sách
        String name = scan.nextLine();
        
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scan.nextLine());
        
        Student st = new Student();
        st.setId(id);
        st.setAge(age);
        st.setName(name);
        st.setClassroom(selectedClassroom);
        
        this.listStudent.add(st);
        
      
        
       
        

	}

	@Override
	public void edit() {
		if (this.listStudent.isEmpty()) {
            System.out.println("Danh sách học sinh rỗng.");
            return;
        }
		
		ArrayList<Classroom> availableClassrooms = new ArrayList<>();

        // Hiển thị danh sách các lớp học có sẵn để người dùng chọn
        System.out.println("Danh sách các lớp học có sẵn:");
        for (Student st: this.listStudent) {
        	availableClassrooms.add(st.getClassroom());
        }
        
        
        	
        Scanner scan = new Scanner(System.in);
        System.out.println("Chọn một lớp học từ danh sách: ");
        // Người dùng chọn một lớp học từ danh sách
        int choice = Integer.parseInt(scan.nextLine());
        if (choice < 1 || choice > availableClassrooms.size()) {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        
        System.out.println("Chọn một lớp học từ danh sách: ");
        choice = Integer.parseInt(scan.nextLine());
        Classroom selectedClassroom = availableClassrooms.get(choice - 1);
        
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(scan.nextLine());
        
        boolean flag = false;
        for (Student st : this.listStudent) {
        	if (st.getId()==id) {
        		flag = true;
        		
                System.out.println("Nhập tên: ");
                // Người dùng chọn một lớp học từ danh sách
                String name = scan.nextLine();
                
                System.out.println("Nhập tuổi: ");
                int age = Integer.parseInt(scan.nextLine());
                
                st.setAge(age);
                st.setName(name);
                st.setClassroom(selectedClassroom);
        		
        	}
        }
        
        
        
        
        

	}



	@Override
	public void remove() {
		Scanner scanner = new Scanner(System.in);
		
	        if (this.listStudent.isEmpty()) {
	            System.out.println("Danh sách học sinh rỗng. Không có gì để xoá.");
	            return;
	        }
	        
	        System.out.println("Nhập mã (ID) cần xoá: ");
	        int idToRemove = Integer.parseInt(scanner.nextLine());
	        
	        boolean found = false;
	        for (int i = 0; i < this.listStudent.size(); i++) {
	            if (this.listStudent.get(i).getId() == idToRemove) {
	                this.listStudent.remove(i);
	                System.out.println("Học sinh đã được xoá khỏi danh sách.");
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("Không tìm thấy mã (ID) trong danh sách.");
	        }
	    }

	

}

