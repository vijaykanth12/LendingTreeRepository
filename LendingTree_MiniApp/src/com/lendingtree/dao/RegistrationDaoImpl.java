package com.lendingtree.dao;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendingtree.bean.ApplicationLogBean;
import com.lendingtree.bean.RegistrationBean;
import com.lendingtree.bean.Transactionbean;
import com.lendingtree.model.ApplicationLog;
import com.lendingtree.model.LoanApply;
import com.lendingtree.model.Registration;
import com.lendingtree.model.TransactionLog;
import com.lendingtree.model.UploadFile;
import com.lendingtree.model.UserRole;
import com.lendingtree.model.Userlist;
import com.lendingtree.model.Userslist;


@Repository("regDao")
public class RegistrationDaoImpl implements RegistrationDao{
	
	
	@Autowired
	 private SessionFactory sessionFactory;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> listUsers() {
		// TODO Auto-generated method stub
		return (List<Registration>) 
				 sessionFactory.getCurrentSession().createCriteria(Registration.class).list();
	}

	@Override
	public void reguser(Registration reg) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(reg);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> getStudent(RegistrationBean bean) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Registration where username='"+bean.getUsername()+"'and password='"+bean.getPassword()+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> getUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Registration where username='"+uname+"'and password='"+pwd+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> forgotpass(String user, String email) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Registration where username='"+user+"'and emailid='"+email+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> getRegId(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Registration where id='"+id+"'").list();
	}

	@Override
	public void editUser(Registration reg) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(reg);
	}

	@Override
	public void adminchangePassword(Integer id, String newpassword,
			String confirmnewpwd) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().createQuery("UPDATE Registration set password='"+newpassword+"',conformpassword='"+confirmnewpwd+"' where id='"+id+"'").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanApply> getReports() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From LoanApply where status='Sanction'").list();
	}

	@Override
	public void saveApplicationLogDetails(String id, String description,
			String transtype, String modulename, String username) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		System.out.println("Application Log is Runnning");
		Date date1 = new Date();   	
	       	SimpleDateFormat d = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	       	String d1 = d.format(date1); 
	       	HttpSession hs = request.getSession();
	       	hs.setAttribute("logtime", d1);
	
		/*Transactionbean txlog=TXLog.getTx();
		txlog.setTransactionnumber(id);
		txlog.setCurrentname(id);
		txlog.setDescription(description);
		txlog.setTransactiontype(transtype);
		txlog.setType(modulename);
		txlog.setEmployee(username);	*/
	
	     
	   /*  ApplicationLogBean bean=new ApplicationLogBean();
	     bean.setTransactionnumber(id);
	     bean.setCurrentname(id);
	     bean.setDescription(description);
	     bean.setTransactiontype(transtype);
	     bean.setType(modulename);
	     bean.setEmployee(username);
		 ApplicationLog appmodel=new ApplicationLog();
		 appmodel.setLogintime(d1);
	     BeanUtils.copyProperties(appmodel,bean);
		 sessionFactory.getCurrentSession().save(appmodel);*/
		
			

	}

	public void appLog(ApplicationLog almodel) {
		// TODO Auto-generated method stub
		System.out.println("Application log is Running ");
		sessionFactory.getCurrentSession().save(almodel);
	}

	@Override
	public void logoutAppLog(String username,String logintime, String logouttime) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("update ApplicationLog set logouttime = '"+logouttime+"' where userame ='"+username+"' and logindate = '"+logintime+"'").executeUpdate();
	}

	@Override
	public void addDocs(UploadFile pm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(pm);
	}

	@Override
	public void Transactionlogdetails(TransactionLog tllog) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(tllog);
	}

	@Override
	public void activateuser(String un) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().createQuery("UPDATE Userslist set enabled='1',status='active' where username='"+un+"' ").executeUpdate();
	}

	@Override
	public void saveuserslist(Userslist uli) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(uli);
	}

	@Override
	public void saveuserrole(UserRole ur) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(ur);
	}


	
	

	

}
