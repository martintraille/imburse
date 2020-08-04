package imburse.questions;

import imburse.ui.TenantListPage;
import imburse.ui.TenantPortalLandingPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheTenantPortalHomeMenuItem {

    public static Question<Boolean> isVisible() {
        return actor -> Visibility
                .of(TenantPortalLandingPage.HOME_MENU_ITEM)
                .viewedBy(actor)
                .asBoolean();
    }
}
