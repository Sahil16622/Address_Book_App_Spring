package com.example.Address_Book_App.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @PostMapping("/add")
    public ResponseEntity<AddressBookDTO> addEntry(@RequestParam String name) {
        return ResponseEntity.ok(service.addEntry(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBookDTO>> getAllEntries() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getEntryById(@PathVariable Long id) {
        AddressBookDTO entry = service.getEntryById(id);
        return (entry != null) ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }
}