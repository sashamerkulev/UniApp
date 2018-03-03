package ru.merkulyevsasha.uniapp.presentation.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sasha_merkulev on 03.03.2018.
 */

public class AccommodationItemUI implements Serializable{

    private int id;
    private String name;
    private String address;
    private String description;
    private String contact;
    private String phone;
    private int price;
    private List<String> images;

    public AccommodationItemUI(int id, String name, String address, String description, String contact, String phone, int price, List<String> images) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.contact = contact;
        this.phone = phone;
        this.price = price;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
