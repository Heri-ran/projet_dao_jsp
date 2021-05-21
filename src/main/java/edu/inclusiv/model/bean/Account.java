package edu.inclusiv.model.bean;

public class Account {

	private int ref_account;
	private String account_name;
	
	public Account() {
		
	}
	
	public Account(int ref_account, String account_name) {
		this.ref_account = ref_account;
		this.account_name = account_name;
	}

	public int getRef_account() {
		return ref_account;
	}

	public void setRef_account(int ref_account) {
		this.ref_account = ref_account;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

}
