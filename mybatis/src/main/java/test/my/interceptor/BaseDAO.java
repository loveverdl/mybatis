package test.my.interceptor;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;


/**
 * 定义通用DAO操作
 */
@SuppressWarnings("unchecked")
public class BaseDAO {

    private SqlSession session;

    /**
     * 保存
     */
    public static final String POSTFIX_INSERT = ".insert";

    /**
     * 选择性插入
     */
    public static final String POSTFIX_INSERT_SELECTIVE = ".insertSelective";

    /**
     * 根据主键更新
     */
    public static final String POSTFIX_UPDATE_PRIAMARYKEY = ".updateByPrimaryKey";

    /**
     * 根据主键更新不为空字段
     */
    public static final String POSTFIX_UPDATE_SELECTIVE = ".updateByPrimaryKeySelective";

    /**
     * 根据主键删除
     */
    public static final String POSTFIX_DELETE_PRIAMARYKEY = ".deleteByPrimaryKey";

    /**
     * 根据条件删除
     */
    public static final String POSTFIX_DELETE_EXAMPLE = ".deleteByExample";

    /**
     * 根据主键查询
     */
    public static final String POSTFIX_SELECT_PRIAMARYKEY = ".selectByPrimaryKey";

    /**
     * 根据查询条件查询
     */
    public static final String POSTFIX_SELECT_EXAMPLE = ".selectByExample";

    /**
     * 根据查询条件统计
     */
    public static final String POSTFIX_COUNT_EXAMPLE = ".countByExample";

    /**
     * 插入业务对象
     * 
     * @param entity
     * @param session
     * @param mapClass
     * @return
     */
    public <T> T insert(T entity, Class<? extends Object> mapClass) {
        if (session.insert(mapClass.getName() + POSTFIX_INSERT, entity) > 0) {
            return entity;
        }
        return null;
    }

    /**
     * 插入不为null的值
     * 
     * @param entity
     * @param session
     * @param mapClass
     * @return
     */
    public <T> T insertSelective(T entity, Class<? extends Object> mapClass) {
        if (session.insert(mapClass.getName() + POSTFIX_INSERT_SELECTIVE, entity) > 0) {
            return entity;
        }
        return null;
    }

    /**
     * 更新业务对象
     * 
     * @param entity
     * @param session
     * @param mapClass
     * @return
     */
    public int updateByPrimaryKey(Object entity, Class<? extends Object> mapClass) {
        return session.update(mapClass.getName() + POSTFIX_UPDATE_PRIAMARYKEY, entity);
    }

    /**
     * 更新不为null的字段
     * 
     * @param entity
     * @param session
     * @param mapClass
     * @return
     */
    public int updateByPrimaryKeySelective(Object entity, Class<? extends Object> mapClass) {
        return session.update(mapClass.getName() + POSTFIX_UPDATE_SELECTIVE, entity);
    }

    /**
     * 根据主键删除对象
     * 
     * @param primaryKey
     * @param session
     * @param mapClass
     * @return
     */
    public int deleteByPrimaryKey(Object primaryKey, Class<? extends Object> mapClass) {
        return session.delete(mapClass.getName() + POSTFIX_DELETE_PRIAMARYKEY, primaryKey);
    }

    /**
     * 根据条件删除对象
     * 
     * @param example
     * @param session
     * @param mapClass
     * @return
     */
    public int deleteByExample(Object example, Class<? extends Object> mapClass) {
        return session.delete(mapClass.getName() + POSTFIX_DELETE_EXAMPLE, example);
    }

    /**
     * 根据主键查询
     * 
     * @param primaryKey
     * @param session
     * @param mapClass
     * @return
     */
    public <T> T selectByPrimaryKey(Object primaryKey, Class<? extends Object> mapClass) {
        return (T) session.selectOne(mapClass.getName() + POSTFIX_SELECT_PRIAMARYKEY, primaryKey);
    }

    /**
     * 根据查询条件查询
     * 
     * @param example
     * @param mapClass
     * @return
     */
    public <T> List<T> selectByExample(Object example, Class<? extends Object> mapClass) {
        return session.selectList(mapClass.getName() + POSTFIX_SELECT_EXAMPLE, example);
    }

    /**
     * 根据查询条件分页查询
     * 
     * @param example
     * @param session
     * @param mapClass
     * @param pageNo
     * @param pageSize
     * @return
     */
    public <T> List<T> selectByExample(Object example, Class<? extends Object> mapClass, int offset, int pageSize) {
        int limit = pageSize;
        return session.selectList(mapClass.getName() + POSTFIX_SELECT_EXAMPLE, example, new RowBounds(offset, limit));
    }

    /**
     * 根据查询条件获取一条唯一信息
     * 
     * @param example
     * @param mapClass
     * @return
     */

    public <T> T selectByOne(Object example, Class<? extends Object> mapClass) {
        return (T) session.selectOne(mapClass.getName() + POSTFIX_SELECT_EXAMPLE, example);
    }

    /**
     * 根据条件统计数据
     * 
     * @param example
     * @param mapClass
     * @return
     */
    public int countByExample(Object example, Class<? extends Object> mapClass) {
        return (Integer) session.selectOne(mapClass.getName() + POSTFIX_COUNT_EXAMPLE, example);
    }

    /**
     * 分页查询，该方法适合Mybatis Generate生成的Mapper类，用户不需要提供具体函数名
     * 
     * @param mapClass
     *            mapper.class 如BizMapper.class
     * @param example
     *            查询条件
     * @param pageNo
     *            页码
     * @param pageSize
     *            每页显示条数
     * @return
     */
    @SuppressWarnings("rawtypes")
    public <T> PageResponse<T> pagedQuery(Class<? extends Object> mapClass, Object example, int offset, int pageSize) {

        Integer totalCount = countByExample(example, mapClass);

        if (totalCount == null)
            return new PageResponse();

        if (totalCount == 0 || pageSize == 0) {
            return new PageResponse();
        }

        List<T> list;

        if (pageSize > 0 && offset >= 0) {
            list = selectByExample(example, mapClass, offset, pageSize);
        } else {
            pageSize = totalCount;
            list = selectByExample(example, mapClass);
        }
        return new PageResponse(totalCount, list);
    }

    public <T> List<T> selectByMethod(Class<? extends Object> mapClass, String methodName, Object param, int offset,
            int pageSize) {

        if (offset < 0) {
            offset = 0;
        }
        return session.selectList(mapClass.getName() + "." + methodName, param, new RowBounds(offset, pageSize));
    }

    /**
     * 根据条件统计数据
     * 
     * @param example
     * @param mapClass
     * @return
     */
    public int countByMethod(Class<? extends Object> mapClass, String methodName, Object param) {
        return (Integer) session.selectOne(mapClass.getName() + "." + methodName, param);
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

}
