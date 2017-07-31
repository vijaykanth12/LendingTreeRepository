package com.lendingtree.service;

import java.util.List;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;




import com.lendingtree.model.MessageModel;

@Local
public interface MessageModelService {

	public void msgsave(MessageModel msgs);

	public List<MessageModel> getType(HttpServletRequest request, String type);

	public List<MessageModel> getRegId(HttpServletRequest request, Integer ids);

	public List<MessageModel> getUserMsg(HttpServletRequest request,
			String type, Integer id);

}
