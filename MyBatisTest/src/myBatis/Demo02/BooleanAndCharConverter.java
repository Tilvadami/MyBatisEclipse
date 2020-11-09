package myBatis.Demo02;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;


//类型转换器（将java类型转为jdbc类型，或将jdbc类型转为java类型）
public class BooleanAndCharConverter extends BaseTypeHandler<Boolean> {

	// java -> jdbc
	/*
	 * ps:PreparedStatement对象 i:PreparedStatement对象操作参数的位置 parameter:java值
	 * jdbcType:jdbc操作的数据库类型
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		//java数据写入数据库，检查java数据的值，将它转成想要的jdbc值
		if (parameter)
			ps.setString(i, "男");
		else
			ps.setString(i, "女");
	}

	// jdbc -> java
	/*
	 * jdbc数据取出，检查jdbc数据的值，将它转成java类型的值
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		/*
		 * columnName:jdbc列名
		 */
		if ("男".equals(rs.getString(columnName))) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		/*
		 * columnIndex:jdbc列的索引
		 */
		if ("男".equals(rs.getString(columnIndex))) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		/*
		 * cs:存储过程;columnIndex:jdbc列索引
		 */
		if ("男".equals(cs.getString(columnIndex))) {
			return true;
		} else {
			return false;
		}

	}

}
