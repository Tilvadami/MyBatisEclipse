package myBatis.Demo04.mapper;

import java.util.List;
import myBatis.Demo04.pojo.Account;
import myBatis.Demo04.pojo.AccountExample;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

	long countByExample(AccountExample example);

	int deleteByExample(AccountExample example);

	int deleteByPrimaryKey(String accountid);

	int insert(Account record);

	int insertSelective(Account record);

	List<Account> selectByExample(AccountExample example);

	Account selectByPrimaryKey(String accountid);

	int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

	int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

	int updateByPrimaryKeySelective(Account record);

	int updateByPrimaryKey(Account record);
}