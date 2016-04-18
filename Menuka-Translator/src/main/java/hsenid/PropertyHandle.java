package hsenid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHandle {
    private static final Logger logger = LogManager.getLogger(PropertyHandle.class);
    private String url;
    private String dbuser;
    private String password;
    private String dbDriver;
    private String yandexUrl;


    public PropertyHandle() throws IOException {
        Properties configProp = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream("config.properties");
        configProp.load(in);

        this.url = configProp.getProperty("db.url");
        this.dbuser = configProp.getProperty("db.user");
        this.password = configProp.getProperty("db.password");
        this.dbDriver = configProp.getProperty("db.driver");
        this.yandexUrl = configProp.getProperty("yandex.url");
        logger.info("Recieved the data from the config.properties");
    }

    public String getUrl() {
        logger.info("DB.URL returned");
        return url;
    }

    public String getDbuser() {
        logger.info("DB.User returned");
        return dbuser;
    }

    public String getPassword() {
        logger.info("DB.Password returned");
        return password;
    }

    public String getDbDriver(){
        logger.info("DB.Driver returned");
        return dbDriver;
    }

    public String getYandexUrl() {
        logger.info("Yandex.Language list called");
        return yandexUrl;
    }
}

