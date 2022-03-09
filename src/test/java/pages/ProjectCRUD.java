package pages;

import control.AlertControl;
import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

import java.util.Date;

public class ProjectCRUD {

    //CREATE
    public String nameProj="MANUEL"+new Date().getTime();
    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox nProjTxtBox = new TextBox(By.id("NewProjNameInput"));
    public Button saveNProject = new Button(By.id("NewProjNameButton"));
    public Label projectLabel = new Label(By.id("CurrentProjectTitle"));
    public Label actualProject= new Label(By.xpath("//li[last()]//td[text()='"+nameProj+"']"));

    //UPDATE
    public Button projNameBox = new Button(By.xpath("//li[last()]//td[text()='"+nameProj+"']"));
    public Button optionsProjectButton = new  Button(By.xpath("//div[@style=\"display: block;\"]/img"));
    public Button updateProject= new Button(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']"));
    public TextBox updateProjTxtBox = new TextBox(By.xpath("//td/div/input[@id='ItemEditTextbox']"));
    public String newNameProj="manuel"+new Date().getTime()+"update";
    public Button saveUpdteButton = new Button(By.xpath("//td/div/img[@id=\"ItemEditSubmit\"]"));
    public Label actualProjectUpdate= new Label(By.xpath("//li[last()]//td[text()='"+newNameProj+"']"));

    //DELETE
    public Button projNameBoxUpdate = new Button(By.xpath("//li[last()]//td[text()='"+newNameProj+"']"));
    public Button deleteButton = new Button(By.id("ProjShareMenuDel"));
    public AlertControl alertControl = new AlertControl();


}
