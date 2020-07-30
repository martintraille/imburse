package imburse.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountHomePage {
    public static final Target TENANTS = Target.the("Tenants Menu item").located(By.xpath("//span[contains(text(),'Tenants')]"));
}
