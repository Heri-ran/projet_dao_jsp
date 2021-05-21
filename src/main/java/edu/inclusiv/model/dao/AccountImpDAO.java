package edu.inclusiv.model.dao;

import java.util.List;

import edu.inclusiv.model.bean.Account;

public class AccountImpDAO implements IDaoCRUD<Account> {

	private DaoFactory daoFactoryProvider;
	
	public AccountImpDAO(DaoFactory daoFactory) {
		this.daoFactoryProvider = daoFactory;
	}

	@Override
	public Account save(Account entity) {
		
		return null;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account remove(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account update(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
