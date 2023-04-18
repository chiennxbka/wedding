package com.sds.wedding.dao;

import com.sds.wedding.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Page<Contact> findContactByName(String name, Pageable pageable);
}
