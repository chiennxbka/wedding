package com.sds.wedding.dao;

import com.sds.wedding.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Page<Contact> findContactByName(String name, Pageable pageable);


    @Query("select distinct c.address from Contact c where c.address like :query%")
    List<String> findDistinctAddress(@Param("query") String query);
}
