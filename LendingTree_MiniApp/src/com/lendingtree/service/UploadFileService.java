package com.lendingtree.service;



import javax.ejb.Local;

import com.lendingtree.model.UploadFile;

@Local
public interface UploadFileService {

	void addDocs(UploadFile pm);

	

}
