package imburse.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TenantListPage extends PageObject {

    public static final Target HEADER_MESSAGE = Target.the("Header message text")
            .located(By.xpath("//span[contains(text(),'Which tenant do you wish to log in as?')]"));
    public static final Target FIRST_TENANT = Target.the("First Tenant in List")
            .located(By.xpath("//div[contains(text(),'Supercharged Insurance AG')]"));
    public static final Target SECOND_TENANT = Target.the("Second Tenant in List")
            .located(By.xpath("//div[contains(text(),'Test Tenant')]"));

    

}