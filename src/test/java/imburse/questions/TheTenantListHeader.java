package imburse.questions;

import imburse.ui.AccountHomePage;
import imburse.ui.TenantListPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheTenantListHeader {

    public static Question<Boolean> isVisible() {
        return actor -> Visibility
                .of(TenantListPage.HEADER_MESSAGE)
                .viewedBy(actor)
                .asBoolean();
    }
}
