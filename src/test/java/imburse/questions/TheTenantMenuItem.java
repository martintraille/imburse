package imburse.questions;

import imburse.ui.AccountHomePage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheTenantMenuItem {
    public static Question<Boolean> isVisible() {
        return actor -> Visibility
                .of(AccountHomePage.TENANTS)
                .viewedBy(actor)
                .asBoolean();
    }


}
