package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class PersonalSettingsSection {
    public TextBox fullNameBox = new TextBox(By.id("FullNameInput"));
    public Button okButton=new Button(By.xpath("//span[@class=\"ui-button-text\" and contains(.,\"Ok\")]"));
}
