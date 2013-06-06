package spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dao.KindMapper;

public class WithSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SqlSessionFactory fact = (SqlSessionFactory)context.getBean("sqlSessionFactoryMgr");
		SqlSession session = fact.openSession();
		KindMapper km = session.getMapper(KindMapper.class);
		System.out.println(km.selectByPrimaryKey(10002).getKind_name());
	}

}
