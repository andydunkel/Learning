package com.dasoftware.server;

import com.dasoftware.communication.ProgDirUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        var progDir = ProgDirUtil.getProgramDirectory();

        SpringApplication.run(ServerApplication.class, args);
    }

}
