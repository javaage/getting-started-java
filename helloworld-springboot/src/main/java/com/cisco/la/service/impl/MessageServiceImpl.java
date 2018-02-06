package com.cisco.la.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.la.join.MessageJoinMapper;
import com.cisco.la.mapper.MessageModelMapper;
import com.cisco.la.model.MessageModel;
import com.cisco.la.model.MessageModelExample;
import com.cisco.la.model.MessageModelExample.Criteria;
import com.cisco.la.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private SqlSession sqlSession;
	
	public void addMessage(MessageModel messageModel) {
		MessageModelMapper messageModelMapper = sqlSession.getMapper(MessageModelMapper.class);
		messageModelMapper.insert(messageModel);
	}

	public void updateMessage(MessageModel messageModel) {
		MessageModelMapper messageModelMapper = sqlSession.getMapper(MessageModelMapper.class);
		messageModelMapper.updateByPrimaryKey(messageModel);
	}

	@Override
	public List<MessageModel> getMessageList() {
		MessageModelMapper messageModelMapper = sqlSession.getMapper(MessageModelMapper.class);
		MessageModelExample messageModelExample = new MessageModelExample();
		messageModelExample.setOrderByClause(" msg_id desc");
		return messageModelMapper.selectByExample(messageModelExample);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.MessageService#getMessageByName(java.lang.String)
	 */
	@Override
	public MessageModel getMessageByID(int id) {
		MessageModelMapper messageModelMapper = sqlSession.getMapper(MessageModelMapper.class);
		return messageModelMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.MessageService#getLatestMessageByUserID(java.lang.String)
	 */
	@Override
	public MessageModel getLatestMessageByUserID(String userID) {
		MessageModelMapper messageModelMapper = sqlSession.getMapper(MessageModelMapper.class);
		MessageModelExample messageModelExample = new MessageModelExample();
		Criteria criteria = messageModelExample.createCriteria();
		criteria.andUserIDEqualTo(userID);
		messageModelExample.setOrderByClause(" msg_id desc limit 1");
		List<MessageModel> listMessage = messageModelMapper.selectByExample(messageModelExample);
		if(listMessage.size()>0)
			return listMessage.get(0);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.MessageService#getActiveMessage(java.lang.String)
	 */
	@Override
	public List<MessageModel> getActiveMessage(String userID) {
		MessageModelMapper messageModelMapper = sqlSession.getMapper(MessageModelMapper.class);
		MessageModelExample messageModelExample = new MessageModelExample();
		Criteria criteria = messageModelExample.createCriteria();
		criteria.andUserIDEqualTo(userID);
		criteria.andActiveEqualTo(true);
		messageModelExample.setOrderByClause(" msg_session desc, msg_level");
		List<MessageModel> listMessage = messageModelMapper.selectByExample(messageModelExample);
		
		if(listMessage.size()>0){
			MessageModel messageModel = listMessage.get(0);
			MessageModelExample messageModelExampleDetail = new MessageModelExample();
			Criteria criteriaDetail = messageModelExampleDetail.createCriteria();
			criteriaDetail.andActiveEqualTo(true);
			criteriaDetail.andLevelEqualTo(messageModel.getLevel());
			messageModelExampleDetail.setOrderByClause(" msg_serial");
			return messageModelMapper.selectByExample(messageModelExampleDetail);
		}else{
			return new ArrayList<MessageModel>();
		}
	}

	/* (non-Javadoc)
	 * @see com.cisco.la.service.MessageService#getLostSessionMessage()
	 */
	@Override
	public List<MessageModel> getLostSessionMessage() {
		MessageJoinMapper messageJoinMapper = sqlSession.getMapper(MessageJoinMapper.class);
		return messageJoinMapper.getLostSessionMessage();
	}




}
