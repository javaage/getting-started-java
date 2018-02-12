package com.cisco.la.mapper;

import com.cisco.la.model.UserModel;
import com.cisco.la.model.UserModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	long countByExample(UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int deleteByExample(UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int insert(UserModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int insertSelective(UserModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	List<UserModel> selectByExample(UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	UserModel selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int updateByExampleSelective(@Param("record") UserModel record, @Param("example") UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int updateByExample(@Param("record") UserModel record, @Param("example") UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int updateByPrimaryKeySelective(UserModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_user
	 * @mbg.generated  Mon Feb 12 10:00:19 CST 2018
	 */
	int updateByPrimaryKey(UserModel record);
}