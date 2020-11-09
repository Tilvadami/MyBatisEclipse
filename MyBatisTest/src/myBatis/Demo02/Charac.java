package myBatis.Demo02;

public class Charac {
	private int id ;
	private String name ;
	private int age ;
	private boolean sex ;
	
	public Charac() {
		super();
	}

	public Charac(int id, String name, int age, boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return ("id:"+this.id+", 姓名："+this.name+", 年龄："+this.age+", 性别："+this.sex);
	}
	
	

}
