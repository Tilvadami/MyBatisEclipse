package myBatis.Demo01;

public interface PersonDao {
	public abstract Person selectpersonbyid(int id);
	
	public abstract int addperson(Person person);
	
	public abstract int deleteperson(int id);
	
	public abstract int updateperson(Person person);
	
}
