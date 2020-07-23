package imburse.model.builder.order.metadata;

import imburse.model.request.order.Metadata;

import java.util.HashMap;
import java.util.Map;

public class MetadataEngineer {

    public Metadata generateValidMetadata() {

        final Map<String,String> myMap;
        myMap = new HashMap<String,String>();
        myMap.put("Key100","Hello");

        return Metadata.MetadataBuilder.aMetadata()
                .withKey1(myMap)
                .withKey2("TEST02")
                .withKey3("TEST03").build();
    }

    public Metadata generateMetadataWith101CharValue(String metadataValue) {

        return Metadata.MetadataBuilder.aMetadata()
              //  .withKey1(metadataValue)
                .withKey2("TEST02")
                .withKey3("TEST03").build();

    }
}
