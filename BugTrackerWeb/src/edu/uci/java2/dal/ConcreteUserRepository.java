package edu.uci.java2.dal;


import java.sql.SQLException;
import java.util.List;


import javax.naming.NamingException;

import edu.uci.java2.domain.User;
import edu.uci.java2.domain.UserRepository;

class ConcreteUserRepository implements UserRepository {

	
	private DataProvider<User> dataProvider;
	
	ConcreteUserRepository(){
		dataProvider =  new DataProvider<User>(User.class);
	}
	
	@Override
	public User getUserByUserName(String userName) throws DalException {
		try {
			return dataProvider.get("username", userName);
		} catch (ClassNotFoundException e) {
			throw new DalException(e);
		}
	}

	@Override
	public User getUSerByUserID(int ID) throws DalException {
		try {
			return dataProvider.get(ID);
		} catch (NamingException | ClassNotFoundException e) {
			throw new DalException(e);
		}
	}

	@Override
	public User SaveUser(User user) throws DalException{
		try {
			return dataProvider.save(user);
		} catch (NamingException | SQLException | ClassNotFoundException e) {
			throw new DalException(e);
		}
	}

	@Override
	public List<User> getAllUsers() throws DalException {
		try {
			return dataProvider.getAll();
		} catch (ClassNotFoundException e) {
			throw new DalException(e);
		}
	}

}
