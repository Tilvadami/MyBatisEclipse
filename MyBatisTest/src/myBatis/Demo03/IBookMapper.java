package myBatis.Demo03;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.Collection;

public interface IBookMapper {
	//增
	//@Insert("insert into books(bid,bname,price,categoryid) value(#{bid},#{bname},#{price},#{categoryid})")
	public abstract Boolean addBook(Book book);
	//重载一个方法
	public abstract Boolean addBook(@Param("bid")Integer bid, @Param("bname")String bname, @Param("price")Integer price, @Param("categoryid")Integer categoryid);
//	删
	public abstract int deleteBook(int bid);
	//改
	public abstract int updateBook(Book book);
	//查
//	@Select("select * from books where bid = #{bid}") 
	public abstract Book queryBook(int bid);
	public abstract List<Book> queryBooks();
	
	public abstract Map<Integer, String> queryBookByMap(Integer bid);
	
	@MapKey("bid")	//这个注解是告诉Mybatis map的key值为数据库当中“bid”的值
	public abstract Map<Integer, Book> queryBooksByMap();
}
