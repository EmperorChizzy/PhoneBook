package org.example;

import org.example.service.PhoneService;
import org.example.entities.Contact;
import org.example.serviceImpl.PhoneServiceImpl;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    //Storage for the contacts should be in a list
    public static List<Contact> phoneBook = new ArrayList<>();
    public static HashMap<String, List<Integer>> searchByName = new HashMap<>();
    public static HashMap<Long, Integer> searchByNumber = new HashMap<>();
    public static void main(String[] args) {
        Contact daro = new Contact();
        daro.setAddress("Lokoja");
        daro.setEmail("daro@gmail.com");
        daro.setName("Daro Gadibia");
        daro.setPhoneNumber(9346343546L);
        Contact daro1 = new Contact();
        daro1.setAddress("ABJ");
        daro1.setEmail("ro@gmail.com");
        daro1.setName("Daro Gadibia");
        daro1.setPhoneNumber(93463435465L);
        Contact desmond = new Contact();
        desmond.setName("Desmond");
        desmond.setEmail("dizzy@gmail.com");
        desmond.setAddress("AJ");
        desmond.setPhoneNumber(98434678546L);
        PhoneService service = new PhoneServiceImpl();
        service.addContact(desmond);
        service.addContact(daro1);
        service.addContact(daro);
        System.out.println(service.searchByName("Daro Gadibia"));
        System.out.println(service.searchByNumber(9346343546L));
    }
}