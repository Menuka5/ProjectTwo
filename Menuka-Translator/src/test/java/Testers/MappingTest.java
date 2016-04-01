package Testers;

import hsenid.Mapping;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by hsenid on 4/1/16.
 */
public class MappingTest {
    String[] data;

    @BeforeTest
    public void setUp() throws Exception {
        data = new String[]{"Tatar", "German", "Hindi", "Portuguese", "Lithuanian", "Croatian", "Latvian", "Haitian", "Hungarian", "Armenian", "Ukrainian", "Malagasy", "Indonesian", "Urdu", "Macedonian", "Mongolian", "Afrikaans", "Uzbek", "Malay", "Greek", "Maltese", "English", "Icelandic", "Italian", "Spanish", "Chinese", "Estonian", "Basque", "Arabic", "Vietnamese", "Japanese", "Azerbaijani", "Persian", "Romanian", "Dutch", "Bashkir", "Norwegian", "Belarusian", "Finnish", "Russian", "Bulgarian", "French", "Bosnian", "Georgian", "Slovak", "Slovenian", "Irish", "Catalan", "Albanian", "Serbian", "Kazakh", "Swedish", "Korean", "Swahili", "Galician", "Kirghiz", "Czech", "Tajik", "Thai", "Latin", "Welsh", "Tagalog", "Polish", "Danish", "Hebrew", "Turkish"};
    }


    @Test
    public void testSendValues() throws Exception {
        Mapping mapData = new Mapping();
        Assert.assertEquals(mapData.sendValues(), data);
    }


}