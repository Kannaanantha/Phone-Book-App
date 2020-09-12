package com.ashokit.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.ContactDetailsEntity;
import com.ashokit.modal.Contact;
import com.ashokit.repository.ContactRepository;
import com.ashokit.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact c) {
		ContactDetailsEntity entity = new ContactDetailsEntity();
	    BeanUtils.copyProperties(c, entity);
	    ContactDetailsEntity saveEntity = contactRepository.save(entity);
		return saveEntity.getCid()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactById(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateContactDetails(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContatById(Integer cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
