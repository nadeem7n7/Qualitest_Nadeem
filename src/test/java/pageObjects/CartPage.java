package pageObjects;

import io.cucumber.java.eo.Do;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class CartPage {

    private ChromeDriver driver;

    public CartPage(ChromeDriver driver) {

        this.driver = driver;
    }

    public void checkCart(int num) {
        List<WebElement> Elements = driver.findElements(By.xpath("//*[starts-with(@class,'shop_table shop_table_responsive cart')]/child::tbody/tr"));
        Assert.assertEquals(num + 1, Elements.size());
    }

    public int findLowestPrice() {
        List<WebElement> Elements = driver.findElements(By.xpath("//*[@data-title='Total']"));
        double lowest = 0;
        int lowestPosition=0;

        ArrayList<Double> array = new ArrayList<>();

        for (int i = 0; i < Elements.size() - 1; i++) {


      array.add( Double.parseDouble(Elements.get(i).getText().replace("$","")));


        }
        Collections.sort(array);
        lowest = array.get(0);

        System.out.println(lowest);
        for (int i = 0; i < Elements.size() - 1; i++) {

            if (lowest==Double.parseDouble(Elements.get(i).getText().replace("$","")))

            {
                lowestPosition = i;
                break;
            }
        }
        sleep(1000);
        return lowestPosition;
    }

    public void removeItem(int pos){
        List <WebElement> Elements = driver.findElements(By.className("remove"));
        Elements.get(pos).click();
        sleep(2000);



    }
    private void sleep (int time)
    {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }
}
