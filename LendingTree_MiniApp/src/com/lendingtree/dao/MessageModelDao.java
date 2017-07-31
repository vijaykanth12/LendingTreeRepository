package com.lendingtree.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lendingtree.model.MessageModel;

public interface MessageModelDao {

	// Message Dao
		public void msgsave(MessageModel msgs);
		
		public List<MessageModel> getType(HttpServletRequest request, String type);
		public List<MessageModel> getRegId(HttpServletRequest request, Integer ids);
		
	
		
		public List<MessageModel> getUserMsg(HttpServletRequest request,
				String type, Integer id);
}
