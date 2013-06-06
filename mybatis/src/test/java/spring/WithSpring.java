package spring;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dao.KindMapper;
import test.model.Kind;

public class WithSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SqlSessionFactory fact = (SqlSessionFactory) context
				.getBean("sqlSessionFactoryMgr");
		SqlSession session = fact.openSession();
		KindMapper km = session.getMapper(KindMapper.class);
		System.out.println(km.selectByPrimaryKey(10002).getKind_name());
		List<Kind> list =session.selectList("test.dao.KindMapper.selectByExample", null,
				new RowBounds(2, 2));
		System.out.println(list.get(1).getKind_id());
	}

}
