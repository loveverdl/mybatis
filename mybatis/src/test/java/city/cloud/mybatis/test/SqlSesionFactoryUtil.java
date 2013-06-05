package city.cloud.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSesionFactoryUtil {

	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getFactory() throws IOException {
		if (sqlSessionFactory == null) {
			String resource = "dataSource.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		return sqlSessionFactory;
	}
}
