package com.cisco.la.mapper;

import com.cisco.la.model.QuestionModel;
import com.cisco.la.model.QuestionModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_question
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	long countByExample(QuestionModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_question
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int deleteByExample(QuestionModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_question
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int insert(QuestionModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_question
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int insertSelective(QuestionModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_question
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	List<QuestionModel> selectByExample(QuestionModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_question
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int updateByExampleSelective(@Param("record") QuestionModel record, @Param("example") QuestionModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_question
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int updateByExample(@Param("record") QuestionModel record, @Param("example") QuestionModelExample example);
}