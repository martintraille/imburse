package imburse.model.request.order.builderpattern;


import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.CustomerReference;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import imburse.steps.AuthenticatedUserSteps;
import imburse.utilities.Randomiser;

import java.util.ArrayList;
import java.util.List;

public class HappyOrderBuilder implements OrderBuilder {

    private Randomiser randomiser;
    private AuthenticatedUserSteps authenticatedUserSteps;

    private Order order;
    private List<Instruction> newInstructions;


    public HappyOrderBuilder() {
        this.order = new Order();
    }


    @Override
    public void buildOrdersOrderRef() {
        order.setOrdersOrderRef(Randomiser.customRandomAlphanumericString());
    }

    @Override
    public void buildOrdersOrderInstructions() {
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


        order.setOrdersOrderInstructions(newInstructions);
    }

    @Override
    public void buildOrdersOrderMetadata() {

        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        order.setOrdersOrderMetadata(newMetadata);

    }

    @Override
    public void buildOrdersCustomerDefaults() {


        CustomerDefaults newCustomerDefaults = CustomerDefaults.CustomerDefaultsBuilder.aCustomerDefaults().build();

        order.setOrdersOrderCustomerDefaults(newCustomerDefaults);

    }

    @Override
    public Order getOrder() {
        return this.order;
    }
}
