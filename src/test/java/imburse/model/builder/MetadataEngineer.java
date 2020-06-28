package imburse.model.builder;

import imburse.model.request.order.Metadata;

public class MetadataEngineer {

      public Metadata generateValidMetadata(){

          Metadata validMetadata = Metadata.MetadataBuilder.aMetadata()
                  .withKey1("TEST01")
                  .withKey2("TEST02")
                  .withKey3("TEST03").build();

          return validMetadata;
      }

}
