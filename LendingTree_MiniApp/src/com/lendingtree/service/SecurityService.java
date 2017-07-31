package com.lendingtree.service;

import java.util.List;



import javax.ejb.Local;

import org.springframework.security.core.userdetails.UserDetails;

import com.lendingtree.bean.RegistrationBean;
import com.lendingtree.model.UserRole;
import com.lendingtree.model.Userslist;

@Local
public interface SecurityService {

	
	@SuppressWarnings("rawtypes")
	public List getSearchDetails(RegistrationBean login);
	
	public UserDetails loadUserByUsername(final String username);
	
	Userslist getUserDetails(String id);
	
	public List<UserRole> loadUserRoleByUsername(String username);
	
	@SuppressWarnings("rawtypes")
	public List searchUser(RegistrationBean login);
}
