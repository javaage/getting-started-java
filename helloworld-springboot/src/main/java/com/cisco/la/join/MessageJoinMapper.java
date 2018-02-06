package com.cisco.la.join;

import com.cisco.la.model.MessageModel;
import com.cisco.la.model.MessageModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageJoinMapper {
	
	List<MessageModel> getLostSessionMessage();

}