package hsenid;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by hsenid on 3/25/16.
 */
public class PropertyHandle {
    private String url;
    private String dbuser;
    private String password;

    public PropertyHandle() throws IOException {
        Properties configProp = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream("config.properties");
        configProp.load(in);

        this.url = configProp.getProperty("db.url");
        this.dbuser = configProp.getProperty("db.user");
        this.password = configProp.getProperty("db.password");
    }



    public String getUrl() {
        return url;
    }

    public String getDbuser() {
        return dbuser;
    }

    public String getPassword() {
        return password;
    }


 /*   public static void main(String[] args) throws IOException {
        PropertyHandle propertyHandle = new PropertyHandle();
        System.out.println(propertyHandle.getUrl());
        System.out.println(propertyHandle.dbuser);
        System.out.println(propertyHandle.getPassword());
    }*/
}

