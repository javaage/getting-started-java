package com.cisco.la.service.impl;
import com.cisco.la.entity.GoldenSampleJoin;
import com.cisco.la.join.GoldenSampleJoinMapper;
import com.cisco.la.mapper.GoldenSampleModelMapper;
import com.cisco.la.model.CourseModel;
import com.cisco.la.model.GoldenSampleModel;
import com.cisco.la.model.GoldenSampleModel;
import com.cisco.la.model.GoldenSampleModelExample;
import com.cisco.la.model.GoldenSampleModelExample.Criteria;
import com.cisco.la.service.CourseService;
import com.cisco.la.service.GoldenSampleService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoldenSampleServiceImpl implements GoldenSampleService {
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private CourseService courseService;
	
	public void addGoldenSample(GoldenSampleModel goldenSampleModel) {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		goldenSampleModelMapper.insert(goldenSampleModel);
	}

	public void updateGoldenSample(GoldenSampleModel goldenSampleModel) {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		goldenSampleModelMapper.updateByPrimaryKey(goldenSampleModel);
	}

	@Override
	public List<GoldenSampleJoin> getGoldenSampleList() {
		GoldenSampleJoinMapper goldenSampleJoinMapper = sqlSession.getMapper(GoldenSampleJoinMapper.class);

		return goldenSampleJoinMapper.getGoldenSampleJoin();
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.GoldenSampleService#getGoldenSampleByName(java.lang.String)
	 */
	@Override
	public GoldenSampleModel getGoldenSampleByID(int id) {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		return goldenSampleModelMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.GoldenSampleService#getGoldenSampleListByRoleID(int)
	 */
	@Override
	public List<GoldenSampleModel> getGoldenSampleListByRoleID(int roleID) {
		GoldenSampleModelMapper goldenSampleModelMapper = sqlSession.getMapper(GoldenSampleModelMapper.class);
		
		GoldenSampleModelExample example = new GoldenSampleModelExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIDEqualTo(roleID);
		return goldenSampleModelMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.GoldenSampleService#getGoldenSampleStringByRoleID(int)
	 */
	@Override
	public String getGoldenSampleStringByRoleID(int roleID) {
		StringBuilder result = new StringBuilder("");
		List<GoldenSampleModel> listSample = getGoldenSampleListByRoleID(roleID);
		if(listSample!=null && listSample.size()>0){
			String strMandatory = listSample.get(0).getMandatory();
			String strOptional = listSample.get(0).getOptional();
			
			List<CourseModel> listMandatory = courseService.getCourseListByList(strMandatory);
			List<CourseModel> listOptional = courseService.getCourseListByList(strOptional);
			
			result.append("<br>## Mandatory:");
			for(CourseModel courseModel : listMandatory){
				if(courseModel.getUrl()!=null && !courseModel.getUrl().isEmpty())
					result.append(String.format("<br>[%s](%s)",courseModel.getCourseName(), courseModel.getUrl()));
				else
					result.append("<br>" + courseModel.getCourseName());
			}
			result.append("<br>## Optional:");
			for(CourseModel courseModel : listOptional){
				if(courseModel.getUrl()!=null && !courseModel.getUrl().isEmpty())
					result.append(String.format("<br>[%s](%s)",courseModel.getCourseName(), courseModel.getUrl()));
				else
					result.append("<br>" + courseModel.getCourseName());
			}
		}
		return result.toString();
	}
}
