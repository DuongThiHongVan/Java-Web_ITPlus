package duongthihongvan;

public class Classroom {
	
	private int id;
	private String name;
	
	
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
	
	
	public Classroom(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	
	public Classroom(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Classroom [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
