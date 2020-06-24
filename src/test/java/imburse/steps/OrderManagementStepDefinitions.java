package imburse.steps;

import imburse.model.request.order.Metadata;
import imburse.model.request.order.Order;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

@RunWith(SerenityRunner.class)
public class OrderManagementStepDefinitions {


    @Steps(shared = true)
    AuthenticationSteps registeredUser;


    public String accessToken;
    private Order newOrder;
    private String accountId;
    private String tenantId;
    private String generatedOrderref;
    private String orderResponse;

    @Before
    public void setTheStage() {
        RestAssured.baseURI = "https://sandbox-api.imbursepayments.com";
    }


    @Given("an order without an instruction")
    public void an_order_without_an_instruction() throws UnsupportedEncodingException {

        generatedOrderref = generateString();
        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(newMetadata).build();
    }


    @When("a {string} API call is made to the {string} endpoint")
    public void a_API_call_is_made_to_the_endpoint(String requestType, String endpoint) {
        accessToken = registeredUser.getAccessToken();
        accountId = registeredUser.getAccountId();
        tenantId = registeredUser.getTenantId();

        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + accessToken)
                .header("x-account-id", accountId)
                .header("x-tenant-id", tenantId)
                .header("Content-Type", "application/json")
                .body(newOrder)
                .when()
                .post(endpoint).then().statusCode(201);
    }


    @Then("the order is successfully created")
    public void the_order_is_successfully_created() {
        Assert.assertTrue(registeredUser.getStatusCode().equals("HTTP/1.1 201 Created"));
        orderResponse = registeredUser.getResponseBody();
        Assert.assertTrue(orderResponse.isEmpty());


    }

    public String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "AUTO" + uuid;
    }


}
