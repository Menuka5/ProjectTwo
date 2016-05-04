package hsenid;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class Mapping {
    private static final Logger logger = LogManager.getLogger(Mapping.class);
    /**
     * Main task of this class is the handle getLang.xml reply which is given by the yandex.
     */
    String inpFrom, inpTo;
    HashMap<String, String> data = new HashMap<String, String>();

    public Mapping() throws IOException, ParserConfigurationException, SAXException {
        PropertyHandle mapDataget = new PropertyHandle();
        String url = mapDataget.getYandexUrl();


        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);

        int statusCode = response.getStatusLine().getStatusCode();
        Document doc;

        if (statusCode == 200) {
            logger.info("Language list recieved, manupulation started!");
            HttpEntity entity = response.getEntity();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(entity.getContent());
            NodeList nodeList = doc.getElementsByTagName("Item");

            for (int x = 0; x < nodeList.getLength(); x++) {

                String key = nodeList.item(x).getAttributes().getNamedItem("key").getNodeValue();
                String value = nodeList.item(x).getAttributes().getNamedItem("value").getNodeValue();
                data.put(key, value);

            }

        } else {
            logger.error("Http Connection error, Mapping.java");
        }
    }

    public String[] sendValues() {
        logger.info("Value sending started. Mapping.java");

        String[] arr = new String[data.size()];
        int i = 0;
        for (String key : data.values()) {
            arr[i] = key;
            i++;
        }
        return arr;

    }

}