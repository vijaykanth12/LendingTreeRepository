package com.lendingtree.service;

import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lendingtree.dao.BankDao;
import com.lendingtree.model.Bank;
//@Service("BankService")
@Stateless
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class BankServiceImpl implements BankService {
	@Autowired
	 private BankDao bDao;

@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void addbank(Bank bank) {
		// TODO Auto-generated method stub
		bDao.addbank(bank);
	}

@Override
public List<Bank> getBanks() {
	// TODO Auto-generated method stub
	return bDao.getBanks();
}

@Override
public List<Bank> getBankId(int id) {
	// TODO Auto-generated method stub
	return bDao.getBankId(id);
}

@Override
public void editBank(Bank bank) {
	// TODO Auto-generated method stub
	bDao.editBank(bank);
}

@Override
public void deleteBank(String id) {
	// TODO Auto-generated method stub
	bDao.deleteBank(id);
}

@Override
public List<Bank> listBanks() {
	// TODO Auto-generated method stub
	return bDao.listBanks();
}

	

}
