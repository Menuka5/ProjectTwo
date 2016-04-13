package Testers;

import hsenid.StringChange;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringChangeTest {

    StringChange test = new StringChange();
    String inp = "https://translate.yandex.net/api/v1.5/tr/translate?key=trnsl.1.1.20160314T043532Z.7b2cd69323fcafb3.0e2a38f131f947f39dce80a89756c4d03ed5da6a&text=I%20eat%20rice&lang=english-japanese";

    @DataProvider(name = "Name")
    public static Object[][] Name() {
        return new Object[][]{
                {"I eat rice", "", "japanese"},
                {"I eat rice", "english", ""},
                {"", "english", "japanese"},
                {"I gels you", "from", "to"},
                {"fsdf3wfwfsd", "english", "japanses"}

        };

    }

    @Test
    public void testModifiedStr() throws Exception {


        String received = test.modifiedUrl("I eat rice", "english", "japanese");
//        System.out.println(received);
        Assert.assertEquals(inp, received);
    }

    @Test(dataProvider = "Name")
    public void testName(String word, String from, String to) throws Exception {
        String recFalse = test.modifiedUrl(word, from, to);
        boolean chckVal = recFalse.equals(inp);
        Assert.assertFalse(chckVal);
    }
}