package com.hotchtechnology.loicImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotchtechnology.logic.PersonDao;
import com.hotchtechnology.model.PersonModel;

@Repository
@Transactional
public class PersonDaoImp implements PersonDao {

	@Autowired
	private JdbcTemplate JdbcTemplate;
	@Override
	public boolean personCreate(PersonModel personModel) {
	String sql="insert into personinformation(name,mobile,city,state,country)value(?,?,?,?,?)";
		return JdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, personModel.getName());
				ps.setString(2, personModel.getMobile());
				ps.setString(3, personModel.getCity());
				ps.setString(4, personModel.getState());
				ps.setString(5, personModel.getCountry());
			}
			
		})>0?true:false ;
	}

	@Override
	public boolean personUpdate(PersonModel personModel) {
		String sql="update personinformation set name=?,mobile=?,city=?,state=?,country=? where id=? ";
		return JdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, personModel.getName());
				ps.setString(2, personModel.getMobile());
				ps.setString(3, personModel.getCity());
				ps.setString(4, personModel.getState());
				ps.setString(5, personModel.getCountry());
				ps.setInt(6, personModel.getId());
			}
			
		})>0?true:false ;
	}

	@Override
	public boolean personEdit(PersonModel personModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean personDelete(int personId) {
		String sql="delete from personinformation where id="+personId;
		return JdbcTemplate.update(sql)>0?true:false;
	}

	@Override
	public List<PersonModel> getAllRecord() {
		String sql="select id,name,mobile,city,state,country from personinformation ";
		return JdbcTemplate.query(sql, new RowMapper<PersonModel>() {

			@Override
			public PersonModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new PersonModel(rs.getInt("id"), rs.getString("name"), rs.getString("mobile"), rs.getString("city"), rs.getString("state"), rs.getString("country"));
			}
			
		});
	}

}
