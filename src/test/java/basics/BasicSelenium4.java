package basics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Date;

public class BasicSelenium4 {

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
    public void verifyLoginTodoLyu() throws InterruptedException {

        // click img login
        chromeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set text email
        chromeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("clean@upb22.com");
        // set test pwd
        chromeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("12345");
        // click boton login
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(2000);

        //creacion

        String nameProj="UPB"+new Date().getTime();
        chromeDriver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        chromeDriver.findElement(By.id("NewProjNameInput")).sendKeys(nameProj);
        chromeDriver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(2000);
        Assertions.assertEquals(nameProj,chromeDriver.findElement(By.id("CurrentProjectTitle")).getText(),"ERROR no se creo el projecto");
        Assertions.assertTrue(chromeDriver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).isDisplayed(),"ERROR no creo el projecto");

        // Actualizacion

        chromeDriver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).click();
        chromeDriver.findElement(By.xpath("//div[@style='display: block;']/img")).click();
        chromeDriver.findElement(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']")).click();
        chromeDriver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).clear();

        String newNameProj="upb"+new Date().getTime();
        chromeDriver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).sendKeys(newNameProj);
        chromeDriver.findElement(By.xpath("//td/div/img[@id='ItemEditSubmit']")).click();

        Thread.sleep(2000);
        Assertions.assertEquals(newNameProj,chromeDriver.findElement(By.id("CurrentProjectTitle")).getText(),"ERROR no se creo el projecto");
        Assertions.assertTrue(chromeDriver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).isDisplayed(),"ERROR no creo el projecto");

        // delete
        chromeDriver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).click();
        chromeDriver.findElement(By.xpath("//div[@style='display: block;']/img")).click();
        chromeDriver.findElement(By.id("ProjShareMenuDel")).click();
        // ******* alerta   ***********
        chromeDriver.switchTo().alert().accept();
        Thread.sleep(2000);
        String currentName=chromeDriver.findElement(By.id("CurrentProjectTitle")).getText();
        Assertions.assertTrue(!currentName.equals(newNameProj),"ERROR el projecto no se Elimino");



    }

    @AfterEach
    public void closeBrowser(){
        chromeDriver.quit();
    }


}
