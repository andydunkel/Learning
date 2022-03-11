package com.dasoftware.applicaton;

import com.dasoftware.communication.Comms;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {
        var comms = new Comms();
        try {
            var facts = comms.getCatFacts();
            System.out.println(facts);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }


    }
}