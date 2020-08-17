package imburse.tasks.callendpoints;

import imburse.model.request.order.RequestBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;
import utilities.TestData.DataKeys;

import static utilities.TestData.DataKeys.*;

public class Post {


    @Steps
    private TestData testData;

   public void to(String path, RequestBody body) {
       String accountId = testData.getData(ACCOUNTID);
       String tenantId = testData.getData(TENANTID);
       String accessToken = testData.getData(ACCESS_TOKEN);


       OnStage.theActorInTheSpotlight()
               .whoCan(CallAnApi.at(testData.getData(BASE_URL)))
               .attemptsTo(net.serenitybdd.screenplay.rest.interactions.Post.to(path)
               .with(request -> request.log().all()
                       .header("Authorization", accessToken)
                       .header("x-account-id", accountId)
                       .header("x-tenant-id", tenantId)
                       .header("Content-Type", "application/json")
                       .when()
                       .body(body)));

   }




    public void to(String path) {
        String accountId = testData.getData(ACCOUNTID);
        String tenantId = testData.getData(TENANTID);
        String accessToken = testData.getData(ACCESS_TOKEN);


        OnStage.theActorInTheSpotlight()
                .whoCan(CallAnApi.at(testData.getData(BASE_URL)))
                .attemptsTo(net.serenitybdd.screenplay.rest.interactions.Post.to(path)
                        .with(request -> request.log().all()
                                .header("Authorization", accessToken)
                                .header("x-account-id", accountId)
                                .header("x-tenant-id", tenantId)
                                .header("Content-Type", "application/json")
                                ));

    }





}
