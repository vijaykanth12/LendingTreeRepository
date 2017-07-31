package com.lendingtree.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.dao.MessageModelDao;
import com.lendingtree.model.MessageModel;
//@Service("MessageModelService")
@Stateless
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class MessageModelServiceImpl implements MessageModelService {


	@Autowired
	 private MessageModelDao mdao;

	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void msgsave(MessageModel msgs) {
		// TODO Auto-generated method stub
		mdao.msgsave(msgs);
	}

@Override
	public List<MessageModel> getType(HttpServletRequest request, String type) {
		// TODO Auto-generated method stub
		return mdao.getType(request, type);
	}

@Override
public List<MessageModel> getRegId(HttpServletRequest request, Integer ids) {
	// TODO Auto-generated method stub
	return mdao.getRegId(request, ids);
}

@Override
public List<MessageModel> getUserMsg(HttpServletRequest request, String type,
		Integer id) {
	// TODO Auto-generated method stub
	return mdao.getUserMsg(request, type, id);
}



}
