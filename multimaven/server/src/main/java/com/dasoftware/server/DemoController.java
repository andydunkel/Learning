package com.dasoftware.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/demo")
public class DemoController {


    @GetMapping
    public DemoData getStudent() {
        var data = new DemoData();
        data.setId("1");
        data.setName("Hello Word");

        return data;
    }
}
