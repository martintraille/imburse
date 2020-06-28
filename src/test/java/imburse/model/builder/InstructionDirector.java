package imburse.model.builder;

import imburse.model.request.order.Instruction;

public class InstructionDirector {

    private InstructionEngineer instructionEngineer = new InstructionEngineer();

    public Instruction aValidInstruction() {
        return instructionEngineer.generateValidInstruction();
    }


    public Instruction anInstructionWithABlankReference(String attribute) {

        return instructionEngineer.generateInstructionWithBlankReference(attribute);
    }
}
