package com.linmilin.ip;

import dk.appdictive.adbwificonnect.Device;

import java.io.*;
import java.util.Base64;

import static java.util.Base64.getEncoder;

public class Utils {

    public static String serializeArray(Device[] array) {
        // serialize
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(out).writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // your string
        String serializedArray = new String(getEncoder().encode(out.toByteArray()));
        return serializedArray;
    }

    public static Device[] deserializeArray(String serializedArray) {
        // deserialize
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(serializedArray.getBytes()));
            return (Device[]) new ObjectInputStream(in).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
        return null;
    }
}
