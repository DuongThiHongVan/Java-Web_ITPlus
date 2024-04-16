import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MainTask2 {
	
	public static ArrayList<Book> bookFromFile =new ArrayList<Book>();
	public static final String ABSOLUTED_PATH_FILE = "D:\\@duong\\D1303\\DuongThiHongVan\\src\\book.txt";
	public static ArrayList<Book> readBooksFromFile(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			ArrayList<Book> bookList =new ArrayList<Book>();
			while ((line = reader.readLine()) != null) {
				String[] bookInfo = line.split(";");
				if (bookInfo.length == 3) {
					int id = Integer.parseInt(bookInfo[0].trim());
					String name = bookInfo[1].trim();
					String publishing = bookInfo[2].trim();
					Book book = new Book(id, name, publishing);
					bookList.add(book);
					

				}
			}
			return bookList;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	
		

	}
	
	public static void displayAllBook(List<Book> list) {
		if (list.size() == 0) {
			System.out.println("Danh sách trống");
			return;
		}
		System.out.println("DANH SÁCH");
		System.out.printf("%-5s%-30s%-20s\n", "ID", "Tên sách", "Nhà xuất bản");

		for (Book book : list) {
			System.out.printf("%-5s%-30s%-20s\n", book.getId(), book.getName(), book.getPublishing());
		}
	}
	
	  public static void sortBooksByName(List<Book> list) {
	        Collections.sort(list, new Comparator<Book>() {
	            @Override
	            public int compare(Book book1, Book book2) {
	                return book1.getName().compareTo(book2.getName());
	            }
	        });
	    }
	
	public static void main(String[] args) {
		String path = ABSOLUTED_PATH_FILE;
		File file1 = new File(path);
		
		// thực hiện đọc sách ở file và hiện thị
		bookFromFile = readBooksFromFile(file1);
		displayAllBook(bookFromFile);
		
		System.out.println("DANH SÁCH SÁCH SAU KHI THỰC HIỆN SẮP XẾP THEO TÊN");
		
		sortBooksByName(bookFromFile);
        // Hiển thị danh sách sau khi sắp xếp
        displayAllBook(bookFromFile);
		
		
		
		
		
	}
	

}
