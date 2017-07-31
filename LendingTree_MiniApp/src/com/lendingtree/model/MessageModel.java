package com.lendingtree.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lendmsgss")
public class MessageModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "id")
	 private Integer id;
	 
	 @Column(name = "regid")
	 private Integer regid;
	 
	 @Column(name = "fromu")
	 private String fromu;
	 
	 @Column(name = "tou")
	 private String tou;
	 
	 @Column(name = "subjectu")
	 private String subjectu;
	 
	 @Column(name = "messageu")
	 private String messageu;

	 public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getRegid() {
			return regid;
		}
		public void setRegid(Integer regid) {
			this.regid = regid;
		}
		public String getFromu() {
			return fromu;
		}
		public void setFromu(String fromu) {
			this.fromu = fromu;
		}
		public String getTou() {
			return tou;
		}
		public void setTou(String tou) {
			this.tou = tou;
		}
		public String getSubjectu() {
			return subjectu;
		}
		public void setSubjectu(String subjectu) {
			this.subjectu = subjectu;
		}
		public String getMessageu() {
			return messageu;
		}
		public void setMessageu(String messageu) {
			this.messageu = messageu;
		}
	
		
	
}
