package imburse.model.builder.order.customerdefaults.customerreference.customermetadata;

import imburse.model.request.order.CustomerReferenceMetadata;

import java.util.HashMap;
import java.util.Map;

public class CustomerRefMetadataEngineer {


    public CustomerReferenceMetadata generateCustRefMetadata() {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("Key100","Something");
        crmetadata.put("key200","Something else");

        return CustomerReferenceMetadata.CustomerReferenceMetadataBuilder.aCustomerReferenceMetadata()
                .withCustRefMetadataMap(crmetadata).build();
              //  .withKey1("NULL")
                //.withKey2("NULL")
                //.withKey3("NULL").build();
    }
}
