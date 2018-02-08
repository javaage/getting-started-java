package com.cisco.la.service.impl;
import com.cisco.la.Application;
import com.cisco.la.common.CustomMessage;
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
import java.util.Date;

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
			
			if(listMandatory.size()>0){
				result.append("<br>\r\n### Mandatory:");
				for(CourseModel courseModel : listMandatory){
					if(courseModel.getUrl()!=null && !courseModel.getUrl().isEmpty())
						result.append(String.format("<br>\r\n[%s](%s)",courseModel.getCourseName(), courseModel.getUrl()));
					else
						result.append("<br>\r\n" + courseModel.getCourseName());
				}
			}
			
			if(listOptional.size()>0){
				result.append("<br>\r\n### Optional:");
				for(CourseModel courseModel : listOptional){
					if(courseModel.getUrl()!=null && !courseModel.getUrl().isEmpty())
						result.append(String.format("<br>\r\n[%s](%s)",courseModel.getCourseName(), courseModel.getUrl()));
					else
						result.append("<br>\r\n" + courseModel.getCourseName());
				}
			}
			
		}
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.GoldenSampleService#getRecentCourseModel(int)
	 */
	@Override
	public CourseModel getRecentCourseModel(int roleID) {
		List<GoldenSampleModel> listSample = getGoldenSampleListByRoleID(roleID);
		Long recent = new Date(Long.MAX_VALUE).getTime();
		CourseModel recentCourse = null;
		
		if(listSample!=null && listSample.size()>0){
			String strMandatory = listSample.get(0).getMandatory();
			List<CourseModel> listMandatory = courseService.getCourseListByList(strMandatory);
			
			for(CourseModel courseModel : listMandatory){
				if(courseModel.getStartDate()!=null && courseModel.getStartDate().getTime() <= recent){
					recent = courseModel.getStartDate().getTime();
					recentCourse = courseModel;
				}
			}
		}
		return recentCourse;
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.GoldenSampleService#getRecentCoursePref(int)
	 */
	@Override
	public String getRecentCoursePref(int roleID) { //CHAT_BOLT_PREFER_RECENT_COURSE
		CourseModel courseModel = getRecentCourseModel(roleID);
		if(courseModel!=null){
			Application.logger.debug(courseModel.getStartDate().toString());
			Application.logger.debug(new Date().toString());
			long delta = courseModel.getStartDate().getTime() - new Date().getTime();
			long days = delta/(1000 * 60 * 60 * 24);
			Application.logger.debug(days+"");
			if(courseModel.getUrl()!=null && !courseModel.getUrl().isEmpty()) //[%s](%s)
				return String.format(CustomMessage.CHAT_BOLT_PREFER_RECENT_COURSE, "[" + courseModel.getCourseName() + "](" + courseModel.getUrl() +")", days + " days");
			else
				return String.format(CustomMessage.CHAT_BOLT_PREFER_RECENT_COURSE, courseModel.getCourseName(), days + " days");
		}else{
			return "";
		}
	}
}
