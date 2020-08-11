package imburse.questions;

import imburse.ui.AccountPortalLandingPage;
import imburse.ui.AccountPortalTenantsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;
import java.util.List;

public class TheAccountPortalTenantTable {


    public static Question<Collection<String>> statusList() {
     return actor -> Text.of(AccountPortalTenantsPage.TENANT_TABLE).viewedBy(actor).asList();
    }

    public static Question<String> is() {
        return actor -> Text.of(AccountPortalTenantsPage.TENANT_TABLE).viewedBy(actor).asString();
    }

}