package basics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicSelenium3 {

    ChromeDriver chromeDriver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        // implicit wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://todo.ly/");
    }


    @Test
    public void verifycreationProject() throws InterruptedException {

        // click img login
        chromeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set text email
        chromeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("upb_api_prueba@upb.com");
        // set test pwd
        chromeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("upb123");
        // click boton login
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();


        chromeDriver.findElement(By.xpath("//*[@id=\"MainTable\"]/tbody/tr/td[1]/div[6]/div/table/tbody/tr/td[2]")).click();
        chromeDriver.findElement(By.id("NewProjNameInput")).sendKeys("ManuelV");
        chromeDriver.findElement(By.id("NewProjNameButton")).click();
        chromeDriver.findElement(By.id("CurrentProjectTitle"));

        Thread.sleep(5000);

        // verificacion : para saber si el login fue satisfactorio
        Assertions.assertTrue(chromeDriver.findElement(By.id("CurrentProjectTitle")).getText().equals("ManuelV"),"ERRROR el texto es distinto");


    }

    @Test
    public void verifyUpdate() throws InterruptedException {

        // click img login
        chromeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set text email
        chromeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("upb_api_prueba@upb.com");
        // set test pwd
        chromeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("upb123");
        // click boton login
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        chromeDriver.findElement(By.id("ItemId_3982476")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"ItemId_3982476\"]/table/tbody/tr/td[4]/div[2]")).click();
        chromeDriver.findElement(By.xpath("//a[text()='Edit']")).click();
        chromeDriver.findElement(By.id("ItemEditTextbox")).clear();
        chromeDriver.findElement(By.id("ItemEditTextbox")).sendKeys("ManuelVUpdate");
        chromeDriver.findElement(By.id("ItemEditSubmit")).click();
        Thread.sleep(5000);
        Assertions.assertTrue(chromeDriver.findElement(By.id("CurrentProjectTitle")).getText().equals("ManuelVUpdate"),"ERRROR el texto es distinto");









    }

    @AfterEach
    public void closeBrowser(){
        chromeDriver.quit();
    }

}
