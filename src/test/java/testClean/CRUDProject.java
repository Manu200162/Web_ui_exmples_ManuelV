package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.ProjectCRUDSection;

public class CRUDProject extends BaseTodoLy   {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    ProjectCRUDSection projectCRUD = new ProjectCRUDSection();

    @Test
    public void verifyCRUDProjectTodoLy() throws InterruptedException {
        //login
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("upb_api_prueba@upb.com");
        loginModal.pwdTxtBox.setText("upb123");
        loginModal.loginButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),"ERROR no se pudo hacer el login");
        //create
        projectCRUD.addNewProjectButton.click();
        projectCRUD.nProjTxtBox.setText(projectCRUD.nameProj);
        projectCRUD.saveNProject.click();
        Thread.sleep(2000);
        Assertions.assertEquals(projectCRUD.nameProj,projectCRUD.projectLabel.getTextControl(),"ERROR no se hizo la creacion");
        Assertions.assertTrue(projectCRUD.actualProject.isControlDisplayed(),"ERROR no se hizo la creacion");

        //update
        projectCRUD.projNameBox.click();
        projectCRUD.optionsProjectButton.click();
        projectCRUD.updateProject.click();
        projectCRUD.updateProjTxtBox.clearSetText(projectCRUD.newNameProj);
        projectCRUD.saveUpdteButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(projectCRUD.newNameProj,projectCRUD.projectLabel.getTextControl(),"ERROR no se hizo update");
        Assertions.assertTrue(projectCRUD.actualProjectUpdate.isControlDisplayed(),"ERROR no se hizo update");

        //delete
        projectCRUD.projNameBoxUpdate.click();
        projectCRUD.optionsProjectButton.click();
        projectCRUD.deleteButton.click();
        Thread.sleep(3000);
        projectCRUD.alertControl.alertAccept();
        Thread.sleep(4000);
        Assertions.assertTrue(!projectCRUD.projectLabel.getTextControl().equals(projectCRUD.newNameProj),"ERROR el projecto no se pudo eliminar");







    }
}
