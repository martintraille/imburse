package imburse.model.builder.order.instruction;

import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import imburse.utilities.Randomiser;
import utilities.TestData;

import static utilities.TestData.DataKeys.SCHEMEID;

public class InstructionEngineer {

    InstructionMetadataEngineer instructionMetadataEngineer = new InstructionMetadataEngineer();
    private final TestData testData = new TestData();

    public Instruction generateValidInstruction() {

        Metadata validInstructionMetadata = instructionMetadataEngineer.generateValidInstructionMetadata();


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
                .withMetadata(validInstructionMetadata)
                .build();
    }

    public Instruction[] generateListOfInstructions(int noOfInstructions) {
        Metadata validInstructionMetadata = instructionMetadataEngineer.generateValidInstructionMetadata();

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
                    .withMetadata(validInstructionMetadata)
                    .build();
        }

        return listOfInstructions;
    }


    public Instruction generateInstructionWithBlankReference(String attribute) {

        Metadata validInstructionMetadata = instructionMetadataEngineer.generateValidInstructionMetadata();


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
                .withMetadata(validInstructionMetadata)
                .build();
    }

}

