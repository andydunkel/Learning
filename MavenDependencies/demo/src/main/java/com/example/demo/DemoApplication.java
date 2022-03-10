package com.example.demo;

import com.da.logic.Comms;
import com.da.logic.VersionInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {


        SpringApplication.run(DemoApplication.class, args);

        var client = new Comms();
        try {
            client.createClient();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        var s = new VersionInfo().Version;
        System.out.println(s);

    }

}
