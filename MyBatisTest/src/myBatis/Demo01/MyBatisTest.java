package myBatis.Demo01;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;


public class MyBatisTest {
	public static void selectPerson() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = sqlSessionFactory.openSession();
		/*	
		  	String statement = "myBatis.Demo01.PersonDao."+"selectpersonbyid";
			Person person = session.selectOne(statement, 2);
			System.out.println(person);
		*/
		
		//接口 对象名 = session.getMapper(接口的放射入口);
		PersonDao person = session.getMapper(PersonDao.class);
		
		//对象名.方法 来调用Mapper.xml中对应id的SQL语句
		Person per = person.selectpersonbyid(1);
		System.out.println(per);
		
		
		
	}
	
	public static void addPerson() throws IOException {
			Reader reader = Resources.getResourceAsReader("conf.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			SqlSession session = sqlSessionFactory.openSession();
			/*String statement = "myBatis.Demo01.PersonMapper."+"addperson";
			Person person = new Person(3,"王五",17);
			int count = session.insert(statement, person);
			session.commit();
			System.out.println(count);*/
			
			//接口 對象名 = session.getMapper(接口的反射入口);
			PersonDao personDao = session.getMapper(PersonDao.class);
			Person person = new Person(4,"墨小菊",18);
			
			int count = personDao.addperson(person);
			session.commit();
			System.out.println(count);
			
	}
	
	public static void deletePerson() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = sqlSessionFactory.openSession();
		/*String statement = "myBatis.Demo01.PersonMapper."+"deleteperson";
		int count = session.delete(statement,3);
		session.commit();
		System.out.println(count);*/
		
		PersonDao personDao = session.getMapper(PersonDao.class);
		int count = personDao.deleteperson(4);
		session.commit();
		System.out.println(count);
		
		
	}
	
	public static void updatePerson() throws IOException {
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session = sqlSessionFactory.openSession();
		/*String statement = "myBatis.Demo01.PersonMapper."+"updateperson";
		Person person = new Person();
		person.setId(2);
		person.setName("李小四");
		person.setAge(20);
		int count = session.update(statement,person);*/
		PersonDao personDao = session.getMapper(PersonDao.class);
		Person person = new Person(1,"墨小菊",18);
		int count = personDao.updateperson(person);
		
		session.commit();
		System.out.println(count);
	}
	
	public static void main(String[] args) throws IOException {
		
		selectPerson();
//		addPerson();
//		deletePerson();
//		updatePerson();
		
	}

}
