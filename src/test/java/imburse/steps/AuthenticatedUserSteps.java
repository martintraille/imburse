/*
package imburse.steps;

import imburse.model.request.order.*;
import imburse.utilities.Randomiser;
import io.cucumber.java.Before;
import io.cucumber.java.sl.In;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import java.util.*;

import static utilities.TestData.DataKeys.*;

public class AuthenticatedUserSteps {

    public Instruction newInstruction;
    private Instruction instruction;
    private String generatedOrderref;
    private Order newOrder;
    private Randomiser randomiser;

    private static ResponseSpecification responseSpec;
    private String generatedMetadataValue;
    private Order customisedOrder;
    public Instruction orderInstructions;
    private CustomerReference newCustomerReference;
    private Metadata newMetadata;
    private CustomerReferenceMetadata newCustomerReferenceMetadata;
    private CustomerDefaults newCustomerDefaults;
    private List<Instruction> instructionList;

    @Before
    public static void createResponseSpecification() {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }


    @Steps(shared = true)
    private TestData testData;

    @Step
    public void callsAnEndpoint(String requestType, String endpoint, String accessToken, String accountId, String tenantId, Order order) {

        String api;

        switch (endpoint) {

            case "Create Order":
                api = "/v1/order-management/";
                SerenityRest.given().log().all()
                        .header("Authorization", accessToken)
                        .header("x-account-id", accountId)
                        .header("x-tenant-id", tenantId)
                        .header("Content-Type", "application/json")
                        .body(order)
                        .when()
                        .post(api);
                //.then().statusCode(Integer.parseInt(testData.getData(EXPECTED_STATUS_CODE).toString()));
                break;


            case "Create Instruction":

               Instruction instruction = testData.getData(GENERATED_INSTRUCTION);
                api = "/v1/order-management/" + generatedOrderref + "/instruction";
                SerenityRest.given().log().all()
                        .header("Authorization", testData.getData(ACCESS_TOKEN))
                        .header("x-account-id", accountId)
                        .header("x-tenant-id", tenantId)
                        .header("Content-Type", "application/json")
                        .body(instruction)
                        .when()
                        .post(api).then().statusCode(Integer.parseInt(testData.getData(EXPECTED_STATUS_CODE).toString()));
                break;
        }
    }


    public Order createNewOrderWithoutInstruction() {
        generatedOrderref = generateString();
        Serenity.setSessionVariable("generatedOrderRef").to(generatedOrderref);

        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(newMetadata).build();

        return newOrder;
    }

    public Instruction createNewInstruction() {
        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        Instruction newInstruction = Instruction.InstructionBuilder.anInstruction()
                .withInstructionRef("A123124516")
                .withCustomerRef("13212412")
                .withDirection("CREDIT")
                .withFinancialInstrumentId(" ")
                .withAmount("5.00")
                .withCurrency("EUR")
                .withCountry("IE")
                .withSettledByDate("2020-07-21")
                .withSchemeId("654EB81FF7F07F7CF5A1EE3FF6972E90")
                .withMetadata(newMetadata)
                .build();

        return newInstruction;
    }


    public String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "AUTO" + uuid;
    }

    public Order createNewOrderWithInstruction() {

        generatedOrderref = generateString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        List<Instruction> instructions = Arrays.asList(createNewInstruction());
        Serenity.setSessionVariable("generatedOrderRef").to(generatedOrderref);

        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();


        newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(instructions)
                .withMetadata(newMetadata).build();

        return newOrder;
    }

    public Order createNewOrderWithInstruction(String orderRef) {

        switch (orderRef) {

            case "RaNdOmAlPhANuMeRiC._-":

            case "DuplicateOrderRef":

                generatedOrderref = orderRef + Randomiser.customRandomAlphanumericString();
                testData.setData(ORDER_REFERENCE, generatedOrderref);
                break;

            case "duplicate":

                generatedOrderref = testData.getData(ORDER_REFERENCE);
                break;

            default:
                generatedOrderref = (orderRef);
        }

        List<Instruction> instructions = Arrays.asList(createNewInstruction());
        Serenity.setSessionVariable("generatedOrderRef").to(generatedOrderref);


        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();


        CustomerReferenceMetadata newCustomerReferenceMetadata = CustomerReferenceMetadata.CustomerReferenceMetadataBuilder.aCustomerReferenceMetadata()
                .withKey1("NULL")
                .withKey2("NULL")
                .withKey3("NULL").build();

        CustomerReference newCustomerReference = CustomerReference.CustomerReferenceBuilder.aCustomerReference()
                .withFinancialInstrumentId("")
                .withSchemeId(testData.getData(SCHEMEID))
                .withCustomerReferenceMetadata(newCustomerReferenceMetadata)
                .build();

        CustomerDefaults newCustomerDefaults = CustomerDefaults.CustomerDefaultsBuilder.aCustomerDefaults()
                .withCustref1(newCustomerReference)
                .build();


        newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(instructions)
                .withMetadata(newMetadata)
                .withCustomerDefaults(newCustomerDefaults).build();

        return newOrder;

    }


    public Order createNewOrderWithInstruction(int noOfChars) {

        generatedOrderref = Randomiser.customRandomAlphanumericString(noOfChars);

        instructionList = Arrays.asList(createNewInstruction());
        Serenity.setSessionVariable("generatedOrderRef").to(generatedOrderref);

        newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(instructionList)
                .withMetadata(newMetadata).build();

        return newOrder;
    }

}
*/
