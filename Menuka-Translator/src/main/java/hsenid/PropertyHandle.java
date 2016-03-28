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
        InputStream in = this.getClass().getResourceAsStream("/configs/config.config.properties");
        configProp.load(in);

        this.url = configProp.getProperty("db.user");
        this.dbuser = configProp.getProperty("db.password");
        this.password = configProp.getProperty("db.url");
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
}

