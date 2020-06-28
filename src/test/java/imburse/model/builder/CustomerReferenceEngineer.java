package imburse.model.builder;

import imburse.model.request.order.CustomerReference;
import imburse.model.request.order.CustomerReferenceMetadata;
import utilities.TestData;

import static utilities.TestData.DataKeys.SCHEMEID;



public class CustomerReferenceEngineer {

    CustomerRefMetadataEngineer customerRefMetadataEngineer = new CustomerRefMetadataEngineer();

 private TestData testData = new TestData();

    public CustomerReference generateValidCustomerReference() {

     CustomerReferenceMetadata validCustRefMetadata = customerRefMetadataEngineer.generateCustRefMetadata();

        CustomerReference validCustRef = CustomerReference.CustomerReferenceBuilder.aCustomerReference()
                .withFinancialInstrumentId("")
                .withSchemeId(testData.getData(SCHEMEID))
                .withCustomerReferenceMetadata(validCustRefMetadata)
                .build();

        return validCustRef;

    }
}
