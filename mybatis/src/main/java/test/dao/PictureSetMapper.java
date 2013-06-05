package test.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.model.PictureSet;
import test.model.PictureSetExample;
import test.pojo.PictureSetDetail;

public interface PictureSetMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int countByExample(PictureSetExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int deleteByExample(PictureSetExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int deleteByPrimaryKey(Integer ps_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int insert(PictureSet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int insertSelective(PictureSet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	List<PictureSet> selectByExample(PictureSetExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	PictureSet selectByPrimaryKey(Integer ps_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int updateByExampleSelective(@Param("record") PictureSet record,
			@Param("example") PictureSetExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int updateByExample(@Param("record") PictureSet record,
			@Param("example") PictureSetExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int updateByPrimaryKeySelective(PictureSet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table picture_set
	 * 
	 * @mbggenerated Wed Jun 05 13:46:39 CST 2013
	 */
	int updateByPrimaryKey(PictureSet record);

	PictureSetDetail getDetail(int id);
}