package myBatis.Demo04;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.lang.Exception;

public class GeneratorSqlmap{
	
	public void generator() throws Exception{
		
		List<String> warnings = new ArrayList<>();
		boolean overwrite = true;
		
//		指定配置文件
		File configFile = new File("E:\\javanew\\MyBatisTest\\src\\generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
		
		generator.generate(null);
	}
	
	public static void main(String[] args) {
		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
			System.out.println("gg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
