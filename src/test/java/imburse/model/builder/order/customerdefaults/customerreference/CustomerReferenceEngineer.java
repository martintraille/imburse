package imburse.model.builder.order.customerdefaults.customerreference;

import imburse.model.builder.order.customerdefaults.customerreference.customermetadata.CustomerRefMetadataEngineer;
import imburse.model.request.order.CustomerReference;
import imburse.model.request.order.CustomerReferenceMetadata;
import utilities.TestData;

import static utilities.TestData.DataKeys.SCHEMEID;



public class CustomerReferenceEngineer {

    CustomerRefMetadataEngineer customerRefMetadataEngineer = new CustomerRefMetadataEngineer();

 private final TestData testData = new TestData();

    public CustomerReference generateValidCustomerReference() {

     CustomerReferenceMetadata validCustRefMetadata = customerRefMetadataEngineer.generateCustRefMetadata();

        return CustomerReference.CustomerReferenceBuilder.aCustomerReference()
                .withFinancialInstrumentId("")
                .withSchemeId(testData.getData(SCHEMEID))
                .withCustomerReferenceMetadata(validCustRefMetadata)
                .build();


    }
}
