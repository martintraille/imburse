package imburse.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountPortalLandingPage extends PageObject {
    public static final Target TENANTS = Target.the("Tenants Menu item")
            .located(By.xpath("//span[contains(text(),'Tenants')]"));
    public static final Target SWITCH_ACCOUNTS_DROPDOWN = Target.the("Switch Accounts Dropdown")
            .located(By.className("_2gprPp5XTH1PVd5mQcJYc1"));
    public static final Target CURRENT_ACCOUNT_NAME = Target.the("Current Account Name")
            .located(By.cssSelector("._1_1mcVwHpRkzmNtR9eW64J"));
}
