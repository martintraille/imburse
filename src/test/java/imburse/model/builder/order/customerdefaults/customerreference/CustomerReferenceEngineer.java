package imburse.model.builder.order.customerdefaults.customerreference;


import imburse.model.request.order.CustomerReference;
import utilities.TestData;

import java.util.HashMap;
import java.util.Map;

import static utilities.TestData.DataKeys.SCHEMEID;


public class CustomerReferenceEngineer {


    private final TestData testData = new TestData();

    public CustomerReference generateValidCustomerReference() {

        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("Key1", "Something");
        crmetadata.put("key2", "Something else");

        return CustomerReference.CustomerReferenceBuilder.aCustomerReference()
                .withFinancialInstrumentId("")
                .withSchemeId(testData.getData(SCHEMEID))
                .withMetadata(crmetadata)
                .build();


    }
}
