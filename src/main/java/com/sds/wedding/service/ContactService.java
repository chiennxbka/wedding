package com.sds.wedding.service;

import com.sds.wedding.dao.ContactRepository;
import com.sds.wedding.model.Contact;
import com.sds.wedding.payload.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {

    // commit demo

    @Autowired
    private ContactRepository repository;

    @Override
    public void save(ContactRequest req) {
        Contact entity = new Contact(req.getName(), req.getAmount(), req.getAddress());
        repository.save(entity);
    }

    @Override
    public Page<Contact> findByName(String name, Pageable pageable) {
        return repository.findContactByName(name, pageable);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Override
    public List<String> findAllAddress(String query) {
        return repository.findDistinctAddress(query);
    }
}
