package com.sds.wedding.service;

import com.sds.wedding.model.Contact;
import com.sds.wedding.payload.ContactRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContactService {

    void save(ContactRequest req);

    Page<Contact> findByName(String name, Pageable pageable);

    List<Contact> findAll();
}
