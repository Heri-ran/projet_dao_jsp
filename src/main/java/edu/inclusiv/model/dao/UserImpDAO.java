package edu.inclusiv.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.inclusiv.model.bean.User;

public class UserImpDAO implements IDaoCRUD<User> {
	
	private DaoFactory daoFactoryProvider;
	
	public UserImpDAO(DaoFactory daoFactory){
		this.daoFactoryProvider = daoFactory;
	}

	@Override
	public User save(User entity) {
		try {
			PreparedStatement preparedStatement = 
					this.daoFactoryProvider.getConnection().prepareStatement("Insert into User(nom, prenom, password) values (?, ?, ?)");
			preparedStatement.setString(1, entity.getNom());
			preparedStatement.setString(2, entity.getPrenom());
			preparedStatement.setString(3, entity.getPassword());
			if(preparedStatement.execute())
				return entity;
			
			preparedStatement.close();
		}catch (NullPointerException e) {
			System.out.println("NullPointerException :: save :: UserImpDAO");
			if(this.daoFactoryProvider != null) {
				System.out.println("daoFactoryProvider Not Null");
				return null;
			}else {
				this.daoFactoryProvider = DaoFactory.getInstance();
				this.save(entity);
			}
		}catch(SQLException e) {
			System.out.println("SQLException :: save :: UserImplDAO");
			System.out.println(e.getCause());
		}catch(Exception e) {
			System.out.println("Exception :: save :: UserImplDAO");
			System.out.println(e.getCause());
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> liste = new ArrayList<>();
		
		try {
			ResultSet resultSet = this.daoFactoryProvider.getConnection().createStatement().executeQuery("select * from User");
			while(resultSet.next()) {
				User u = new User(resultSet.getInt("idUser"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("password"));
				liste.add(u);
			}
			resultSet.close();
			return liste;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User remove(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
