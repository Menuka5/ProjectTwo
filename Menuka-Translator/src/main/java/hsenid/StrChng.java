package hsenid;

/**
 * Created by Menuka Ishan on 3/21/16.
 */
public class StrChng {
    /**
     * This class replace the spaces of given string with %20 (space character in html)
     *
     * @param x This is the original string from translate.jsp which we want to translate
     * @return It return the modified string.
     */
    public String modifiedStr(String x) {

        StringBuilder test = new StringBuilder();

        String[] array = x.split("\\s+", -1);

        String modify = "";

        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                test.append("%20");
            }
            test.append(array[i]);
        }
        return test.toString();

    }

    public String modifiedUrl(String fromText, String from, String to) {
        String urlWithKey = "https://translate.yandex.net/api/v1.5/tr/translate?key=trnsl.1.1.20160314T043532Z.7b2cd69323fcafb3.0e2a38f131f947f39dce80a89756c4d03ed5da6a";
        StringBuilder apiCall = new StringBuilder();

        apiCall.append(urlWithKey);
        apiCall.append("&text=");
        apiCall.append(this.modifiedStr(fromText));
        apiCall.append("&lang=");
        apiCall.append(from);
        apiCall.append("-");
        apiCall.append(to);
        return apiCall.toString();
    }

}
