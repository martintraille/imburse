package imburse.model.builder.order.instruction;

import imburse.model.request.order.Instruction;
import imburse.utilities.Randomiser;
import utilities.TestData;
import java.util.HashMap;
import java.util.Map;

import static utilities.TestData.DataKeys.SCHEMEID;

public class InstructionEngineer {

    private final TestData testData = new TestData();

    public Instruction generateValidInstruction() {

        return Instruction.InstructionBuilder.anInstruction()
                .withInstructionRef("A123124516")
                .withCustomerRef("13212412")
                .withDirection("CREDIT")
                .withFinancialInstrumentId(" ")
                .withAmount("5.00")
                .withCurrency("EUR")
                .withCountry("IE")
                .withSettledByDate("2020-07-21")
                .withSchemeId(testData.getData(SCHEMEID))
                .withMetadata(generateValidInstructionMetadata())
                .build();
    }

    public Instruction[] generateListOfInstructions(int noOfInstructions) {

        Instruction[] listOfInstructions = new Instruction[noOfInstructions];
        for (int i = 0; i < listOfInstructions.length; i++) {
            listOfInstructions[i] = Instruction.InstructionBuilder.anInstruction()
                    .withInstructionRef(Randomiser.customRandomAlphanumericString())
                    .withCustomerRef("13212412")
                    .withDirection("CREDIT")
                    .withFinancialInstrumentId(" ")
                    .withAmount("5.00")
                    .withCurrency("EUR")
                    .withCountry("IE")
                    .withSettledByDate("2020-07-21")
                    .withSchemeId(testData.getData(SCHEMEID))
                    .withMetadata(generateValidInstructionMetadata())
                    .build();
        }

        return listOfInstructions;
    }


    public Instruction generateInstructionWithBlankReference(String attribute) {

        return Instruction.InstructionBuilder.anInstruction()
                .withInstructionRef(attribute)
                .withCustomerRef("13212412")
                .withDirection("CREDIT")
                .withFinancialInstrumentId(" ")
                .withAmount("5.00")
                .withCurrency("EUR")
                .withCountry("IE")
                .withSettledByDate("2020-07-21")
                .withSchemeId("654EB81FF7F07F7CF5A1EE3FF6972E90")
                .withMetadata(generateValidInstructionMetadata())
                .build();
    }

    public Map<String, String> generateValidInstructionMetadata() {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("Key100", "Something");
        crmetadata.put("key200", "Something else");
        return crmetadata;
    }

}

