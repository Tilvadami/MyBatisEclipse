package myBatis.Demo02;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01 {

	public static void addCharater(Charac ch) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "test");
			session = sqlSessionFactory.openSession();
			CharacDao characDao = session.getMapper(CharacDao.class);

			int count = characDao.addCharacter(ch);
			if (count > 0) {
				session.commit();
				System.out.println("添加成功！");
			} else {
				session.rollback();
				System.out.println("添加失败！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void queryCharacterByHashMap(Map<String, Object> map) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			CharacDao characDao = session.getMapper(CharacDao.class);
			List<Charac> list = characDao.queryCharactersByHashMap(map);
			Iterator<Charac> iterator = list.iterator();
			while (iterator.hasNext()) {
				Charac charac = iterator.next();
				System.out.println(charac);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void queryCountByProcedure(Map<String, Object> map) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			CharacDao charcDao = session.getMapper(CharacDao.class);
			charcDao.queryCountByProcedure(map);
			Object count = map.get("p_out");
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void queryCharactersByNotAll() {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		List<Map<String, Object>> list = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			CharacDao characDao = session.getMapper(CharacDao.class);
			// 这一步将list指向了Arraylist对象
			list = characDao.queryCharactersByNotAll();

			Iterator<Map<String, Object>> iterator = list.iterator();
			while (iterator.hasNext()) {
				Map<String, Object> map = iterator.next();
				System.out.println("id:" + map.get("cid") + ", 姓名：" + map.get("cname"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void queryCharac() {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			CharacDao characDao = session.getMapper(CharacDao.class);
			Charac ch = characDao.queryCharac(1);
			System.out.println(ch);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void queryCharactersByDynamic() {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			CharacDao characDao = session.getMapper(CharacDao.class);

			Charac ch = new Charac();
			ch = characDao.queryCharactersByDynamic(6);
			System.out.println(ch);

		} catch (Exception e) {

		}
	}

	public static void queryWorkerInfo(int id) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		Worker worker = null ;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			CharacDao characDao = session.getMapper(CharacDao.class);
			worker = characDao.queryWorkerAndCardById(id);
			System.out.println(worker);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null)
					session.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void queryDepartment(int id) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		List<Worker> workers = null;
		Depart depart = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			CharacDao characDao = session.getMapper(CharacDao.class);
			depart = characDao.queryDepartment(id);
			System.out.println(depart);
			workers = depart.getWorkers();
			Iterator<Worker> iterator = workers.iterator();
			while(iterator.hasNext()) {
				Worker worker = iterator.next();
				System.out.println(worker);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		Charac ch = new Charac(8, "熊雯雯", 16, false);
//		addCharater(ch);

//		Map<String, Object> map = new HashMap<>();
//		map.put("id", 1);
//		map.put("name", "菓");
//		queryCharacterByHashMap(map);

//		Map<String, Object> map = new HashMap<>();
//		map.put("p_in", 14);
//		queryCountByProcedure(map);

//		queryCharactersByNotAll();

//		queryCharac();

//		queryCharactersByDynamic();
		
		queryWorkerInfo(1);
		
//		queryDepartment(2);

	}

}
