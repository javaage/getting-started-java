package com.cisco.la.mapper;

import com.cisco.la.model.QuizModel;
import com.cisco.la.model.QuizModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuizModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	long countByExample(QuizModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int deleteByExample(QuizModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int insert(QuizModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int insertSelective(QuizModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	List<QuizModel> selectByExample(QuizModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	QuizModel selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int updateByExampleSelective(@Param("record") QuizModel record, @Param("example") QuizModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int updateByExample(@Param("record") QuizModel record, @Param("example") QuizModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int updateByPrimaryKeySelective(QuizModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_quiz
	 * @mbg.generated  Tue Apr 03 13:57:50 CST 2018
	 */
	int updateByPrimaryKey(QuizModel record);
}