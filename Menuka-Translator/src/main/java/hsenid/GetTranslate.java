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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class GetTranslate extends HttpServlet {
    private final static Logger logger = LogManager.getLogger(GetTranslate.class);

    /**
     * @param request This is HttpServletRequest instance which we create to transport data to the servlet.
     * @param resp    This is HttpServletResponse instance which we use to make the modifications like setting Unicode data transferring,
     *                content type setting etc.
     * @throws ServletException
     * @throws IOException
     * @throws IllegalArgumentException
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        /**
         * Here we over ride the doGet method of
         */

        resp.setContentType("text/html"); //  setting the printwriter to html outputs
        request.setCharacterEncoding("UTF-8"); // Setting unicode as encoding for use languages like japanese
        resp.setCharacterEncoding("UTF-8");

        //Getting relevant parameters from translate.jsp

        String fromText = request.getParameter("fromText");
        String from = request.getParameter("from");
        String to = request.getParameter("to");

//      formatting the the text which want to translated to api friendly format (replacing spaces with %20)
        StringChange chngst = new StringChange();

        String urlModified = chngst.modifiedUrl(fromText, from, to);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(urlModified);
            response = client.execute(httpGet);
        } catch (IOException e) {
            logger.error("GetTranslate IOException HTTPClient" + e);

        }


        int statusCode = response.getStatusLine().getStatusCode();

        Document doc = null;

        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Using DOM to manipulating xml to get the information

            try {

                DocumentBuilder builder = factory.newDocumentBuilder();
                doc = builder.parse(entity.getContent());
                NodeList text = doc.getElementsByTagName("text");
                String toText = text.item(0).getTextContent();

//                Setting attributes to send to tranlate.jsp
                request.setAttribute("from", from);
                request.setAttribute("to", to);
                request.setAttribute("fromText", fromText);
                request.setAttribute("toText", toText);

//                Manupulation getLang.xml reply to create dynamic select list

                request.getRequestDispatcher("/translate.jsp").forward(request, resp);


            } catch (ParserConfigurationException e) {
                logger.error(e.getMessage());
            } catch (SAXException e) {
                logger.error(e.getMessage());
            } catch (ServletException e) {
                logger.error(e.getMessage());
                throw new ServletException();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }

        }
    }
}
