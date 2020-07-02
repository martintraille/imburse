package imburse.model.builder.order.metadata;

import imburse.model.request.order.Metadata;

public class MetadataEngineer {

    public Metadata generateValidMetadata() {

        return Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();
    }

    public Metadata generateMetadataWith101CharValue(String metadataValue) {

        return Metadata.MetadataBuilder.aMetadata()
                .withKey1(metadataValue)
                .withKey2("TEST02")
                .withKey3("TEST03").build();

    }
}
