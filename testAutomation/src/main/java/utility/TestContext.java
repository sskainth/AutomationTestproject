package utility;

public class TestContext {

    public BaseBrowser base;
    public PageObjectManager pageObjectManager;

    public TestContext(){
        base = new BaseBrowser();
        pageObjectManager = new PageObjectManager(base.browserInvocation());
    }
}




