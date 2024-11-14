package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.TestContext;

public class Hooks {
    TestContext context;
    public Hooks(TestContext context){
        this.context = context;
    }

    @Before()
    public void preCondition() {
    }

    @After()
    public void postCondition(){

        context.base.browserInvocation().quit();
    }

    @BeforeStep()

    @AfterStep()
    public void takeScreenshot(Scenario sc){

        TakesScreenshot ts = (TakesScreenshot)context.base.browserInvocation();
        byte[] bytedate= ts.getScreenshotAs(OutputType.BYTES);
        sc.attach(bytedate,"image/png",sc.getName());

    }

}


