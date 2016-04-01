package Testers;

import hsenid.StrChng;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StrChngTest {

    @Test
    public void testModifiedStr() throws Exception {
        StrChng test = new StrChng();

        String received = test.modifiedUrl("I eat rice", "english", "japanese" );
//        System.out.println(received);
        Assert.assertEquals("https://translate.yandex.net/api/v1.5/tr/translate?key=trnsl.1.1.20160314T043532Z.7b2cd69323fcafb3.0e2a38f131f947f39dce80a89756c4d03ed5da6a&text=I%20eat%20rice&lang=english-japanese", received);
    }
}