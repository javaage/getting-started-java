package com.cisco.la.mapper;

import com.cisco.la.model.CourseModel;
import com.cisco.la.model.CourseModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	long countByExample(CourseModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int deleteByExample(CourseModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int deleteByPrimaryKey(int id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int insert(CourseModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int insertSelective(CourseModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	List<CourseModel> selectByExample(CourseModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	CourseModel selectByPrimaryKey(int id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByExampleSelective(@Param("record") CourseModel record, @Param("example") CourseModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByExample(@Param("record") CourseModel record, @Param("example") CourseModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByPrimaryKeySelective(CourseModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_course
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByPrimaryKey(CourseModel record);
}