package imburse.model.builder.order.customerdefaults.customerreference.customermetadata;

import imburse.model.request.order.CustomerReferenceMetadata;

public class CustomerRefMetadataEngineer {


    public CustomerReferenceMetadata generateCustRefMetadata() {

        return CustomerReferenceMetadata.CustomerReferenceMetadataBuilder.aCustomerReferenceMetadata()
                .withKey1("NULL")
                .withKey2("NULL")
                .withKey3("NULL").build();
    }
}
