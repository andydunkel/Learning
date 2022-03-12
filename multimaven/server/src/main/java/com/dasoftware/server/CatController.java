package com.dasoftware.server;

import com.dasoftware.communication.CatFact;
import com.dasoftware.communication.Comms;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path="api/v1/catfacts")
public class CatController {

    @GetMapping
    public CatFact getStudent() {
        var comm = new Comms();
        try {
            var fact = comm.getCatFacts();
            return fact;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return null;
    }
}
