package com.dasoftware;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        var path = Paths.get(getApplicationPath(), "config.properties");

        var props = new Properties();
        try {
            props.load(new FileInputStream(path.toFile()));
            var config1 = props.getProperty("config");
            var config2 = props.getProperty("config.german");

            System.out.println(config1);
            System.out.println(config2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApplicationPath() {
        String path = null;
        try {
            path = new File(".").getCanonicalPath();
        } catch (IOException e) {
            return null;
        }
        return path;
    }
}
