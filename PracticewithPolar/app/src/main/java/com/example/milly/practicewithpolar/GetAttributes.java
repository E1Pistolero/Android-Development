package com.example.milly.practicewithpolar;

import java.util.HashMap;

/**
 * Created by Milly on 11/29/2015.
 *
 * UUID characteristics of Bluetooth device
 *
 * Characteristics
 * https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicsHome.aspx
 *
 * Services
 * https://developer.bluetooth.org/gatt/services/Pages/ServicesHome.aspx
 *
 */
public class GetAttributes {
    private static HashMap<String, String> attributes = new HashMap();
    public static String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static String HEART_RATE_SERVICE = "0000180f-0000-1000-8000-00805f9b34fb";

    static {

        //Services
        attributes.put("00001800-0000-1000-8000-00805f9b34fb", "Generic Access");
        attributes.put("00001801-0000-1000-8000-00805f9b34fb", "Generic Attribute");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information");
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate Service");
        attributes.put(HEART_RATE_SERVICE, "Battery Service");

       //Generic Access
        attributes.put("00002a00-0000-1000-8000-00805f9b34fb", "Device Name");
        attributes.put("00002a01-0000-1000-8000-00805f9b34fb", "Appearance");
        attributes.put("00002a03-0000-1000-8000-00805f9b34fb", "Link Loss");
        attributes.put("00002a04-0000-1000-8000-00805f9b34fb", "Tx Power");

        //Generic Attribute
        attributes.put("00002a05-0000-1000-8000-00805f9b34fb", "Service Changed");

        //Battery Service
        attributes.put("00002a19-0000-1000-8000-00805f9b34fb", "Battery Level");

        //Device Information
        attributes.put("00002a23-0000-1000-8000-00805f9b34fb", "System ID");
        attributes.put("00002a24-0000-1000-8000-00805f9b34fb", "Model Number String");
        attributes.put("00002a25-0000-1000-8000-00805f9b34fb", "Serial Number String");
        attributes.put("00002a26-0000-1000-8000-00805f9b34fb", "Firmware Revision String");
        attributes.put("00002a27-0000-1000-8000-00805f9b34fb", "Hardware Revision String");
        attributes.put("00002a28-0000-1000-8000-00805f9b34fb", "Software Revision String");
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");

        //Heart Rate Service Characteristics
        attributes.put(HEART_RATE_MEASUREMENT,                 "Heart Rate Measurement");
        attributes.put("00002a38-0000-1000-8000-00805f9b34fb", "Body Sensor Location");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}
