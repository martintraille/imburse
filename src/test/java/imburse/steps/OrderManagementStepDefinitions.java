package imburse.steps;

import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import imburse.model.request.order.Order;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SerenityRunner.class)
public class OrderManagementStepDefinitions {


    @Steps(shared = true)
    AuthenticationSteps registeredUser;
    @Steps(shared = true)
    AuthenticatedUserSteps james;


    public String accessToken;
    private Order newOrder;
    private Instruction newInstruction;
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


  /*      generatedOrderref = generateString();
        Serenity.setSessionVariable("generatedOrderRef").to(generatedOrderref);

        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(newMetadata).build();*/


    }


    @When("a {string} API call is made to the {string} endpoint")
    public void a_API_call_is_made_to_the_endpoint(String requestType, String endpoint) {

       //accessToken = registeredUser.getAccessToken();
       // Serenity.setSessionVariable("accountId").to(registeredUser.getAccountId());
        accountId = registeredUser.getAccountId();
       // Serenity.setSessionVariable("tenantId").to(registeredUser.getTenantId());
        tenantId = registeredUser.getTenantId();
        String accessToken = Serenity.sessionVariableCalled("generatedAccessToken");

        james.callsAnEndpoint(endpoint, accessToken, accountId, tenantId);



    }


    @Then("the order is successfully created")
    public void the_order_is_successfully_created() {
        assertTrue(registeredUser.getStatusCode().equals("HTTP/1.1 201 Created"));
        orderResponse = registeredUser.getResponseBody();
        assertTrue(orderResponse.isEmpty());


    }

    @Given("an order is created with no Instruction")
    public void an_order_is_created_with_no_Instruction() throws UnsupportedEncodingException {
        an_order_without_an_instruction();
        a_API_call_is_made_to_the_endpoint("post", "Create Order");
        the_order_is_successfully_created();


    }

    @Then("the instruction is successfully created")
    public void the_instruction_is_successfully_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the order is updated succesfully")
    public void the_order_is_updated_succesfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    public String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "AUTO" + uuid;
    }

    private String replaceString(String endpointToUpdate) {
        String master = endpointToUpdate;
        String target = "{orderRef}";
        String replacement = Serenity.sessionVariableCalled(generatedOrderref);
        String processed = master.replace(target, replacement);
        assertTrue(processed.contains(replacement));
        assertFalse(processed.contains(target));

        return processed;


    }


}
