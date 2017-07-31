package com.lendingtree.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transactionlogs")
public class TransactionLog implements java.io.Serializable  {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String tlId;
	private String username;
	private String type;
	private String task;
    private String taskdt;
      
    public String getTlId() {
		return tlId;
	}
	public void setTlId(String tlId) {
		this.tlId = tlId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getTaskdt() {
		return taskdt;
	}
	public void setTaskdt(String taskdt) {
		this.taskdt = taskdt;
	}
}