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
    public static final Target CONTINUE_FOR_AUTOMATION_TENANT = Target.the("First Continue in Tenant List")
            .located(By.xpath("//button[@id='73314400-5645-4990-a89e-29b2485cce69']"));

    

}