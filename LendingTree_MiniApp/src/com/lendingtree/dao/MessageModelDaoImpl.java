package com.lendingtree.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendingtree.model.MessageModel;
@Repository("mdao")
public class MessageModelDaoImpl implements MessageModelDao {

	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public void msgsave(MessageModel msgs) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(msgs);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageModel> getType(HttpServletRequest request, String type) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From MessageModel where tou='"+type+"'").list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageModel> getRegId(HttpServletRequest request, Integer ids) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From MessageModel where regid='"+ids+"'").list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageModel> getUserMsg(HttpServletRequest request,
			String type, Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From MessageModel where tou='"+type+"' and regid='"+id+"'").list();
	}

}
