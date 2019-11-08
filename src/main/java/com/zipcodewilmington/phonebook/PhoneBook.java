package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        if (map.containsKey(name)) {
            map.get(name).add(phoneNumber);
        } else {
            map.put(name, Arrays.asList(phoneNumber));
        }
    }

    public void addAll(String name, String... phoneNumbers) {

        map.put(name, Arrays.asList(phoneNumbers));
    }
//complete has entry
    public void remove(String name) {
        map.remove(name);

    }

    public Boolean hasEntry(String name) {

       return reverseLookup(name) != null || map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for(String each: map.keySet()){
            if(map.get(each).contains(phoneNumber)){
                return each;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {

        List<String> nameList = new ArrayList<>();
        Set<String> nameSet = map.keySet();
        nameList.addAll(nameSet);

        return nameList;
    }
    public Map<String, List<String>> getMap() {
        return map;
    }
}



