package Constant;


import model.Accessory;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Onyebuchi Iheuwadinachi Eleazu
 */

public class Constant {
    public static List<Accessory> accessories = new ArrayList<>();

    static {


        accessories.add(new Accessory(0, "Charger", 10, 25, "Phone", "Charger Description", "user1"));
        accessories.add(new Accessory(1, "Battery", 10, 40, "Phone", "Battery Description", "user2"));
        accessories.add(new Accessory(2, "Cases", 30, 10, "Phone", "Case Description", "user1"));
        accessories.add(new Accessory(3, "Memory Card", 40, 15, "Phone", "Memory Card Description", "user2"));
        accessories.add(new Accessory(4, "Cable Adapter", 50, 10, "IPad", "Cable Adapter Description", "user1"));
        accessories.add(new Accessory(5, "Wireless Charger", 50, 9, "Phone", "Charger Description", "user2"));
        accessories.add(new Accessory(6, "Bluetooth Headset", 50, 35, "IPad", "Bluetooth Headset Description", "user1"));
        accessories.add(new Accessory(7, "Power Bank", 50, 25, "Tablet", "Power Bank Description", "user2"));
        accessories.add(new Accessory(8,"Bluetooth Speaker",5, 55, "Speaker","Bluetooth Speaker","user1"));
        accessories.add(new Accessory(9,"Smart Watch", 6, 100, "Watch", "Bluetooth Watch", "user1"));
        accessories.add(new Accessory(10, "Car Charger",8, 55, "Phone", "Car Charger Description", "user1"));
        accessories.add(new Accessory(11, "Bike Phone Holder", 6, 37, "Phone", "Bike Phone Holder description","user2"));
    }

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user1", "password1", "USER"));
        users.add(new User("user2", "password2", "USER"));
        users.add(new User("admin", "adminPassword1", "ADMIN"));
    }

}
