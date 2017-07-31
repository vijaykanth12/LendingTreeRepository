package com.lendingtree.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.bean.RegistrationBean;
import com.lendingtree.dao.RegistrationDao;
import com.lendingtree.model.ApplicationLog;
import com.lendingtree.model.LoanApply;
import com.lendingtree.model.Registration;
import com.lendingtree.model.TransactionLog;
import com.lendingtree.model.UploadFile;
import com.lendingtree.model.UserRole;
import com.lendingtree.model.Userlist;
import com.lendingtree.model.Userslist;


//@Component
@Stateless
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	private RegistrationDao regDao;
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void reguser(Registration reg) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		regDao.reguser(reg);
	}

	@Override
	
	public List<Registration> listUsers() {
		// TODO Auto-generated method stub
		return regDao.listUsers();
	}

	@Override
	public List<Registration> getStudent(RegistrationBean bean) {
		// TODO Auto-generated method stub
		return regDao.getStudent(bean);
	}

	@Override
	public List<Registration> getUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		return regDao.getUser(uname, pwd);
	}

	@Override
	public List<Registration> forgotpass(String user, String email) {
		// TODO Auto-generated method stub
		return regDao.forgotpass(user, email);
	}

	@Override
	public List<Registration> getRegId(int id) {
		// TODO Auto-generated method stub
		return regDao.getRegId(id);
	}

	@Override
	public void editUser(Registration reg) {
		// TODO Auto-generated method stub
		regDao.editUser(reg);
	}

	@Override
	public void adminchangePassword(Integer id, String newpassword,
			String confirmnewpwd) {
		// TODO Auto-generated method stub
		regDao.adminchangePassword(id, newpassword, confirmnewpwd);
	}

	@Override
	public List<LoanApply> getReports() {
		// TODO Auto-generated method stub
		return regDao.getReports();
	}

	@Override
	public void saveApplicationLogDetails(String id, String description,
			String transtype,String modulename, String username)
			throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appLog(ApplicationLog almodel) {
		// TODO Auto-generated method stub
		regDao.appLog(almodel);
	}

	@Override
	public void logoutAppLog(String username,String logintime, String logouttime) {
		// TODO Auto-generated method stub
		regDao.logoutAppLog(username,logintime,logouttime);
	}

	@Override
	public void addDocs(UploadFile pm) {
		// TODO Auto-generated method stub
		regDao.addDocs(pm);
	}

	@Override
	public void Transactionlogdetails(TransactionLog tllog) {
		// TODO Auto-generated method stub
		regDao.Transactionlogdetails(tllog);
	}

	@Override
	public void activateuser(String un) {
		// TODO Auto-generated method stub
		regDao.activateuser(un);
	}

	@Override
	public void saveuserslist(Userslist uli) {
		// TODO Auto-generated method stub
		regDao.saveuserslist(uli);
	}

	@Override
	public void saveuserrole(UserRole ur) {
		// TODO Auto-generated method stub
		
		regDao.saveuserrole(ur);
	}

	

	
	
	

}
