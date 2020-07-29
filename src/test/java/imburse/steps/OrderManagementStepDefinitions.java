package imburse.steps;

import imburse.model.builder.order.instruction.InstructionDirector;
import imburse.model.builder.order.OrderDirector;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.TestData.DataKeys.*;


@RunWith(SerenityRunner.class)
public class OrderManagementStepDefinitions {

    private final OrderDirector orderDirector = new OrderDirector();
    private final InstructionDirector instructionDirector = new InstructionDirector();
    private Order generatedOrder;
    private Instruction generatedInstruction;
    private final TestData testData = new TestData();
    private EnvironmentVariables environmentVariables;
    private Randomiser randomiser;
    private String createInstructionResponse;
    private String orderResponse;

    @Steps(shared = true)
    AuthenticationSteps registeredUser;

    @Given("an {string}")
    public void an(String scenario) {
        switch (scenario) {

            case "order with no instruction":
                testData.setData(SCENARIO, scenario);
                testData.setData(EXPECTED_STATUS_CODE, environmentVariables.getProperty("orderwithoutinstructionstatuscode"));
                testData.setData(EXPECTED_STATUS_CODE_MESSAGE, environmentVariables.getProperty("orderwithoutinstructionsstatuscodemessage"));
                setGeneratedOrder(orderDirector.anOrderWithNoInstruction());
                break;

            case "order with an instruction":
                testData.setData(EXPECTED_STATUS_CODE, environmentVariables.getProperty("orderwithinstructionstatuscode"));
                testData.setData(EXPECTED_STATUS_CODE_MESSAGE, environmentVariables.getProperty("orderwithinstructionsstatuscodemessage"));

                setGeneratedOrder(orderDirector.anOrderWithAnInstruction());

                break;

            case "order with an order reference of 50 alphanumeric characters":
                setGeneratedOrder(orderDirector.anOrderWith50CharOrderReference());

                break;

            case "order has a duplicate order reference":
                setGeneratedOrder(orderDirector.anOrderWithADuplicateOrderReference());

                break;

            case "existing order with no instruction":
                testData.setData(SCENARIO, scenario);
                setGeneratedOrder(orderDirector.anOrderWithNoInstruction());

                break;

            case "order with duplicate metadata keys":
                setGeneratedOrder(orderDirector.anOrderWithDuplicatedMetadataKeys());

            case "Instruction is created":
                setGeneratedInstruction(instructionDirector.aValidInstruction());

                break;
        }
    }

    @Given("an {string} {string}")
    public void an(String scenario, String attribute) {
        switch (scenario) {

            case "order with an order reference of":
                testData.setData(SCENARIO, scenario);
                setGeneratedOrder(orderDirector.anOrderWithABlankOrderRef(attribute));

                break;

            case "order with an order reference of 51 characters:":
                testData.setData(SCENARIO, scenario);
                setGeneratedOrder(orderDirector.anOrderWithAnOutOfBoundsOrderRef(attribute));

                break;

            case "order with an alphanumeric order reference of":
                String generatedOrderRef = attribute + customRandomAlphanumericString();
                testData.setData(ORDER_REFERENCE, generatedOrderRef);
                setGeneratedOrder(orderDirector.anOrderWithAnAlphaNumericOrderReference(generatedOrderRef));

                break;

            case "order with metadata key length of":
                int metadataKeyLength = Integer.parseInt(attribute);
                setGeneratedOrder(orderDirector.anOrderWithCustomMetadataKeyLength(metadataKeyLength));

                break;

            case "order with metadata value length of":
                int metadataValueLength = Integer.parseInt(attribute);
                setGeneratedOrder(orderDirector.anOrderWithCustomMetadataValueLength(metadataValueLength));

                break;
            case "instruction is created with an instruction reference of":
                setGeneratedInstruction(instructionDirector.anInstructionWithABlankReference(attribute));

                break;

            case "order with total number of instructions":
                int noOfInstructions = Integer.parseInt(attribute);
                setGeneratedOrder(orderDirector.anOrderContainingCustomNoOfInstructions(noOfInstructions));
                break;
        }

    }

    @When("a {string} API call is made to the {string} endpoint")
    public void a_API_call_is_made_to_the_endpoint(String requestType, String endpoint) {
        String accountId = testData.getData(ACCOUNTID);
        String tenantId = testData.getData(TENANTID);
        String accessToken = testData.getData(ACCESS_TOKEN);
        String generatedOrderref = testData.getData(ORDER_REFERENCE);

        switch (endpoint) {

            case "Create Instruction":

                String api = "/v1/order-management/" + generatedOrderref + "/features/api/instruction";
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
                break;
        }
    }


    @Then("the instruction has been created successfully")
    public void the_instruction_has_been_created_successfully() {
        assertEquals("HTTP/1.1 201 Created", registeredUser.getStatusCode());
        setCreateInstructionResponse(registeredUser.getResponseBody());
        assertTrue(createInstructionResponse.isEmpty());
    }

    @Then("the order is successfully created")
    public void the_order_is_successfully_created() {
        assertEquals(registeredUser.getStatusCode(), testData.getData(EXPECTED_STATUS_CODE_MESSAGE));
        setOrderResponse(registeredUser.getResponseBody());
        assertTrue(orderResponse.isEmpty());
    }

    @Then("a {int} response code is returned")
    public void a_error_code_is_generated(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }

    @Then("a {string} response message is returned")
    public void a_success_message_is_generated(String responseMessage) {
        Assert.assertEquals(responseMessage, SerenityRest.lastResponse().getStatusLine());
        setOrderResponse(registeredUser.getResponseBody());
        assertTrue(orderResponse.isEmpty());
    }

    @Then("the error response will show {string}")
    public void the_response_will_show(String errorCode) {
        ErrorMessage errorMessage = SerenityRest.lastResponse().as(ErrorMessage.class);
        Assert.assertEquals(errorCode, errorMessage.getErrors().get(0).getErrorCode());
    }


    public void setGeneratedOrder(Order generatedOrder) {
        this.generatedOrder = generatedOrder;
    }


    public void setGeneratedInstruction(Instruction generatedInstruction) {
        this.generatedInstruction = generatedInstruction;
    }


    public void setCreateInstructionResponse(String createInstructionResponse) {
        this.createInstructionResponse = createInstructionResponse;
    }

    public void setOrderResponse(String orderResponse) {
        this.orderResponse = orderResponse;
    }

}
