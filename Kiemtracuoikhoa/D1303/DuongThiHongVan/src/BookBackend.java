import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookBackend extends Input implements Activity, Search {

	private List<Book> books = new ArrayList<>();

	public static final String ABSOLUTED_PATH_FILE = "D:\\@duong\\D1303\\DuongThiHongVan\\src\\book.txt";

	public void menu() {
		int choice;
		do {
			System.out.println("==========================MENU===========================");
			System.out.println("1: Thêm");
			System.out.println("2: Sửa");
			System.out.println("3: Xoá");
			System.out.println("4: Tìm kiếm");
			System.out.println("5: Thoát");
			System.out.println("==========================================================");
			System.out.print("*Nhập lựa chọn của bạn*: ");
			choice = inputScannerInt();

			switch (choice) {

			case 1:
				displayAllBook();
				add();
				break;
			case 2:
				displayAllBook();
				edit();
				break;
			case 3:
				displayAllBook();
				remove();
				break;
			case 4:
				System.out.println("Nhập tên sách cần tìm:");
				String name = scanner.nextLine();
				searchByName(name);
				break;
			case 5:

				System.out.println("Thoát chương trình.");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
			}
		} while (choice != 0);

	}

	public void displayAllBook() {
		if (books.size() == 0) {
			System.out.println("Danh sách trống");
			return;
		}
		System.out.println("DANH SÁCH");
		System.out.printf("%-5s%-30s%-20s\n", "ID", "Tên sách", "Nhà xuất bản");

		for (Book book : books) {
			System.out.printf("%-5s%-30s%-20s\n", book.getId(), book.getName(), book.getPublishing());
		}
	}

	@Override
	public void add() {
		System.out.println("\nBẠN ĐANG THỰC HIỆN NHẬP THÊM THÔNG TIN MỘT SÁCH MỚI\n");
		int id;
		boolean idExists;
		do {
			System.out.print("Nhập ID: ");
			id = inputScannerInt();

			idExists = false;
			for (Book book : books) {
				if (book.getId() == id) {
					idExists = true;
					break;
				}
			}
			if (idExists) {
				System.out.println("ID đã tồn tại. Vui lòng nhập lại.");
			}
		} while (idExists);

		System.out.print("Nhập tên sách: ");
		String name = scanner.nextLine();

		System.out.print("Nhập nhà xuất bản: ");
		String publishing = scanner.nextLine();

		Book newBook = new Book(id, name, publishing);
		books.add(newBook);
		String path = ABSOLUTED_PATH_FILE;
		File file1 = new File(path);
		appendToFile(file1, newBook);
		System.out.println("Sách mới đã được thêm vào danh sách và ghi vào tệp.");
	}

	private void appendToFile(File file1, Book book) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1, true))) {
			writer.write(book.getId() + ";" + book.getName() + ";" + book.getPublishing());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit() {
		System.out.println("\nBẠN ĐANG THỰC HIỆN CHỈNH SỬA THÔNG TIN SÁCH THEO ID\n");
		System.out.print("Nhập mã sách cần sửa: ");
		int idToEdit = inputScannerInt();

		boolean found = false;
		for (Book book : books) {
			if (book.getId() == idToEdit) {
				Book foundBook = new Book(book.getId(), book.getName(), book.getPublishing());

				System.out.print("Nhập tên sách mới: ");
				String newName = scanner.nextLine();
				System.out.print("Nhập nhà xuất bản mới: ");
				String newPublishing = scanner.nextLine();
				if (newName.equalsIgnoreCase("") || newPublishing.equalsIgnoreCase("")) {
					book.setName(foundBook.getName());
					book.setPublishing(foundBook.getPublishing());
				} else {
					book.setName(newName);
					book.setPublishing(newPublishing);

				}

				found = true;
				String path = ABSOLUTED_PATH_FILE;
				File file1 = new File(path);
				updateFile(file1);
				System.out.println("Sách với mã " + idToEdit + " đã được sửa thành công.");
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sách với mã " + idToEdit);
		}
	}

	private void updateFile(File file1) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
			for (Book book : books) {
				writer.write(book.getId() + ";" + book.getName() + ";" + book.getPublishing());
				writer.newLine();
			}
			System.out.println("Danh sách sách đã được cập nhật và ghi vào tệp.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove() {
		System.out.println("\nBẠN ĐANG THỰC HIỆN XÓA SÁCH THEO ID\n");
		System.out.print("Nhập mã sách cần xoá: ");
		int idToDelete = inputScannerInt();

		boolean found = false;
		for (Book book : books) {
			if (book.getId() == idToDelete) {
				books.remove(book);
				found = true;
				String path = ABSOLUTED_PATH_FILE;
				File file1 = new File(path);
				updateFile(file1);
				System.out.println("Sách với mã " + idToDelete + " đã được xoá.");
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy sách với mã " + idToDelete);
		}
	}

	@Override
	public void searchByName(String name) {
		System.out.println("Kết quả tìm kiếm cho: " + name);
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(book);
			}
		}
		if (result.size() == 0) {
			System.out.println("Danh sách trống");
			return;
		} else {

			System.out.printf("%-5s%-30s%-20s\n", "ID", "Tên sách", "Nhà xuất bản");
			for (Book book : result) {
				System.out.printf("%-5s%-30s%-20s\n", book.getId(), book.getName(), book.getPublishing());
			}

		}

	}

	public List<Book> readBooksFromFile(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] bookInfo = line.split(";");
				if (bookInfo.length == 3) {
					int id = Integer.parseInt(bookInfo[0].trim());
					String name = bookInfo[1].trim();
					String publishing = bookInfo[2].trim();
					Book book = new Book(id, name, publishing);
					books.add(book);

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;

	}

}
