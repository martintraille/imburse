package imburse.tasks.callendpoints;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import static utilities.TestData.DataKeys.*;
import static utilities.TestData.DataKeys.ACCESS_TOKEN;

public class Get {

    @Steps
    private TestData testData;

    public void from(String path) {

        String accountId = testData.getData(ACCOUNTID);
        String tenantId = testData.getData(TENANTID);
        String accessToken = testData.getData(ACCESS_TOKEN);

        OnStage.theActorInTheSpotlight()
                .whoCan(CallAnApi.at(testData.getData(BASE_URL)))
                .attemptsTo(
                        net.serenitybdd.screenplay.rest.interactions.Get.resource(path)
                        .with(request -> request
                                .header("Authorization", accessToken)
                                .header("x-account-id", accountId)
                                .header("x-tenant-id", tenantId)
                                .header("Content-Type", "application/json"))
                );

    }


}
