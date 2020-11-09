package myBatis.Demo03;

import java.util.List;

public interface ICategoryMapper {
	//增
	public abstract int addCategory(Category category);
	//删
	public abstract int deleteCategory(int cid);
	//改
	public abstract int updateCategory(Category category);
	//查
	public abstract Category queryCategory(int cid);
	public abstract List<Category> queryCategories();
}
