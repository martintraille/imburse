package imburse.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.junit.runner.RunWith;
import utilities.TestData;

import java.io.UnsupportedEncodingException;

import static imburse.steps.AuthenticationSteps.generatesHmac;
import static utilities.TestData.DataKeys.*;

@RunWith(SerenityRunner.class)
public class BearerTokenStepDefinitions {

    private String accountId;
    private String tenantId;
    private String hmac;
    private String bearerTokenResponse;
    private EnvironmentVariables environmentVariables;


    @Steps(shared = true)
    AuthenticationSteps picard;

    @Steps(shared = true)
    private TestData testData;


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        RestAssured.baseURI = "https://sandbox-api.imbursepayments.com";

        testData.setData(ACCOUNTID, environmentVariables.getProperty("accountid"));
        testData.setData(TENANTID, environmentVariables.getProperty("tenantid"));
        testData.setData(SCHEMEID, environmentVariables.getProperty("schemeid"));
    }


    @Given("(Picard) has a valid accountId and tenantID")
    public void registered_user_has_a_valid_accountId_and_tenantID() {
        accountId = testData.getData(ACCOUNTID);
        tenantId = testData.getData(TENANTID);
    }

    @When("he attempts to authenticate via the {string} endpoint")
    public void he_attempts_to_authenticate_via_the_endpoint(String endpoint) throws UnsupportedEncodingException {
        hmac = generatesHmac();
        SerenityRest.given().log().all().queryParam("AccountId", accountId).queryParam("TenantId", tenantId)
                .header("Authorization", "Hmac " + hmac).header("ContentType", "application/json")
                .body("")
                .when()
                .post(endpoint).then().statusCode(201);
    }

    @Then("he receives a bearer token")
    public void he_receives_a_bearer_token() {

        Serenity.setSessionVariable("generatedAccessToken").to(picard.getAccessToken());
        testData.setData(ACCESS_TOKEN, "Bearer " + picard.getAccessToken());
        bearerTokenResponse = picard.getResponseBody();
        Assert.assertTrue(bearerTokenResponse.contains("accessToken"));
        System.out.println("*****Bearer Token is:****" + bearerTokenResponse);
        System.out.println("********ENUMED***********" + testData.getData(ACCESS_TOKEN));

    }


}
