package imburse.steps;

import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import imburse.model.request.order.Order;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.UUID;

import static io.restassured.RestAssured.when;

public class AuthenticatedUserSteps {


    private Instruction newInstruction;
    private Instruction instruction;
    private Order order;
    private String generatedOrderref;
    private Order newOrder;

    @Step
    public void callsAnEndpoint(String endpoint, String accessToken, String accountId, String tenantId) {
       String api;

        switch (endpoint) {

            case "Create Order":
                order = createNewOrder();
                 api  = "/v1/order-management/";
                SerenityRest.given().log().all()
                        .header("Authorization", "Bearer " + accessToken)
                        .header("x-account-id", accountId)
                        .header("x-tenant-id", tenantId)
                        .header("Content-Type", "application/json")
                        .body(order)
                        .when()
                        .post(api).then().statusCode(201);
                break;

            case "Create Instruction":

                instruction = createNewInstruction();
                 api = "/v1/order-management/" + generatedOrderref + "/instruction";
                SerenityRest.given().log().all()
                        .header("Authorization", "Bearer " + accessToken)
                        .header("x-account-id", accountId)
                        .header("x-tenant-id", tenantId)
                        .header("Content-Type", "application/json")
                        .body(instruction)
                        .when()
                        .post(api).then().statusCode(201);
                break;


        }
    }

    public Order createNewOrder() {
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


    private Instruction createNewInstruction() {
        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        newInstruction = Instruction.InstructionBuilder.anInstruction()
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

}
