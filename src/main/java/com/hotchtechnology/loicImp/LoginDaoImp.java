package com.hotchtechnology.loicImp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotchtechnology.logic.LoginDao;
import com.hotchtechnology.model.UserModel;


@Repository
@Transactional
 public class LoginDaoImp implements LoginDao  {

	@Autowired
private	JdbcTemplate jdbdcTemplate;

	@Override
	public boolean checkvaliduser(UserModel model) {
		
		String query="select * from login where username='"+model.getUserName().trim()+"'and password='"+model.getPassword().trim()+"'";
		return jdbdcTemplate.query(query, new ResultSetExtractor<Boolean>() {

			@Override
			public 
Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
			  if(rs.next()) {
				  return true;
			  }
				return false;
			}
			
		});
	}
	
	
}
