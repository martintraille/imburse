package imburse.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

public class AccountPortalTenantsPage extends PageObject {

    public static final Target TENANT_TABLE = Target.the("Test Tenant 1e")
            .located(By.xpath("//tr[1]//td[1]"));





}
