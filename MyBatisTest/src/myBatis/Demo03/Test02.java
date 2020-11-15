package myBatis.Demo03;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

	public static void lazyLoading(int cid) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		Category category = null;
		List<Book> books = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			ICategoryMapper categoryMapper = session.getMapper(ICategoryMapper.class);
			category = categoryMapper.queryCategory(cid);

			System.out.println(category.getCid() + "," + category.getCname());
			books = category.getBooks();
			Iterator<Book> iterator = books.iterator();
			while (iterator.hasNext()) {
				Book book = iterator.next();
				System.out.println("id:" + book.getBid() + ", 书名：" + book.getBname() + ", 价格：" + book.getPrice()
						+ ", 属于:" + category.getCname());
			}
			// commit()清理一级缓存
			session.commit();
			categoryMapper.queryCategory(cid);
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

	public static void queryBooks() {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session01 = null;
		SqlSession session02 = null;
		List<Book> books = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session01 = sqlSessionFactory.openSession();
			session02 = sqlSessionFactory.openSession();
			IBookMapper bookMapper01 = (IBookMapper) session01.getMapper(IBookMapper.class);
			IBookMapper bookMapper02 = (IBookMapper) session02.getMapper(IBookMapper.class);
			books = bookMapper01.queryBooks();
			Iterator<Book> iterator = books.iterator();
			while (iterator.hasNext()) {
				Book book = iterator.next();
				System.out.println(book.toString());
			}
			if (session01 != null)
				session01.close();
			bookMapper02.queryBooks();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (session02 != null)
					session02.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void addBook(Book book) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			IBookMapper bookMapper = (IBookMapper) session.getMapper(IBookMapper.class);
			Boolean count = bookMapper.addBook(book);
			// 手动提交
			session.commit();
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

	// 重载
	public static void addBook(Integer bid, String bname, Integer price, Integer categoryid) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			IBookMapper bookMapper = session.getMapper(IBookMapper.class);
			bookMapper.addBook(bid, bname, price, categoryid);
			session.commit();

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

	public static void queryBook(int id) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		Book book = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			IBookMapper bookMapper = session.getMapper(IBookMapper.class);
			book = bookMapper.queryBook(id);
			System.out.println(book);

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

	public static void queryBookByMap(Integer bid) {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			IBookMapper bookMapper = session.getMapper(IBookMapper.class);
			Map<Integer, String> map = bookMapper.queryBookByMap(bid);
			System.out.println(map);
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

	public static void queryBooksByMap() {
		Reader reader = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession session = null;

		try {
			reader = Resources.getResourceAsReader("conf.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			IBookMapper bookMapper = session.getMapper(IBookMapper.class);
			Map<Integer, Book> map = bookMapper.queryBooksByMap();
			System.out.println(map);
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

	public static void main(String[] args) {
//		lazyLoading(1);
//		queryBooks();
//		Book book = new Book(null, "随便写点4", 54, 2);
//		addBook(book);
//		Integer bid = book.getBid();
//		System.out.println(bid);
		queryBook(3);

//		addBook(14, "DADWAD", 10, 2);

//		queryBookByMap(1);
		
//		queryBooksByMap();
	}

}
