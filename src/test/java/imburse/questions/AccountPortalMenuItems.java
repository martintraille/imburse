package imburse.questions;

import net.serenitybdd.screenplay.targets.Target;

public class AccountPortalMenuItems {
    public static final Target TENANTS = Target.the("Tenants Menu item").locatedBy("css=a[href='/tenants']");
}
