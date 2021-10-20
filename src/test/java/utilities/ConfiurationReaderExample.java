package utilities;

import com.github.javafaker.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfiurationReaderExample {


    // Properties objesi olustur

    static Properties properties = new Properties();


    // Static block icerisinde configuration.properties path'ini bir container'a ata.
    // FileInputStream class'indan bir obje olustur ve parametresi icine part'i yaz.
    // Class level'da olusturdumuz properties objesinin uzerinde load() method'unu cagir ve parametre olarak fileInputStream objesini gir.


    static {

        String filePath = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Diger class'lardan class adi ile cagirabilmek icin static olarak getProperty() adinda bir method olustur.
    // Method parametre olarak configuration.properties sayfasinda olusturdumuz key degerlerini alsin.
    // Value adinda bir container olustur ve properties objesi uzerinden getProperty() methodu ile ilgili key'in degerini getirerek bu container'a ata.
    // Son olarak value variable'ini return et.

    public static String getProperty (String key) {

        String value = properties.getProperty(key);

        return value;
    }
}
