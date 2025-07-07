package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_account_registration() {
        logger.info("****** Starting TC001_AccountRegistrationTest ****");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account link");

            hp.clickRegister();
            logger.info("Clicked on Register Link");

            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

            logger.info("Providing Customer Details...");
            regPage.setFirstName(randomeString().toUpperCase());
            regPage.setLastName(randomeString().toUpperCase());
            regPage.setEmail(randomeString() + "@gmail.com");
            regPage.setTelephone(randomeNumber());

            String password = randomeAlphaNumberic();
            regPage.setPassword(password);
            regPage.setconfirmPassword(password);
            regPage.setPrivacyPolicy();
            regPage.clikContinue();

            logger.info("Validating expected confirmation message...");
            String confMsg = regPage.getConfirmationMsg();
            logger.info("Confirmation message received: " + confMsg);

            if (confMsg.trim().equalsIgnoreCase("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
                logger.info("Account registration successful.");
            } else {
                logger.error("Test failed. Unexpected confirmation message: " + confMsg);
                Assert.fail("Confirmation message mismatch.");
            }

        } catch (Exception e) {
            logger.error("Test encountered an exception: " + e.getMessage());
            Assert.fail("Exception occurred during account registration.");
        }

        logger.info("****** Finished TC001_AccountRegistrationTest ****");
    }
   

}

