package com.lendingtree.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendingtree.model.UploadFile;

@Repository("uploade")
public class UploadFileDaoImpl implements UploadFileDao{
	@Autowired
	 private SessionFactory sessionFactory;

	@Override
	public void addDocs(UploadFile pm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(pm);
	}
}
