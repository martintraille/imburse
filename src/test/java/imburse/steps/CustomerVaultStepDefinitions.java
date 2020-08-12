package imburse.steps;

import imburse.model.builder.financialinstrumentmobile.FinancialInstrumentMobileDirector;
import imburse.model.request.financialinstrumentcreation.FinancialInstrumentMobile;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.runner.RunWith;
import utilities.TestData;

import static org.hamcrest.CoreMatchers.equalTo;
import static utilities.TestData.DataKeys.*;

@RunWith(SerenityRunner.class)
public class CustomerVaultStepDefinitions {

    private FinancialInstrumentMobileDirector financialInstrumentMobileDirector = new FinancialInstrumentMobileDirector();

    private FinancialInstrumentMobile financialInstrumentMobile;
    private String financialInstrumentResponse;
    private final TestData testData = new TestData();
    private EnvironmentVariables environmentVariables;

    @Steps(shared = true)
    AuthenticationSteps registeredUser;

    private static final String MARTIN = "Martin";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
       // theActorCalled(MARTIN).whoCan(CallAnApi.at("https://qa-api.imburse.net/"));
    }


    @Given("a country code of {string} and a valid national mobile phone number of {string}")
    @Step
    public void a_country_code_of_and_a_valid_national_mobile_phone_number_of(String countryCode, String mobileNumber) {
       // OnStage.theActorInTheSpotlight().attemptsTo(Generate.aValidFinancialInstumentMobile(countryCode,mobileNumber));
                setFinancialInstrumentMobile(financialInstrumentMobileDirector.aValidFinancialInstrumentMobile(countryCode, mobileNumber));
    }

    @When("a Post API call is made to the {string} {string} endpoint")
    public void a_Post_API_call_is_made_to_the_endpoint(String apiVersion, String endpoint) {

        String accountId = testData.getData(ACCOUNTID);
        String tenantId = testData.getData(TENANTID);
        String accessToken = testData.getData(ACCESS_TOKEN);

        switch (endpoint) {

            case "Create financial instrument mobile":
               String api = apiVersion + "/customer-vault/1234567/mobile";
                SerenityRest.given().log().all()
                        .header("Authorization", accessToken)
                        .header("x-account-id", accountId)
                        .header("x-tenant-id", tenantId)
                        .header("Content-Type", "application/json")
                        .body(getFinancialInstrumentMobile())
                        .when()
                        .post(api);
        }
    }


    @Then("the response should contain the financial instrument id {string}")
    public void the_response_should_contain_the_financial_instrument_id(String financialInstrumentId) {
        setFinancialInstrumentResponse(registeredUser.getResponseBody());
        Ensure.that("The Financial Id is present and correct",
               financialInstrumentResponse -> financialInstrumentResponse.body("id", equalTo(financialInstrumentId)));


    }


    public FinancialInstrumentMobile getFinancialInstrumentMobile() {
        return financialInstrumentMobile;
    }

    public void setFinancialInstrumentMobile(FinancialInstrumentMobile financialInstrumentMobile) {
        this.financialInstrumentMobile = financialInstrumentMobile;
    }


    public void setFinancialInstrumentResponse(String financialInstrumentResponse) {
        this.financialInstrumentResponse = financialInstrumentResponse;
    }



}
