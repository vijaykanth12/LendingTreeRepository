package com.lendingtree.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;




import javax.ejb.Local;

import com.lendingtree.bean.RegistrationBean;
import com.lendingtree.model.ApplicationLog;
import com.lendingtree.model.LoanApply;
import com.lendingtree.model.Registration;
import com.lendingtree.model.TransactionLog;
import com.lendingtree.model.UploadFile;
import com.lendingtree.model.UserRole;
//import com.lendingtree.model.Userlist;
import com.lendingtree.model.Userslist;

@Local
public interface RegistrationService {
	
	public void reguser(Registration reg)throws IllegalAccessException, InvocationTargetException ;
	
	public List<Registration> listUsers();
	public List<Registration> getStudent(RegistrationBean bean);
	public List<Registration> getUser(String uname, String pwd);
	public List<Registration> getRegId(int id);
	public List<Registration> forgotpass(String user, String email);
	public void editUser(Registration reg);
	
	public void adminchangePassword(Integer id, String newpassword,
			String confirmnewpwd);
	public List<LoanApply> getReports();

	
	public void saveApplicationLogDetails(String uname, String string,
			String string2, String string3, String uname2)throws IllegalAccessException, InvocationTargetException;

	
	public void appLog(ApplicationLog almodel);

	public void logoutAppLog(String username, String logintime, String logouttime);

	
	public void addDocs(UploadFile pm);
	

	public void Transactionlogdetails(TransactionLog tllog);

	
	public void activateuser(String un);

	public void saveuserslist(Userslist uli);

	public void saveuserrole(UserRole ur);

	

	
	

	
	

	
	

	
	
	
}
