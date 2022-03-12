package com.dasoftware.communication;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {
        var comms = new Comms();
        try {
            var fact = comms.getCatFacts();
            System.out.println(fact);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
