package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.ProjectCUD;

import java.util.Date;

public class CRUDProject extends BaseTodoLy   {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    ProjectCUD projectCUD = new ProjectCUD();

    @Test
    public void verifyLoginTodoLy() throws InterruptedException {
        //login
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("upb_api_prueba@upb.com");
        loginModal.pwdTxtBox.setText("upb123");
        loginModal.loginButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),"ERROR no se pudo hacer el login");
        //create
        projectCUD.addNewProjectButton.click();
        projectCUD.nProjTxtBox.setText(projectCUD.nameProj);
        projectCUD.saveNProject.click();
        Thread.sleep(2000);
        Assertions.assertEquals(projectCUD.nameProj,projectCUD.projectLabel.getTextControl(),"ERROR no se hizo la creacion");
        Assertions.assertTrue(projectCUD.actualProject.isControlDisplayed(),"ERROR no se hizo la creacion");

        //update
        projectCUD.projNameBox.click();
        projectCUD.optionsProjectButton.click();
        projectCUD.updateProject.click();
        projectCUD.updateProjTxtBox.clearSetText(projectCUD.newNameProj);
        projectCUD.saveUpdteButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(projectCUD.newNameProj,projectCUD.projectLabel.getTextControl(),"ERROR no se hizo update");
        Assertions.assertTrue(projectCUD.actualProjectUpdate.isControlDisplayed(),"ERROR no se hizo update");

        //delete
        projectCUD.projNameBoxUpdate.click();
        projectCUD.optionsProjectButton.click();
        projectCUD.deleteButton.click();
        Thread.sleep(3000);
        projectCUD.alertControl.alertAccept();
        Thread.sleep(4000);
        Assertions.assertTrue(!projectCUD.projectLabel.getTextControl().equals(projectCUD.newNameProj),"ERROR el projecto no se pudo eliminar");







    }
}
