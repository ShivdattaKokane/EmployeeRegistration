
package com.floating.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.floating.contact.model.Contact;

class ContactDAOTest {

	
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void beforEach()
	{
		dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
//		
		dao=new ContactDAOImpl(dataSource);
	}
	
	
	@Test
	void testSave() {
		
		
		Contact contact=new Contact("sayali", "sayali123@gmail.com", "latur", "7458963210");
		int result=dao.save(contact);
		//assertEquals(1, result);
		
	}

	@Test
	void testUpdate() {
		
		Contact contact=new Contact(2,"Shivdatta kokane", "shivdattakokane987.com", "Pune", "9874563210");
		int result=dao.update(contact);
	}

	@Test
	void testGet() {
		
		Integer id=1;
		Contact contact=dao.get(id);
		if(contact!=null)
		{
			System.out.println(contact);
		}
		 assertNotNull(contact);
	}

	@Test
	void testDelete() {
		
		Integer id=5;
		int result=dao.delete(id);
		}

	@Test
	void testList() {
		
		List<Contact>listcontact=dao.list();
		for(Contact c:listcontact)
		{
			System.out.println(c);
		}
		
	}

}
