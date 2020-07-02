package imburse.model.builder.order.instruction;

import imburse.model.request.order.Metadata;

public class InstructionMetadataEngineer {


    public Metadata generateValidInstructionMetadata() {

        return Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

    }
}
