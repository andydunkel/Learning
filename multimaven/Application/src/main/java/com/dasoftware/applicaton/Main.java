package com.dasoftware.applicaton;

import com.dasoftware.communication.Comms;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {
        var comms = new Comms();
        try {
            var facts = comms.getCatFacts();
            System.out.println(facts);

//            var path = ProgDirUtil.getProgramDirectory();
            var path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            System.out.println(path);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }
}