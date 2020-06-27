package imburse.steps;

import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import imburse.model.request.order.Order;
import imburse.utilities.Randomiser;
import io.cucumber.java.Before;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static utilities.TestData.DataKeys.*;

public class AuthenticatedUserSteps {

    public Instruction newInstruction;
    private Instruction instruction;
    private String generatedOrderref;
    private Order newOrder;
     private Randomiser randomiser;

    private static ResponseSpecification responseSpec;


    @Before
    public static void createResponseSpecification() {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }


    @Steps(shared = true)
    private TestData testData;

    @Step
    public void callsAnEndpoint(String endpoint, String accessToken, String accountId, String tenantId, Order order) {

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
                instruction = createNewInstruction();
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

            case "DuplicateOrderRef" :

                generatedOrderref = orderRef + Randomiser.customRandomAlphanumericString();
                testData.setData(ORDER_REFERENCE, generatedOrderref);
                break;

            case "duplicate":

                generatedOrderref = testData.getData(ORDER_REFERENCE);
                break;

            default :generatedOrderref = (orderRef);
        }

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





    public Order createNewOrderWithInstruction(int noOfChars) {

       generatedOrderref =  Randomiser.customRandomAlphanumericString(noOfChars);


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







}
