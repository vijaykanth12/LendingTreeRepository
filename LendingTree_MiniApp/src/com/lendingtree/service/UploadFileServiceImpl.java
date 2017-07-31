package com.lendingtree.service;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.dao.UploadFileDao;
import com.lendingtree.model.UploadFile;

@Stateless
//@Service("UploadFileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class UploadFileServiceImpl implements UploadFileService  {

	@Autowired
	 private UploadFileDao uploade;

	@Override
	public void addDocs(UploadFile pm) {
		// TODO Auto-generated method stub
		uploade.addDocs(pm);
	}
}
