package imburse.model.builder.order;

import imburse.model.builder.order.customerdefaults.CustomerDefaultsEngineer;
import imburse.model.builder.order.instruction.InstructionEngineer;
import imburse.model.builder.order.metadata.MetadataEngineer;
import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import imburse.model.request.order.Order;
import imburse.utilities.Randomiser;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import java.util.Arrays;
import java.util.Collections;

import static utilities.TestData.DataKeys.ORDER_REFERENCE;


public class OrderEngineer {

    @Steps(shared = true)
    private final TestData testData = new TestData();

    MetadataEngineer metadataEngineer = new MetadataEngineer();
    CustomerDefaultsEngineer customerDefaultsEngineer = new CustomerDefaultsEngineer();
    InstructionEngineer instructionEngineer = new InstructionEngineer();


    public Order generatedOrderWithNoInstruction() {
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Metadata validMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(validMetaData)
                .withCustomerDefaults(validCustomerDefaults).build();
    }

    public Order generatedOrderWithABlankOrderRef(String attribute) {

        testData.setData(ORDER_REFERENCE, attribute);

        Metadata validMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withMetadata(validMetaData)
                .withCustomerDefaults(validCustomerDefaults).build();

    }

    public Order generateOrderWithAnInstruction() {

        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();


    }

    public Order generateOrderWithAnOutOfBoundsOrderRef(String attribute) {
        testData.setData(ORDER_REFERENCE, attribute);
        Instruction generatedInstruction;
        generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Order generateOrderWithAnAlphaNumericOrderReference(String attribute) {
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Order generateOrderWith50CharOrderRef() {
        String generatedOrderRef = Randomiser.customRandomAlphanumericString(50);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

    }

    public Order generateOrderWithADuplicateOrderReference() {
        String duplicateOrderRef = testData.getData(ORDER_REFERENCE);

        Instruction generatedInstruction;
        generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData;
        generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(duplicateOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();


    }

    public Order generateOrderWith101MetadataValueCharacters() {
        String metadataValue = Randomiser.customRandomAlphanumericString(101);
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateMetadataWith101CharValue(metadataValue);
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();


    }

    public Order generateAnOrderWithCustomNoOfInstructions(int noOfInstructions) {

        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);


        Instruction[] generatedInstruction = instructionEngineer.generateListOfInstructions(noOfInstructions);
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

}