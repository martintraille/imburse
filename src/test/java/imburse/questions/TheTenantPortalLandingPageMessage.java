package imburse.questions;

import imburse.ui.TenantPortalLandingPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheTenantPortalLandingPageMessage {

    public static Question<Boolean> isVisible() {
        return actor -> Visibility
                .of(TenantPortalLandingPage.LANDING_PAGE_WELCOME_MESSAGE)
                .viewedBy(actor)
                .asBoolean();
    }


}
