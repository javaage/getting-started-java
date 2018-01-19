package com.cisco.la.mapper;

import com.cisco.la.model.CourseHistoryModel;
import com.cisco.la.model.CourseHistoryModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseHistoryModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	long countByExample(CourseHistoryModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	int deleteByExample(CourseHistoryModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	int insert(CourseHistoryModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	int insertSelective(CourseHistoryModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	List<CourseHistoryModel> selectByExample(CourseHistoryModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	int updateByExampleSelective(@Param("record") CourseHistoryModel record,
			@Param("example") CourseHistoryModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_crs_history
	 * @mbg.generated  Thu Jan 18 15:28:55 CST 2018
	 */
	int updateByExample(@Param("record") CourseHistoryModel record,
			@Param("example") CourseHistoryModelExample example);
}