package imburse.questions;

import imburse.ui.AccountPortalLandingPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheAccountName {


    public static Question<String> is() {
        return actor -> Text.of(AccountPortalLandingPage.CURRENT_ACCOUNT_NAME).viewedBy(actor).asString();
    }
}
