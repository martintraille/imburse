package imburse.model.builder;

import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import imburse.model.request.order.Order;
import imburse.utilities.Randomiser;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import java.util.Arrays;

import static utilities.TestData.DataKeys.ORDER_REFERENCE;


public class OrderEngineer {

    @Steps(shared = true)
    private TestData testData = new TestData();

    MetadataEngineer metadataEngineer = new MetadataEngineer();
    CustomerDefaultsEngineer customerDefaultsEngineer = new CustomerDefaultsEngineer();
    InstructionEngineer instructionEngineer = new InstructionEngineer();


    public Order generatedOrderWithNoInstruction() {
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Metadata validMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(validMetaData)
                .withCustomerDefaults(validCustomerDefaults).build();

        return newOrder;
    }

    public Order generatedOrderWithABlankOrderRef(String attribute) {

        String generatedOrderref = attribute;
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Metadata validMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(validMetaData)
                .withCustomerDefaults(validCustomerDefaults).build();

        return newOrder;

    }

    public Order generateOrderWithAnInstruction() {

        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;


    }

    public Order generateOrderWithAnOutOfBoundsOrderRef(String attribute) {
        String generatedOrderref = attribute;
        testData.setData(ORDER_REFERENCE, generatedOrderref);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;
    }

    public Order generateOrderWithAnAlphaNumericOrderReference(String attribute) {
        String generatedOrderref = attribute;
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;
    }

    public Order generateOrderWith50CharOrderRef() {
        String generatedOrderRef = Randomiser.customRandomAlphanumericString(50);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderRef)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;

    }

    public Order generateOrderWithADuplicateOrderReference() {
        String duplicateOrderRef = testData.getData(ORDER_REFERENCE);

        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(duplicateOrderRef)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;

    }

    public Order generateOrderWith101MetadataValueCharacters() {
        String metadataValue = Randomiser.customRandomAlphanumericString(101);
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        Metadata generatedMetaData = metadataEngineer.generateMetadataWith101CharValue(metadataValue);
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;


    }

    public Order generateAnOrderWith100Instructions() {
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);


        Instruction[] generatedInstruction = instructionEngineer.generateListOfInstructions();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;


    }

    public Order generateAnOrderWith101Instructions() {
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);


        Instruction[] generatedInstruction = instructionEngineer.generateListOfInstructions();
        Metadata generatedMetaData = metadataEngineer.generateValidMetadata();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        Order newOrder = Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(generatedMetaData)
                .withCustomerDefaults(generatedCustomerDefaults).build();

        return newOrder;


    }
}
