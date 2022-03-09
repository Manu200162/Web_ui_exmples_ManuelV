package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.SettingsPage;

import java.util.Date;

public class SettingNameTest extends BaseTodoLy {

    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection= new MenuSection();
    SettingsPage settingsPage= new SettingsPage();

    @Test
    public void verifyFullNameChanged() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("upb_api_prueba@upb.com");
        loginModal.pwdTxtBox.setText("upb123");
        loginModal.loginButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),"ERROR no se pudo hacer el login");

        //Actualizar el nombre
        String newName= "Manuel"+new Date().getTime();
        menuSection.settings.click();
        Thread.sleep(2000);
        settingsPage.fullNameBox.clearSetText(newName);
        settingsPage.okButton.click();
        menuSection.settings.click();
        Thread.sleep(2000);
        Assertions.assertEquals(settingsPage.fullNameBox.getTextAttributeControl("value"), newName,"ERROR no se modifico el nombre");
    }


}
