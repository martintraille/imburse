package imburse.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TenantPortalLoginPage extends PageObject {
    public static final Target EMAIL_ADDRESS = Target.the("Email address field").located(By.id("username"));
    public static final Target SUBMIT_BUTTON = Target.the("Continue Button").locatedBy(".ulp-button");
    public static final Target PASSWORD = Target.the("Password field").locatedBy("#password");
}
