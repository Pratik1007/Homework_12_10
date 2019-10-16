import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import basicweb.EmailGenerator;
import utility.Utility;

//Created by Pratik Patel / HomeWork - 12/10/2019

public class RegistrationPageNopCommerce {
    //    declared two private variables
    private WebDriver driver;
    private JavascriptExecutor js;
    private Utility utility;
    private EmailGenerator basicweb;

//    public RegistrationPageNopCommerce(EmailGenerator basicweb) {
//        this.basicweb = basicweb;
//    }


    //    below will run before the test
    @Before
    public void setUp() {
        String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MISARI\\IdeaProjects\\selenium_hw_12_10_pratik\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        utility = new Utility(driver);
        basicweb = new EmailGenerator();

    }

    @Test
    public void userShouldNavigateToRegistrationPageSuccessfully() {

//        find element for Register link
        WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerLink.click();
        String expectedText = "Register";
//        Actual text
        WebElement registerText = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualText = registerText.getText();

//        Verify text "Register"
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterSuccessfully() {
//        find element for Register link
//        WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
//        registerLink.click();
        utility.clickOnElement(By.xpath("//a[@class='ico-register']"));

//        find element for (selecting Gender) 'Male' radio button
//        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='gender-male']"));
//        radioBtn.click();
        utility.clickOnElement((By.xpath("//input[@id='gender-male']")));

//        find element for Firstname field
//        WebElement firstNameField = driver.findElement(By.id("FirstName"));
//        firstNameField.sendKeys("Abc");
        utility.sendTextToElement(By.id("FirstName"), "Abc");

//        find element for Lastname field
//        WebElement lastNameField = driver.findElement(By.id("LastName"));
//        lastNameField.sendKeys("Xyz");
        utility.sendTextToElement(By.id("LastName"), "Xyz");

//        find element for DOB day dropped down list
//        WebElement dobDay = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
//        dobDay.click();
        utility.clickOnElement(By.xpath("//select[@name='DateOfBirthDay']"));

//        find element to select day
//        WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']//option[5]"));
//        day.click();
        utility.clickOnElement(By.xpath("//select[@name='DateOfBirthDay']//option[5]"));

//        find element for DOB Month dropped down list
//        WebElement dobMonth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
//        dobMonth.click();
        utility.clickOnElement(By.xpath("//select[@name='DateOfBirthMonth']"));

//        find element to select Month
//        WebElement month = driver.findElement(By.xpath("//option[contains(text(),'April')]"));
//        month.click();
        utility.clickOnElement(By.xpath("//option[contains(text(),'April')]"));

//        find element for DOB Year dropped down list
//        WebElement dobYear = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
//        dobYear.click();
        utility.clickOnElement(By.xpath("//select[@name='DateOfBirthYear']"));

//        find element to select Year
//        WebElement year = driver.findElement(By.xpath("//option[contains(text(),'1995')]"));
//        year.click();
        utility.clickOnElement(By.xpath("//option[contains(text(),'1995')]"));


//        find element for email field
//        WebElement emailField = driver.findElement(By.id("Email"));
//        emailField.sendKeys("rushto_pg2222@yahoo.com");
//        utility.Utility.sendTextToElement(By.id("Email"), "abc@gmail.com");
        EmailGenerator objE = new EmailGenerator();
        String randomEmail = objE.randomString()+"@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(randomEmail);


//        find element for companyName Field
//        WebElement companyField = driver.findElement(By.id("Company"));
//        companyField.sendKeys("ABC Corporation");
        utility.sendTextToElement(By.id("Company"), "ABC Corporation");

//        find elemnt for selecting Newsletters
//        WebElement newsLetter = driver.findElement(By.xpath("//input[@id='Newsletter']"));
//        newsLetter.click();
        utility.clickOnElement(By.xpath("//input[@id='Newsletter']"));

//        find element for password field
//        WebElement passWord = driver.findElement(By.id("Password"));
//        passWord.sendKeys("Abc1234");
        utility.sendTextToElement(By.id("Password"), "Abc1234");

//        find element for password field
//        WebElement confpassWord = driver.findElement(By.id("ConfirmPassword"));
//        confpassWord.sendKeys("Abc1234");
        utility.sendTextToElement(By.id("ConfirmPassword"), "Abc1234");

//        find element for Register-button
//        WebElement reg = driver.findElement(By.xpath("//input[@id='register-button']"));
//        reg.click();
        utility.clickOnElement(By.xpath("//input[@id='register-button']"));

//        String expectedText = "Your registration completed";

//        Actual text
//
//        WebElement registerText = driver.findElement(By.xpath("//div[@class='result']"));
//        String actualText = registerText.getText();

//        Verify text "Your registration completed"
//
//        Assert.assertEquals(expectedText, actualText);
        //Your registration completed
        String expectedMsg = "Your registration completed";
        String actMsg = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText(); //Act Msg
        //Assert.assertTrue("Your registration completed", utility.isElementDisplayed(By.xpath("//div[text()='Your registration completed']")));
        Assert.assertEquals("Result Doesn't Match",expectedMsg,actMsg);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
