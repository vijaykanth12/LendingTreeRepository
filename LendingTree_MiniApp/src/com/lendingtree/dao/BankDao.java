package com.lendingtree.dao;

import java.util.List;

import com.lendingtree.bean.BankBean;
import com.lendingtree.model.ApplyLoan;
import com.lendingtree.model.Bank;

@SuppressWarnings("unused")
public interface BankDao  {
	public void addbank(Bank bank);
	public List<Bank> getBanks();
	public List<Bank> getBankId(int id);
	public void editBank(Bank bank);
	public void deleteBank(String id);
	
	public List<Bank> listBanks();
	

}
