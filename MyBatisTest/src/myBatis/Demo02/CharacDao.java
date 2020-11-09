package myBatis.Demo02;

import java.util.Map;
import java.util.List;

public interface CharacDao {
	//增
	public abstract int addCharacter(Charac ch) ; 
	
	//删
	public abstract int deleteCharacter(Charac ch) ;
	
	//改
	public abstract int updateCharacter(Charac ch) ;
	
	//查
	public abstract Charac queryCharacter(int id) ;
	public abstract Charac queryCharac(int id) ;
	
	//查所有
	public abstract List<Charac> queryAllCharacters();
	
	//HashMap查
	public abstract List<Charac> queryCharactersByHashMap(Map<String, Object> map);
	
	//存储过程
	public abstract void queryCountByProcedure(Map<String, Object> map);
	
	//HashMap别名
	public abstract List<Map<String, Object>> queryCharactersByNotAll();
	
	//动态SQL语句查找
	Charac queryCharactersByDynamic(int id);
	
	//双表联查
	Worker queryWorkerAndCardById(int id );
	
	//
	Depart queryDepartment(int id);
	
}
