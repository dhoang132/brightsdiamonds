package com.brightsdiamonds.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brightsdiamonds.dao.UserDao;
import com.brightsdiamonds.domain.Diamond;
import com.brightsdiamonds.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Override
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}
	
	@Override
	public boolean create(User user) {
		System.out.println("creating user ");
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(user);
		
		//INSERT INTO `spring_db`.`user` (`id`, `email`, `first_name`, `last_name`, `dob`) VALUES ('4', 'dan@yahoo.com', 'kd', 'hi', '19990520');
		
		String sqlQuery = "INSERT INTO user (email, first_name, last_name, password) VALUES('" + user.getEmail() +"', '"
		+ user.getFirstName() + "', '" + user.getLastName() + "','" + BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()) + "');";
		
		
		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	@Override
	public List<User> getAllUsers() {
		String sqlQuery = "SELECT * FROM diamond";
		List<User> userList = namedParamJdbcTemplate.query(sqlQuery, new UserRowMapper());
		return userList;
	}

	@Override
	public User getUser(String email){
		
		try {
		SqlParameterSource Params = new MapSqlParameterSource("email", email);
		String sqlQuery = "SELECT id, email, first_name, last_name, password FROM user Where email ='" + email + "';";
		User user = namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new UserRowMapper());
		return user;
		}
		
		catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public String getUserPassword(String email) {
		SqlParameterSource Params = new MapSqlParameterSource("email", email);
		String sqlQuery = "SELECT id, email, first_name, last_name, password FROM user Where email ='" + email + "';";
		User user = namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new UserRowMapper());
		return user.getPassword();
	}

	@Override
	public boolean delete(User user) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(user);
		String sqlQuery = "DELETE FROM diamond WHERE id = :id";

		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	@Override
	public boolean update(User user) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(user);
		String sqlQuery = "UPDATE diamond SET employee_count = :employeeCount WHERE id = :id";

		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE user";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}
