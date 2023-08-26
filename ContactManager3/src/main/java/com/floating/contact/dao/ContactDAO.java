package com.floating.contact.dao;
import java.util.*;
import com.floating.contact.model.Contact;

public interface ContactDAO {

	public int save (Contact conatct);
	
	public int update(Contact contact);
	
	public Contact get(Integer id);
	
	public int delete(Integer id);
	
	public List<Contact> list();

	List<Contact> searchByName(String name);
	
}
