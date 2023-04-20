package com.sds.wedding.rest;

import com.sds.wedding.model.Contact;
import com.sds.wedding.payload.ContactRequest;
import com.sds.wedding.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    @Autowired
    private IContactService service;

    @PostMapping
    public ResponseEntity<ContactRequest> save(@RequestBody ContactRequest req) {
        service.save(req);
        return ResponseEntity.ok(req);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Contact>> findByName(@RequestParam(required = false) String name,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10")int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "address"));
        Page<Contact> contacts = service.findByName(name, pageable);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        List<Contact> contacts = service.findAll();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<String>> findAllAddress(@RequestParam(required = false) String query) {
        List<String> allAddress = service.findAllAddress(query);
        return ResponseEntity.ok(allAddress);
    }
}
