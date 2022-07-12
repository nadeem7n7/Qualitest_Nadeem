package stepDefinitions;

import Runner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.HomePage;

public class AddToCart extends TestRunner {

    int lowestPosition = 0;

    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);

    @Given("I add {int} random items to cart")
    public void i_add_four_random_items_to_cart(int num) {


        driver.get("https://cms.demo.katalon.com/");

        homePage.addToCart(num);


    }

    @When("I view my cart")
    public void i_view_my_cart() {

        homePage.goToCart();

    }

    @Then("I find total {int} items listed in my cart")
    public void i_find_total_items_listed_in_my_cart(int num) {

        cartPage.checkCart(num);
    }

    @When("I search for lowest price item")
    public void i_search_for_lowest_price_item() {
      lowestPosition =  cartPage.findLowestPrice();


    }

    @When("I am able to remove the lowest price item")
    public void i_am_able_to_remove_the_lowest_price_item() {

        cartPage.removeItem(lowestPosition);


    }



}
