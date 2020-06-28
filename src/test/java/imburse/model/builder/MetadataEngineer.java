package imburse.model.builder;

import imburse.model.request.order.Metadata;

public class MetadataEngineer {

    public Metadata generateValidMetadata() {

        Metadata validMetadata = Metadata.MetadataBuilder.aMetadata()
                .withKey1("TEST01")
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        return validMetadata;
    }

    public Metadata generateMetadataWith101CharValue(String metadataValue) {

        Metadata metadataWith101CharValue = Metadata.MetadataBuilder.aMetadata()
                .withKey1(metadataValue)
                .withKey2("TEST02")
                .withKey3("TEST03").build();

        return metadataWith101CharValue;

    }
}
