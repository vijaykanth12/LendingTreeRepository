package com.lendingtree.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;

@Repository("ddao")
public class DeptDaoImpl implements DeptDao {


	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public void adddept(Dept dept) {
		// TODO Auto-generated method stub
		/*Dept r=new Dept();
		List lis=(List<Dept>) sessionFactory.getCurrentSession().createCriteria(Dept.class).list();
		int id=0;
		if(lis.size()>0)
		{
			Iterator it=lis.iterator();
			String d=null;
	     	while(it.hasNext())
	     	{
	     		r=(Dept)it.next();
	     		d=r.getDeptid();
	     		System.out.println(" Did values is :"+d);
	     	}
	        id=Integer.parseInt(d);
	        id=id+1;
	        d=String.valueOf(id);
	        dept.setDeptid(d);
		}*/
		Dept r=new Dept();
		List lis=(List<Dept>) sessionFactory.getCurrentSession().createCriteria(Dept.class).list();
		int id=0;
		String cid=null,i=null,ii=null;
		if(lis.size()>0)
		{
			Iterator it=lis.iterator();
			String d=null;
	     	while(it.hasNext())
	     	{
	     		r=(Dept)it.next();
	     		d=r.getDeptid();
	     	}	
			System.out.println("in reg:"+d);
	        ii=d.substring(3);
	        id=Integer.parseInt(ii);
	        id=id+1;
	        if(id>9)
	        {
	    	  i=String.valueOf(id);
	    	  i="LTD"+i;
	    	 dept.setDeptid(i);
	        }
	        else
	        {
	        	i=String.valueOf(id);
		    	i="LTD00"+i;
		    	dept.setDeptid(i);
	        }
		}
		else
		{
			cid="LTD001";
			dept.setDeptid(cid);
		}
		sessionFactory.getCurrentSession().saveOrUpdate(dept);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> getDepts() {
		// TODO Auto-generated method stub
		return  (List<Dept>) 
				sessionFactory.getCurrentSession().createQuery("FROM Dept").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> getDeptId(String id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Dept where deptid='"+id+"'").list();
	}

	@Override
	public void editDept(Dept dept) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(dept);
	}

	@Override
	public void deleteDept(String id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Dept WHERE  deptid = '"+id+"'").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> listDepts() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select DISTINCT dname FROM Dept").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Employee> getDepts(int id) {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().createQuery("From Dept where id='"+id+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> listDept() {
		return sessionFactory.getCurrentSession().createQuery("FROM Dept").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> viewdepts(String did) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Dept WHERE deptid = '"+did+"'").list();
	}

	
	
}
