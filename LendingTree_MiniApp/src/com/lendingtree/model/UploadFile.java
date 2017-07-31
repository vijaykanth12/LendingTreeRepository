package com.lendingtree.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filesupload")
public class UploadFile {
	
	
	@Column(name = "file")
	private String file;
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
