package com.cisco.la.mapper;

import com.cisco.la.model.PaperModel;
import com.cisco.la.model.PaperModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	long countByExample(PaperModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int deleteByExample(PaperModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int insert(PaperModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int insertSelective(PaperModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	List<PaperModel> selectByExample(PaperModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	PaperModel selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int updateByExampleSelective(@Param("record") PaperModel record, @Param("example") PaperModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int updateByExample(@Param("record") PaperModel record, @Param("example") PaperModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int updateByPrimaryKeySelective(PaperModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_paper
	 * @mbg.generated  Wed Mar 14 16:19:03 CST 2018
	 */
	int updateByPrimaryKey(PaperModel record);
}