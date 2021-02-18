package stepDefinition;

import common.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook extends TestBase{

    @Before
    public void setUp(){
        TestBase.initialization();
    }
    @After
    public void teardown(){
        TestBase.closeBrowser();

    }
}

