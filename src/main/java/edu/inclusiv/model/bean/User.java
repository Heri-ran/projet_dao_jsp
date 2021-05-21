package edu.inclusiv.model.bean;

public class User {

	private int idUser;
	private String nom;
	private String prenom;
	private String password;
	
	public User() {
		
	}

	public User(int idUser, String nom, String prenom, String password) {
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
