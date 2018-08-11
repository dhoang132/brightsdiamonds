package com.brightsdiamonds.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brightsdiamonds.domain.Diamond;
import com.brightsdiamonds.domain.User;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rownum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setPassword(rs.getString("password"));
		return user;
	}
}
