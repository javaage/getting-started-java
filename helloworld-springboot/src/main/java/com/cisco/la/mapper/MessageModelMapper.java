package com.cisco.la.mapper;

import com.cisco.la.model.MessageModel;
import com.cisco.la.model.MessageModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	long countByExample(MessageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int deleteByExample(MessageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int insert(MessageModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int insertSelective(MessageModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	List<MessageModel> selectByExample(MessageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	MessageModel selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByExampleSelective(@Param("record") MessageModel record, @Param("example") MessageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByExample(@Param("record") MessageModel record, @Param("example") MessageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByPrimaryKeySelective(MessageModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_message
	 * @mbg.generated  Thu Apr 12 17:19:19 CST 2018
	 */
	int updateByPrimaryKey(MessageModel record);
}