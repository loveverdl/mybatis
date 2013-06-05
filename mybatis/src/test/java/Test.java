import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import city.cloud.mybatis.test.SqlSesionFactoryUtil;

import test.dao.KindMapper;
import test.dao.PictureSetMapper;
import test.model.Kind;
import test.pojo.PictureSetDetail;

public class Test {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sqlMapper = SqlSesionFactoryUtil.getFactory();
		SqlSession sqlSession = sqlMapper.openSession();
		KindMapper km = sqlSession.getMapper(KindMapper.class);
		Kind kk = new Kind();
		kk.setKind_name("asd");
		km.insert(kk);
		PictureSetMapper psm = sqlSession.getMapper(PictureSetMapper.class);
		PictureSetDetail psd=psm.getDetail(31);
		System.out.println(psd.getList().toString());
		sqlSession.commit();
		Kind k = km.selectByPrimaryKey(10001);
		System.out.println(k.getKind_name());
	}
}
