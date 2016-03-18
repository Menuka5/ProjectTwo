package hsenid;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.PrintWriter;

public class GetTranslate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException, IllegalArgumentException {
        resp.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        String fromText = request.getParameter("fromText");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String lineWithoutSpaces = fromText.replaceAll("\\s+","");
        String urlWithKey = "https://translate.yandex.net/api/v1.5/tr/translate?key=trnsl.1.1.20160314T043532Z.7b2cd69323fcafb3.0e2a38f131f947f39dce80a89756c4d03ed5da6a";
        String url = urlWithKey + "&text=" + lineWithoutSpaces + "&lang=" + from + "-" + to;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);

        int statusCode = response.getStatusLine().getStatusCode();
        // out.print(from);https://www.yandex.com/

        // out.println(url);

        Document doc = null;

        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            try {

                DocumentBuilder builder = factory.newDocumentBuilder();
                doc = builder.parse(entity.getContent());
                NodeList text = doc.getElementsByTagName("text");
                String toText = text.item(0).getTextContent();
                
                // out.println(text.item(0).getTextContent());
                request.setAttribute("from", from);
                request.setAttribute("to", to);
                request.setAttribute("fromText", fromText);
                request.setAttribute("toText", toText);

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
