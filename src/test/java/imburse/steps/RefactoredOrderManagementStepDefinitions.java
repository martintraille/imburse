package imburse.steps;

import imburse.model.builder.OrderDirector;
import imburse.model.request.order.Order;
import imburse.utilities.Randomiser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.runner.RunWith;
import utilities.TestData;

import static imburse.utilities.Randomiser.customRandomAlphanumericString;
import static utilities.TestData.DataKeys.*;


@RunWith(SerenityRunner.class)
public class RefactoredOrderManagementStepDefinitions {

    private OrderDirector orderDirector = new OrderDirector();
    public Order generatedOrder;
    private TestData testData = new TestData();
    private EnvironmentVariables environmentVariables;
    private Randomiser randomiser;

    @Steps(shared = true)
    AuthenticatedUserSteps james = new AuthenticatedUserSteps();

    @Given("an {string}")
    public void an(String scenario) {
        switch (scenario) {

            case "order with no instruction":
                testData.setData(SCENARIO, scenario);
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

            case "order has a duplicate order reference" :
                generatedOrder = orderDirector.anOrderWithADuplicateOrderReference();
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
        }

    }

    @When("a refactored {string} API call is made to the {string} endpoint")
    public void a_API_call_is_made_to_the_endpoint(String requestType, String endpoint) {
        String accountId = testData.getData(ACCOUNTID);
        String tenantId = testData.getData(TENANTID);
        String accessToken = testData.getData(ACCESS_TOKEN);

        james.callsAnEndpoint(endpoint, accessToken, accountId, tenantId, generatedOrder);

    }


}
