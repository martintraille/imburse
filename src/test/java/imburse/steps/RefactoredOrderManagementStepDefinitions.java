package imburse.steps;

import imburse.model.builder.InstructionDirector;
import imburse.model.builder.OrderDirector;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Order;
import imburse.model.response.error.ErrorMessage;
import imburse.utilities.Randomiser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.junit.runner.RunWith;
import utilities.TestData;

import static imburse.utilities.Randomiser.customRandomAlphanumericString;
import static org.junit.Assert.assertTrue;
import static utilities.TestData.DataKeys.*;


@RunWith(SerenityRunner.class)
public class RefactoredOrderManagementStepDefinitions {

    private OrderDirector orderDirector = new OrderDirector();
    private InstructionDirector instructionDirector = new InstructionDirector();
    public Order generatedOrder;
    public Instruction generatedInstruction;
    private TestData testData = new TestData();
    private EnvironmentVariables environmentVariables;
    private Randomiser randomiser;
    private String createInstructionResponse;
    private String orderResponse;

   /* @Steps(shared = true)
    AuthenticatedUserSteps james = new AuthenticatedUserSteps();*/

    @Steps(shared = true)
    AuthenticationSteps registeredUser;

    @Given("an {string}")
    public void an(String scenario) {
        switch (scenario) {

            case "order with no instruction":
                testData.setData(SCENARIO, scenario);
                testData.setData(EXPECTED_STATUS_CODE, environmentVariables.getProperty("orderwithoutinstructionstatuscode"));
                testData.setData(EXPECTED_STATUS_CODE_MESSAGE, environmentVariables.getProperty("orderwithoutinstructionsstatuscodemessage"));
                generatedOrder = orderDirector.anOrderWithNoInstruction();
                break;

            case "order with an instruction":
                testData.setData(EXPECTED_STATUS_CODE, environmentVariables.getProperty("orderwithinstructionstatuscode"));
                testData.setData(EXPECTED_STATUS_CODE_MESSAGE, environmentVariables.getProperty("orderwithinstructionsstatuscodemessage"));

                generatedOrder = orderDirector.anOrderWithAnInstruction();

                break;

            case "order with an order reference of 50 alphanumeric characters":
                generatedOrder = orderDirector.anOrderWith50CharOrderReference();

                break;

            case "order has a duplicate order reference":
                generatedOrder = orderDirector.anOrderWithADuplicateOrderReference();

                break;

            case "order with metadata value of 101 characters":
                generatedOrder = orderDirector.anOrderWith101MetadataValueCharacters();

                break;

            case "order containing 100 instructions":
                generatedOrder = orderDirector.anOrderContaining100Instructions();

                break;
            case "order containing 101 instructions":
                generatedOrder = orderDirector.anOrderContaining101Instructions();

                break;

            case "existing order with no instruction":
                testData.setData(SCENARIO, scenario);
                String accountId = testData.getData(ACCOUNTID);
                String tenantId = testData.getData(TENANTID);
                String accessToken = testData.getData(ACCESS_TOKEN);

                generatedOrder = orderDirector.anOrderWithNoInstruction();
                // testData.setData(GENERATED_ORDER, generatedOrder);

                break;

            case "Instruction is created":
                generatedInstruction = instructionDirector.aValidInstruction();


                break;

        }


    }

    @Given("an {string} {string}")
    public void an(String scenario, String attribute) {
        switch (scenario) {

            case "order with an order reference of":
                testData.setData(SCENARIO, scenario);
                generatedOrder = orderDirector.anOrderWithABlankOrderRef(attribute);

                break;

            case "order with an order reference of 51 characters:":
                testData.setData(SCENARIO, scenario);
                generatedOrder = orderDirector.anOrderWithAnOutOfBoundsOrderRef(attribute);

                break;

            case "order with an alphanumeric order reference of":
                String generatedOrderRef = attribute + customRandomAlphanumericString();
                testData.setData(ORDER_REFERENCE, generatedOrderRef);
                generatedOrder = orderDirector.anOrderWithAnAlphaNumericOrderReference(generatedOrderRef);

                break;

            case "instruction is created with an instruction reference of":
                generatedInstruction = instructionDirector.anInstructionWithABlankReference(attribute);

                break;
        }

    }

    @When("a refactored {string} API call is made to the {string} endpoint")
    public void a_API_call_is_made_to_the_endpoint(String requestType, String endpoint) {
        String accountId = testData.getData(ACCOUNTID);
        String tenantId = testData.getData(TENANTID);
        String accessToken = testData.getData(ACCESS_TOKEN);
        String generatedOrderref = testData.getData(ORDER_REFERENCE);

        switch (endpoint) {

            case "Create Instruction":

                //james.callsAnEndpoint(requestType, endpoint, accessToken, accountId, tenantId, generatedInstruction);

                String api = "/v1/order-management/" + generatedOrderref + "/instruction";
                SerenityRest.given().log().all()
                        .header("Authorization", accessToken)
                        .header("x-account-id", accountId)
                        .header("x-tenant-id", tenantId)
                        .header("Content-Type", "application/json")
                        .body(generatedInstruction)
                        .when()
                        .post(api).then().statusCode(Integer.parseInt(testData.getData(EXPECTED_STATUS_CODE).toString()));
                break;

            case "Create Order":
                api = "/v1/order-management/";
                SerenityRest.given().log().all()
                        .header("Authorization", accessToken)
                        .header("x-account-id", accountId)
                        .header("x-tenant-id", tenantId)
                        .header("Content-Type", "application/json")
                        .body(generatedOrder)
                        .when()
                        .post(api);
                //.then().statusCode(Integer.parseInt(testData.getData(EXPECTED_STATUS_CODE).toString()));
                break;
        }
    }


    @Then("the instruction has been created successfully")
    public void the_instruction_has_been_created_successfully() {
        assertTrue(registeredUser.getStatusCode().equals("HTTP/1.1 201 Created"));
        createInstructionResponse = registeredUser.getResponseBody();
        assertTrue(createInstructionResponse.isEmpty());
    }

    @Then("the order is successfully created")
    public void the_order_is_successfully_created() {
        assertTrue(registeredUser.getStatusCode().equals(testData.getData(EXPECTED_STATUS_CODE_MESSAGE)));
        orderResponse = registeredUser.getResponseBody();
        assertTrue(orderResponse.isEmpty());
    }

    @Then("a {int} response code is returned")
    public void a_error_code_is_generated(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }

    @Then("a {string} response message is returned")
    public void a_success_message_is_generated(String responseMessage) {
        Assert.assertEquals(responseMessage, SerenityRest.lastResponse().getStatusLine());
        orderResponse = registeredUser.getResponseBody();
        assertTrue(orderResponse.isEmpty());
    }

    @Then("the error response will show {string}")
    public void the_response_will_show(String errorCode) {
        ErrorMessage errorMessage = SerenityRest.lastResponse().as(ErrorMessage.class);
        Assert.assertEquals(errorCode, errorMessage.getErrors().get(0).getErrorCode());
    }





}
