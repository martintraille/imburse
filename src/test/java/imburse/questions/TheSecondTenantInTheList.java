package imburse.questions;

import imburse.ui.TenantListPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheSecondTenantInTheList {
    public static Question<Boolean> isVisible() {
        return actor -> Visibility
                .of(TenantListPage.SECOND_TENANT)
                .viewedBy(actor)
                .asBoolean();
    }
}
