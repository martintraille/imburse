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
import net.thucydides.core.util.SystemEnvironmentVariables;
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
    private EnvironmentVariables environmentVariables;


    @Steps(shared = true)
    AuthenticationSteps picard;

    @Steps(shared = true)
    private TestData testData;


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
   //     String environment = environmentVariables.getProperty("environment");
        EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
        String environment = env.getProperty("ENV");
        switch (environment) {
            case "qa":
                RestAssured.baseURI = environmentVariables.getProperty("qaapiurl");
                testData.setData(ACCOUNTID, environmentVariables.getProperty("qaaccountid"));
                testData.setData(TENANTID, environmentVariables.getProperty("qatenantid"));
                ;
                testData.setData(PUBLICKEY, environmentVariables.getProperty("qapublickey"));
                testData.setData(PRIVATEKEY, environmentVariables.getProperty("qaprivatekey"));
                testData.setData(SCHEMEID, environmentVariables.getProperty("schemeid"));
                break;
            case "sandbox":
                RestAssured.baseURI = environmentVariables.getProperty("sandboxurl");
                testData.setData(ACCOUNTID, environmentVariables.getProperty("sandboxaccountid"));
                testData.setData(TENANTID, environmentVariables.getProperty("sandboxtenantid"));
                testData.setData(PUBLICKEY, environmentVariables.getProperty("sandboxpublickey"));
                testData.setData(PRIVATEKEY, environmentVariables.getProperty("sandboxprivatekey"));
                testData.setData(SCHEMEID, environmentVariables.getProperty("sandboxschemeid"));
                break;
        }
//        RestAssured.baseURI = environmentVariables.getProperty("qaapiurl");
//
//        testData.setData(ACCOUNTID, environmentVariables.getProperty("accountid"));
//        testData.setData(TENANTID, environmentVariables.getProperty("tenantid"));
//        testData.setData(SCHEMEID, environmentVariables.getProperty("schemeid"));
    }


    @Given("(Picard) has a valid accountId and tenantID")
    public void registered_user_has_a_valid_accountId_and_tenantID() {
        setAccountId(testData.getData(ACCOUNTID));
        setTenantId(testData.getData(TENANTID));
    }

    @When("he attempts to authenticate via the {string} {string} endpoint")
    public void he_attempts_to_authenticate_via_the_endpoint(String apiversion, String endpoint) throws UnsupportedEncodingException {
       String publicKey = testData.getData(PUBLICKEY);
       String privateKey = testData.getData(PRIVATEKEY);
        setHmac(generatesHmac(publicKey, privateKey));
        SerenityRest.given().log().all()
                //.queryParam("x-account-id", accountId).queryParam("x-tenant-id", tenantId)
                .header("Authorization", "Hmac " + hmac)
                .header("ContentType", "application/json")
                .header("x-account-id", accountId)
                .header("x-tenant-id", tenantId)
                .body("")
                .when()
                .post(apiversion + endpoint).then().statusCode(201);
    }

    @Then("he receives a bearer token")
    public void he_receives_a_bearer_token() {

        Serenity.setSessionVariable("generatedAccessToken").to(picard.getAccessToken());
        testData.setData(ACCESS_TOKEN, "Bearer " + picard.getAccessToken());
        String bearerTokenResponse = picard.getResponseBody();
        Assert.assertTrue(bearerTokenResponse.contains("accessToken"));
        System.out.println("*****Bearer Token is:****" + bearerTokenResponse);
        System.out.println("********ENUMED***********" + testData.getData(ACCESS_TOKEN));

    }

    public String getHmac() {
        return hmac;
    }

    public void setHmac(String hmac) {
        this.hmac = hmac;
    }


    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }


}
