package com.lendingtree.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendingtree.bean.EmployeeBean;
import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;

@Repository("empdao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	 private SessionFactory sessionFactory;

	/*public void addemployee(Employee emp) {
		// TODO Auto-generated method stub
	
		
	
    	
    	Employee r=new Employee();
		List lis=(List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		int id=0;
		String cid=null,i=null,ii=null;
		if(lis.size()>0)
		{
			Iterator it=lis.iterator();
			String d=null;
	     	while(it.hasNext())
	     	{
	     		r=(Employee)it.next();
	     		d=r.getId();
	     	}	
			System.out.println("in reg:"+d);
	        ii=d.substring(3);
	        id=Integer.parseInt(ii);
	        id=id+1;
	        if(id>9)
	        {
	    	  i=String.valueOf(id);
	    	  i="LTS0"+i;
	    	  emp.setId(i);
	        }
	        else
	        {
	        	i=String.valueOf(id);
		    	i="LTS00"+i;
		    	emp.setId(i);
	        }
		}
		else
		{
			cid="LTS001";
			emp.setId(cid);
		}
		sessionFactory.getCurrentSession().save(emp);
		}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) 
				 sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeId(String id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Employee where id='"+id+"'").list();
	}
	@Override
	public void editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(emp);
	}
	@Override
	public void deleteEmploye(String id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE  id = '"+id+"'").executeUpdate();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployee(EmployeeBean beans) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Employee where username='"+beans.getUsername()+"'and password='"+beans.getPassword()+"'").list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList(String uname, String pwd) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Employee where username='"+uname+"'and password='"+pwd+"'").list();
	}
	@Override
	public void editVerification(Employee emp) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(emp);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getUser(String uname, String pwd) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Employee where username='"+uname+"'and password='"+pwd+"'").list();
	}
	@Override
	public void empchangePassword(String id, String newpassword,
			String confirmnewpwd) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().createQuery("UPDATE Employee set password='"+newpassword+"' where id='"+id+"'").executeUpdate();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listDepts() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select DISTINCT name FROM Employee").list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listUsers() {
		// TODO Auto-generated method stub
		return (List<Employee>) 
				 sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}
	/*@SuppressWarnings("unchecked")
	@Override
	public void addemployee(Employee emp,HttpServletRequest request) {
		// TODO Auto-generated method stub
		Employee r=new Employee();
		List lis=(List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		int id=0;
		String cid=null,i=null,ii=null;
		if(lis.size()>0)
		{
			Iterator it=lis.iterator();
			String d=null;
	     	while(it.hasNext())
	     	{
	     		r=(Employee)it.next();
	     		d=r.getId();
	     	}	
			System.out.println("in reg:"+d);
	        ii=d.substring(3);
	        id=Integer.parseInt(ii);
	        id=id+1;
	        if(id>9)
	        {
	    	  i=String.valueOf(id);
	    	  i="LTS0"+i;
	    	  emp.setId(i);
	        }
	        else
	        {
	        	i=String.valueOf(id);
		    	i="LTS00"+i;
		    	emp.setId(i);
	        }
		}
		else
		{
			cid="LTS001";
			emp.setId(cid);
		}
		 HttpSession ses=request.getSession(false);
		
		 List<Dept> l=(List)ses.getAttribute("deptlist");
		 
		 Dept dept=new Dept();
		 
		  	Set ss=new HashSet();
		  	Iterator itt=l.iterator();
	    	while(itt.hasNext())
	    	{
	    		Dept r1=(Dept)itt.next();
	    		dept.setDeptid(r1.getDeptid());
	    		dept.setDname(r1.getDname());
	    	}
	    	ss.add(emp);
	    
	    	dept.setChildren(ss);
	    		
		
		sessionFactory.getCurrentSession().saveOrUpdate(dept);
		}
	@Override*/
	
	public void addemp(Dept dept) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(dept);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> emplist() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Employee.class).addOrder(Order.asc("id")).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmpss(String un, String pwds) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Employee where username='"+un+"'and password='"+pwds+"'").list();
	}
	}
	



