package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_DriverClass {


    @Test
    public void test () {
        Driver.getDriver().get(ConfigurationReader.getProperty("AmazonUrl"));
        Driver.getDriver().get(ConfigurationReader.getProperty("CHUrl"));
        Driver.getDriver().get(ConfigurationReader.getProperty("FacebookUrl"));

        Driver.closeDriver();

        // Driver driver = new Driver();
        // Driver class'indan obje uretilmemesini istedigimiz icin driver class'i singleton yapiyoruz.
        // Bunun icin default constructor yerine parametresiz bir constructor olusturup access modifier'i private seciyoruz.

    }
}
