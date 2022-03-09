package pages;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.id("ctl00_HeaderTopControl1_LinkButtonLogout"));
    public Button settings = new Button(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]"));



}
