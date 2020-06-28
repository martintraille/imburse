package imburse.model.builder;

import imburse.model.request.order.Metadata;

public class InstructionMetadataEngineer {


    public Metadata generateValidInstructionMetadata() {

        Metadata newMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        return newMetadata;

    }
}
