package imburse.steps;

import imburse.model.request.order.Instruction;
import imburse.model.request.order.Order;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.runner.RunWith;
import utilities.TestData;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import static org.junit.Assert.assertTrue;
import static utilities.TestData.DataKeys.*;

@RunWith(SerenityRunner.class)
public class OrderManagementStepDefinitions {


    @Steps(shared = true)
    AuthenticationSteps registeredUser;
    @Steps(shared = true)
    AuthenticatedUserSteps james;
    @Steps(shared = true)
    private TestData testData;

    public String accessToken;
    private String accountId;
    private String tenantId;
    private String orderResponse;
    public Order generatedOrder;
    private String createInstructionResponse;
    private Instruction generatedInstruction;
    private EnvironmentVariables environmentVariables;

    @Before

    @Given("an order with no instruction")
    public void an_order_without_an_instruction() throws UnsupportedEncodingException {
        generatedOrder = james.createNewOrderWithoutInstruction();
        testData.setData(EXPECTED_STATUS_CODE, environmentVariables.getProperty("orderwithoutinstructionstatuscode"));
        testData.setData(EXPECTED_STATUS_CODE_MESSAGE, environmentVariables.getProperty("orderwithoutinstructionsstatuscodemessage"));

    }

    @Given("an order with an instruction")
    public void an_order_with_an_instruction() {
        generatedOrder = james.createNewOrderWithInstruction();
        testData.setData(EXPECTED_STATUS_CODE, environmentVariables.getProperty("orderwithinstructionstatuscode"));
        testData.setData(EXPECTED_STATUS_CODE_MESSAGE, environmentVariables.getProperty("orderwithinstructionsstatuscodemessage"));

    }


    @Given("an order with an invalid {string}")
    public void an_order_with_an_invalid(String orderRef) {
        generatedOrder = james.createNewOrderWithInstruction(orderRef);

    }

    @Then("the response will show {string}")
    public void the_response_will_show(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("a {string} API call is made to the {string} endpoint")
    public void a_API_call_is_made_to_the_endpoint(String requestType, String endpoint) {
        accountId = testData.getData(ACCOUNTID);
        tenantId = testData.getData(TENANTID);
        accessToken = testData.getData(ACCESS_TOKEN);

        james.callsAnEndpoint(endpoint, accessToken, accountId, tenantId, generatedOrder);

    }

    @Then("the order is successfully created")
    public void the_order_is_successfully_created() {
        assertTrue(registeredUser.getStatusCode().equals(testData.getData(EXPECTED_STATUS_CODE_MESSAGE)));
        orderResponse = registeredUser.getResponseBody();
        assertTrue(orderResponse.isEmpty());
    }

    @Given("an existing order is created with no instruction")
    public void an_order_is_created_with_no_Instruction() throws UnsupportedEncodingException {
        an_order_without_an_instruction();
        a_API_call_is_made_to_the_endpoint("post", "Create Order");
        the_order_is_successfully_created();
    }

    @Then("the instruction has been created successfully")
    public void the_instruction_has_been_created_successfully() {
        assertTrue(registeredUser.getStatusCode().equals("HTTP/1.1 201 Created"));
        createInstructionResponse = registeredUser.getResponseBody();
        assertTrue(createInstructionResponse.isEmpty());
    }


    public String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "AUTO" + uuid;
    }

}
