package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReaderHelper {
    public static Properties prop;

    public FileReaderHelper() {
        try {
            prop = new Properties();
            String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String LoadUrl(){
        String url=prop.getProperty("url");
        return  url;
    }
    public String LaunchGoogle(){
        String google=prop.getProperty("google");
        return google;

    }

    }
