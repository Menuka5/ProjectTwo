package hsenid;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

}

