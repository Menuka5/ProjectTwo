package hsenid;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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
import java.io.PrintWriter;

/**
 *
 */
public class GetTranslate extends HttpServlet {
    /**
     *
     * @param request
     * This is HttpServletRequest instance which we create to transport data to the servlet.
     * @param resp
     * This is HttpServletResponse instance which we use to make the modifications like setting Unicode data transferring,
     * content type setting etc.
     * @throws ServletException
     * @throws IOException
     * @throws IllegalArgumentException
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException, IllegalArgumentException {
        /**
         * Here we over ride the doGet method of
         */
        resp.setContentType("text/html"); //  setting the printwriter to html outputs
        request.setCharacterEncoding("UTF-8"); // Setting unicode as encoding for use languages like japanese
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        //Getting relevant parameters from translate.jsp

        String fromText = request.getParameter("fromText");
        String from = request.getParameter("from");
        String to = request.getParameter("to");

//      formatting the the text which want to translated to api friendly format (replacing spaces with %20)
        StrChng chngst = new StrChng();
        String Modified = chngst.modifiedStr(fromText);


        String urlWithKey = "https://translate.yandex.net/api/v1.5/tr/translate?key=trnsl.1.1.20160314T043532Z.7b2cd69323fcafb3.0e2a38f131f947f39dce80a89756c4d03ed5da6a";
        String url = urlWithKey + "&text=" + Modified + "&lang=" + from + "-" + to; // building the url

        // HttpClient call preparing
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);

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

                Mapping vlues = new Mapping();
                String[] cName = vlues.sendMap(from, to);
                request.setAttribute("fromLan", cName[0]);
                request.setAttribute("toLan", cName[1]);
                request.setAttribute("data", vlues.GetData());

                request.getRequestDispatcher("/translate.jsp").forward(request, resp);


            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }

        }
    }
}
