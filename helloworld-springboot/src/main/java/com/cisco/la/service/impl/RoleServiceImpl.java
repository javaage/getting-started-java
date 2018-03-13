package com.cisco.la.service.impl;

import com.cisco.la.join.RoleMapper;
import com.cisco.la.mapper.RoleModelMapper;
import com.cisco.la.model.RoleModel;
import com.cisco.la.model.RoleModelExample;
import com.cisco.la.model.RoleModelExample.Criteria;
import com.cisco.la.service.RoleService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addRole(RoleModel roleModel) {
		RoleModelMapper roleModelMapper = sqlSession.getMapper(RoleModelMapper.class);
		roleModelMapper.insert(roleModel);
	}

	public void updateRole(RoleModel roleModel) {
		RoleModelMapper roleModelMapper = sqlSession.getMapper(RoleModelMapper.class);
		roleModelMapper.updateByPrimaryKey(roleModel);
	}

	@Override
	public List<RoleModel> getRoleList() {
		RoleModelMapper roleModelMapper = sqlSession.getMapper(RoleModelMapper.class);
		RoleModelExample roleModelExample = new RoleModelExample();
		roleModelExample.setOrderByClause("rl_active desc");
		return roleModelMapper.selectByExample(roleModelExample);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.RoleService#getRoleByName(java.lang.String)
	 */
	@Override
	public RoleModel getRoleByID(int id) {
		RoleModelMapper roleModelMapper = sqlSession.getMapper(RoleModelMapper.class);
		return roleModelMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.RoleService#getRoleByName(java.lang.String)
	 */
	@Override
	public RoleModel getRoleByName(String roleName) {
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		
		return roleMapper.getRoleByName(roleName);
	}

	@Override
	public List<RoleModel> getRoleByIDs(String ids) {
		RoleModelMapper roleModelMapper = sqlSession.getMapper(RoleModelMapper.class);
		RoleModelExample roleModelExample = new RoleModelExample();
		
		Criteria criteria = roleModelExample.createCriteria();
		List<Integer> idList = new ArrayList<Integer>();
		String[] idArray = ids.split(",");
		
		for(int i = 0; i < idArray.length; i++){
			if(!idArray[i].trim().isEmpty())
				idList.add(Integer.parseInt(idArray[i].trim())); 
		}
		if(idList.size()>0){
			criteria.andIdIn(idList);
			criteria.andActiveEqualTo(true);
			return roleModelMapper.selectByExample(roleModelExample);
		}else{
			return new ArrayList<RoleModel>();
		}
	}

}
