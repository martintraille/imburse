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
    public static final Target SWITCH_ACCOUNTS = Target.the("Switch Accounts Toggle")
        .located(By.cssSelector("._2BFNdb0NPFiIC5N5MHS9s2"));
    public static final Target AUTOMATION_TEST_ACCOUNT = Target.the("Automation Test Account")
            .located(By.cssSelector("._2BFNdb0NPFiIC5N5MHS9s2._2G8x089G7OH8silGgmSq9z"));

}
