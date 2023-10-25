package org.example.serviceImpl;

import org.example.Main;
import org.example.service.PhoneService;
import org.example.entities.Contact;

import java.util.*;

public class PhoneServiceImpl implements PhoneService {
    @Override
    public Contact addContact(Contact contact) {
        Main.phoneBook.add(contact);
        Integer location = Main.phoneBook.indexOf(contact);
        if (Main.searchByName.get(contact.getName())==null&&Main.searchByNumber.get(contact.getPhoneNumber())==null){
            List<Integer> contactLocations = new ArrayList<>();
            contactLocations.add(location);
            Main.searchByName.put(contact.getName(), contactLocations);
            Main.searchByNumber.put(contact.getPhoneNumber(), location);
        }
        else {
            Main.searchByName.get(contact.getName()).add(location);
            Main.searchByNumber.put(contact.getPhoneNumber(), location);
        }

        return contact;
    }

    @Override
    public List<Contact> searchByName(String name) {
        List<Integer> location = Main.searchByName.get(name);
        List<Contact> similarNameContact = new ArrayList<>();
        location.forEach(indexLocation -> {
            similarNameContact.add(Main.phoneBook.get(indexLocation));
        });
        return similarNameContact;
    }

    @Override
    public Contact searchByNumber(Long phoneNumber) {
        Integer  location = Main.searchByNumber.get(phoneNumber);
        return Main.phoneBook.get(location);
    }
}