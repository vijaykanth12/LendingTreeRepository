package com.lendingtree.service;


import java.util.List;




import javax.ejb.Local;

import com.lendingtree.model.Bank;
@Local
public interface BankService {
	public void addbank(Bank bank);
	public List<Bank> getBanks();
	public List<Bank> getBankId(int id);
	public void editBank(Bank bank);
	public void deleteBank(String id);
	
	public List<Bank> listBanks();
	
}
