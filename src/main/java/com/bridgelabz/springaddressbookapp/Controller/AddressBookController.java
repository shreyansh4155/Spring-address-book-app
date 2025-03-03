package com.bridgelabz.springaddressbookapp.Controller;

import com.bridgelabz.springaddressbookapp.dto.AddressBookDTO;
import com.bridgelabz.springaddressbookapp.model.AddressBook;
import com.bridgelabz.springaddressbookapp.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookService service;

    @Autowired
    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBook> addEntry(@Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.addEntry(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateEntry(@PathVariable Long id, @Valid @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.updateEntry(id, dto));
    }
}