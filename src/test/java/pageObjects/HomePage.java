package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomePage {

    private ChromeDriver driver;

    public HomePage(ChromeDriver driver) {

        this.driver = driver;
    }

    public void addToCart(int num) {


        List<WebElement> Elements = driver.findElements(By.xpath("//a[contains (@href,'add-to-cart')]"));

        for (int i = 0; i < num; i++) {
            Elements.get(i).click();
            sleep(500);
        }

    }

    public void goToCart()
    {
        List<WebElement> Elements = driver.findElements(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/']"));
        Elements.get(0).click();
        Assert.assertEquals("Cart", driver.findElement(By.className("page-title")).getText().trim());

    }

    private void sleep (int time)
    {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }


}

