package com.example.Address_Book_App.controller;





import com.example.Address_Book_App.dto.AddressBookDTO;
import com.example.Address_Book_App.service.AddressBookService;
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
    public ResponseEntity<AddressBookDTO> addEntry(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok(service.addEntry(addressBookDTO.getName()));
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

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateEntry(@PathVariable Long id, @RequestParam String name) {
        AddressBookDTO updatedEntry = service.updateEntry(id, name);
        return (updatedEntry != null) ? ResponseEntity.ok(updatedEntry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        return service.deleteEntry(id) ? ResponseEntity.ok("Entry Deleted!") : ResponseEntity.notFound().build();
    }
}
