package com.ashokit.service;

import java.util.List;

import com.ashokit.modal.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact dto);
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer cid);
	public boolean updateContactDetails(Contact contact);
	public boolean deleteContatById(Integer cid);
	

}
