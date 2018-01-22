package com.cisco.la.mapper;

import com.cisco.la.model.RoleModel;
import com.cisco.la.model.RoleModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	long countByExample(RoleModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int deleteByExample(RoleModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int deleteByPrimaryKey(int id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int insert(RoleModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int insertSelective(RoleModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	List<RoleModel> selectByExample(RoleModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	RoleModel selectByPrimaryKey(int id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int updateByExampleSelective(@Param("record") RoleModel record, @Param("example") RoleModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int updateByExample(@Param("record") RoleModel record, @Param("example") RoleModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int updateByPrimaryKeySelective(RoleModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.la_role
	 * @mbg.generated  Mon Jan 22 13:40:04 CST 2018
	 */
	int updateByPrimaryKey(RoleModel record);
}