package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.dao.KindMapper;

public class WithSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		KindMapper km = (KindMapper) context.getBean("kindMapper");
		System.out.println(km.selectByPrimaryKey(10002).getKind_name());
	}

}
