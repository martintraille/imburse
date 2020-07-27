package imburse.model.builder.order;

import imburse.model.builder.order.customerdefaults.CustomerDefaultsEngineer;
import imburse.model.builder.order.instruction.InstructionEngineer;
import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Order;
import imburse.utilities.Randomiser;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static utilities.TestData.DataKeys.ORDER_REFERENCE;


public class OrderEngineer {

    @Steps(shared = true)
    private final TestData testData = new TestData();

    CustomerDefaultsEngineer customerDefaultsEngineer = new CustomerDefaultsEngineer();
    InstructionEngineer instructionEngineer = new InstructionEngineer();


    public Order generatedOrderWithNoInstruction() {
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withMetadata(generateValidOrderMetadata())
                .withCustomerDefaults(validCustomerDefaults).build();
    }

    public Order generatedOrderWithABlankOrderRef(String attribute) {

        testData.setData(ORDER_REFERENCE, attribute);
        CustomerDefaults validCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withMetadata(generateValidOrderMetadata())
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
                .withMetadata(generateValidOrderMetadata())
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
                .withMetadata(generateValidOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Order generateOrderWithAnAlphaNumericOrderReference(String attribute) {
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(attribute)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generateValidOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Order generateOrderWith50CharOrderRef() {
        String generatedOrderRef = Randomiser.customRandomAlphanumericString(50);
        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderRef)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generateValidOrderMetadata())
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
                .withMetadata(generateValidOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();


    }

    public Order generateOrderWith101MetadataValueCharacters() {
        String generatedOrderref = Randomiser.customRandomAlphanumericString();
        testData.setData(ORDER_REFERENCE, generatedOrderref);

        Instruction generatedInstruction = instructionEngineer.generateValidInstruction();
        CustomerDefaults generatedCustomerDefaults = customerDefaultsEngineer.generateValidCustomerDefaults();


        return Order.OrderBuilder.anOrder()
                .withOrderRef(generatedOrderref)
                .withInstructions(Collections.singletonList(generatedInstruction))
                .withMetadata(generateValidOrderMetadata())
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
                .withMetadata(generateValidOrderMetadata())
                .withCustomerDefaults(generatedCustomerDefaults).build();
    }

    public Map<String, String> generateValidOrderMetadata() {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("Key1", "Something");
        crmetadata.put("key2", "Something else");
        return crmetadata;
    }

}
