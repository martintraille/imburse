package imburse.model.builder.order.instruction;

import imburse.model.request.order.Metadata;

import java.util.HashMap;
import java.util.Map;

public class InstructionMetadataEngineer {


    public Metadata generateValidInstructionMetadata() {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("Key100","Something");
        crmetadata.put("key200","Something else");

        return Metadata.MetadataBuilder.aMetadata()
                .withCustRefMetadataMap(crmetadata).build();
               // .withKey1("TEST01")
//                .withKey2("TEST02")
//                .withKey3("TEST03").build();

    }
}
