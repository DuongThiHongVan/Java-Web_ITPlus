
public class Book {
	
	private int id;
	private String name;
	private String publishing;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	
	public Book() {
		
	}
	public Book(int id, String name, String publishing) {
		super();
		this.id = id;
		this.name = name;
		this.publishing = publishing;
	}
	
	
	
	

}
