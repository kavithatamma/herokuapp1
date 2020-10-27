package org.example.stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageElements.HomePage;
import org.example.pageElements.LoginPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegistrationSteps {
    public HomePage homePage = new HomePage() ;
    public LoginPage loginPage =new LoginPage();
    @Given("^User is on Login Page$")
    public void user_is_on_Login_Page()  {
        homePage.clickFormAuthentication();
        String actual = loginPage.getCurrentUrl();
        assertThat(actual, is(endsWith("/login")));

    }

    @When("^User enters valid \"([^\"]*)\" and invalid \"([^\"]*)\"$")
    public void user_enters_valid_and_invalid(String userName, String password) throws InterruptedException {
        String exptErrMsg = "Your password is invalid!";
        loginPage.enterUsernameTextBox(userName);
        loginPage.enterPasswordTxtBox(password);
        loginPage.clickLoginBtn();
        String actualErrMsg=loginPage.resultError();
        //assertThat(actualErrMsg,is(equalToIgnoringCase(exptErrMsg)));
        //Assert.assertEquals(exptErrMsg,actualErrMsg);
    }

    @Then("^Verify User login status$")
    public void verify_User_login_status() throws InterruptedException {
        loginPage.statusCheck();
    }
    @When("^User enters invalid \"([^\"]*)\" and valid \"([^\"]*)\"$")
    public void user_enters_invalid_and_valid(String userName, String password) throws InterruptedException {
        loginPage.enterUsernameTextBox(userName);
        loginPage.enterPasswordTxtBox(password);
        loginPage.clickLoginBtn();
    }
    @When("^User enters valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
    public void user_enters_valid_and_valid(String userName, String password) throws InterruptedException {
        loginPage.enterUsernameTextBox(userName);
        loginPage.enterPasswordTxtBox(password);
        loginPage.clickLoginBtn();
        Thread.sleep(5000);

        String expLoginSuccessMsg = "You logged into a secure area!";
        String actualTxt = (loginPage.verifyLoginSuccessMsg()).trim();
        System.out.println("Login success message .. " + actualTxt);

        if(actualTxt.equals(expLoginSuccessMsg))
            System.out.println("Login Successful......... ");
        else
            System.out.println("Login Failed ............");


        loginPage.clickLogoutBtn();
        Thread.sleep(5000);
        String actLogoutMsg=loginPage.logoutMsg();
        System.out.println(actLogoutMsg);

    }

}
