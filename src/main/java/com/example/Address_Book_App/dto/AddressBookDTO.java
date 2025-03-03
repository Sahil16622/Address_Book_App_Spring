package com.example.Address_Book_App.dto;

public class AddressBookDTO {
    private Long id;
    private String name;

    public AddressBookDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}