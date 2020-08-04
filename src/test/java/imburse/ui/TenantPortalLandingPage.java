package imburse.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TenantPortalLandingPage extends PageObject {
    public static final Target HOME_MENU_ITEM = Target.the("Home Menu Item")
            .located(By.linkText("Home"));
    public static final Target LANDING_PAGE_WELCOME_MESSAGE = Target.the("Landing Page Welcome Message")
            .locatedBy("//span[contains(text(),\"Welcome. Let's get started\")]");
    //span[contains(text(),"Welcome. Let's get started")]

}
