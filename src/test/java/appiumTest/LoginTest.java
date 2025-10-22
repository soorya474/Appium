package appiumTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stream.driver.CommonStudio;
import com.stream.login.LoginPage;

public class LoginTest extends CommonStudio {

	@DataProvider(name = "loginCredentials")
	public Object[][] loginData() {
		return new Object[][] { { "tester1@simplestream.com", "TestLogin", true },
				{ "wrong@simplestream.com", "abc123", false } };
	}

	@Test(dataProvider = "loginCredentials")
	public void verifyUserLogin(String username, String password, boolean result) throws Exception {
		LoginPage lp = new LoginPage(driver);
		//System.out.println("object created");
		lp.login(username, password);
		lp.validateHomePage(driver, result);

	}

}
