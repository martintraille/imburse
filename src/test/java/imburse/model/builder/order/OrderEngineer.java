package imburse.model.builder.order;

import imburse.model.builder.order.customerdefaults.CustomerDefaultsEngineer;
import imburse.model.builder.order.instruction.InstructionEngineer;
import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Order;
import imburse.utilities.MetadataGenerator;
import imburse.utilities.Randomiser;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import java.util.Arrays;
import java.util.Collections;

import static utilities.TestData.DataKeys.ORDER_REFERENCE;


public class OrderEngineer {

    @Steps(shared = true)
    private final TestData testData = new TestData();

    CustomerDefaultsEngineer customerDefaultsEngineer = new CustomerDefaultsEngineer();
    InstructionEngineer instructionEngineer = new InstructionEngineer();
    MetadataGenerator metadataGenerator = new MetadataGenerator();


    public Order generatedOrderWithNoInstruction() {
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(validCustomerDefaults).build();
    }

    public Order generatedOrderWithABlankOrderRef(String attribute) {

        testData.setData(ORDER_REFERENCE, attribute);
        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(validCustomerDefaults).build();

    }

    public Order generateOrderWithAnInstruction() {

        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();


    }

    public Order generateOrderWithAnOutOfBoundsOrderRef(String attribute) {
        testData.setData(ORDER_REFERENCE, attribute);
        Instruction generatedInstruction;
        generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Order generateOrderWithAnAlphaNumericOrderReference(String attribute) {
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Order generateOrderWith50CharOrderRef() {
        String generatedOrderRef = Randomiser.customRandomAlphanumericString(50);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();

    }

    public Order generateOrderWithADuplicateOrderReference() {
        String duplicateOrderRef = testData.getData(ORDER_REFERENCE);

        Instruction generatedInstruction;
        generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(duplicateOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();


    }

    public Order generateAnOrderWithCustomNoOfInstructions(int noOfInstructions) {

        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);


        Instruction[] generatedInstruction = instructionEngineer.generateListOfInstructions(noOfInstructions);
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Arrays.asList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }


    public Order generateAnOrderWithCustomMetadataKeyLength(int customNumber) {
        String generatedOrderRef = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderRef);
        String generatedMetadataKey = Randomiser.customRandomAlphanumericString(customNumber);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();

        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadata(generatedMetadataKey))
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Order generateAnOrderWithCustomerMetadataValueLength(int customNumber) {
        String generatedOrderRef = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderRef);
        String generatedMetadataValue = Randomiser.customRandomAlphanumericString(customNumber);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();

        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateOrderMetadataWithCustomValue(generatedMetadataValue))
                .withCustomerDefaults(generatedCustomerDefaults).build();

    }

    public Order generateAnOrderWithDuplicatedMetadataKeys() {

        String generatedOrderRef = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderRef);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();

        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(metadataGenerator.generateDuplicateMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

}
