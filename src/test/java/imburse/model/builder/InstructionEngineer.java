package imburse.model.builder;

import imburse.model.request.order.CustomerReferenceMetadata;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;

import java.util.List;

public class InstructionEngineer {

    InstructionMetadataEngineer instructionMetadataEngineer = new InstructionMetadataEngineer();

    public Instruction generateValidInstruction() {

        Metadata validInstructionMetadata = instructionMetadataEngineer.generateValidInstructionMetadata();

      Instruction validInstruction = Instruction.InstructionBuilder.anInstruction()
                .withInstructionRef("A123124516")
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


      return validInstruction;
    }
}
