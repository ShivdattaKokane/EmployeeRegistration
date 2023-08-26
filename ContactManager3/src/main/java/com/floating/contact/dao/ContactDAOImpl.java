package com.floating.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.floating.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	
	private JdbcTemplate jdbcTemplate ;
	
	public ContactDAOImpl(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int save(Contact c) {
		 String sql = "Insert into contact(name,email,address,phone) value (?,?,?,?)";
		 jdbcTemplate.update(sql, c.getName(),c.getEmail(),c.getAddress(),c.getPhone());
		return 0;
	}

	@Override
	public int update(Contact c) {
		 String sql = "UPDATE contact SET name=?,email=?,address=?,phone=? WHERE contact_id=? ";
		 
		return jdbcTemplate.update(sql,c.getName(),c.getEmail(),c.getAddress(),c.getPhone(),c.getId()) ;
	}

	@Override
	public Contact get(Integer id) {
		 String sql = " Select * from contact Where contact_id= "+id ;
		 ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				 if(rs.next())
				 {   Integer id =rs.getInt("contact_id");
					 String name = rs.getString("name");
					 String email = rs.getString("email");
					 String address = rs.getString("address");
					 String phone = rs.getString("phone");
					 return new Contact(id,name, email, address, phone);
				 }
				return null;
			}
		};
		 
		return  jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		 String sql = "DELETE FROM contact WHERE contact_id="+id;
		 
		return  jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		 String sql = " Select * from contact";
		 
		 RowMapper<Contact> rowMapper = new RowMapper<Contact>()
				 {

					@Override
					public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
						 
						Integer id = rs.getInt("contact_id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						String Address = rs.getString("address");
						String phone = rs.getString("phone");
						return  new Contact(id,name,email,Address,phone);
					}
			 
				 };
		 
		return  jdbcTemplate.query(sql, rowMapper);
	}


	@Override
	public List<Contact> searchByName(String name) {
	    String sql = "SELECT * FROM contact WHERE name LIKE ?";
	    
	    // RowMapper to map result set rows to Contact objects
	    RowMapper<Contact> rowMapper = new RowMapper<Contact>() {
	        @Override
	        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Integer id = rs.getInt("contact_id");
	            String contactName = rs.getString("name");
	            String email = rs.getString("email");
	            String address = rs.getString("address");
	            String phone = rs.getString("phone");
	            return new Contact(id, contactName, email, address, phone);
	        }
	    };
	    
	    // Perform the query and return the list of contacts
	    return jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, rowMapper);
	}
	

}
