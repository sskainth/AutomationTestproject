package stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BaseBrowser;
import utility.TestContext;

import java.io.IOException;
import java.util.prefs.BackingStoreException;

public class FlipCartStepDefination {
    TestContext context;


    public FlipCartStepDefination(TestContext context){
        this.context= context;
    }
    @When("user enter the product name {string}")
    public void userEnterProduct(String product) {
        context.pageObjectManager.getFlipcartHomePage().enterProduct(product);
    }


    @Then("store the phone and price details in xlxs file")
    public void storeInXlxsFile() throws IOException, InterruptedException {
        context.pageObjectManager.getFlipcartHomePage().retriveInFie();
    }

    @Then("verify the serach page")
    public void verifyTheSerachPage() {
    }

    @And("user search the product")
    public void userSearchTheProduct() {
        context.pageObjectManager.getFlipcartHomePage().searchProduct();
    }
}
