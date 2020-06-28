package imburse.model.builder;

import imburse.model.request.order.CustomerReferenceMetadata;

public class CustomerRefMetadataEngineer {


    private CustomerReferenceMetadata validCustRefMetadata;

    public CustomerReferenceMetadata generateCustRefMetadata() {

         validCustRefMetadata = CustomerReferenceMetadata.CustomerReferenceMetadataBuilder.aCustomerReferenceMetadata()
                .withKey1("NULL")
                .withKey2("NULL")
                .withKey3("NULL").build();

        return validCustRefMetadata;
    }
}
