package imburse.model.builder;

import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.CustomerReference;

public class CustomerDefaultsEngineer {

    CustomerReferenceEngineer customerReferenceEngineer = new CustomerReferenceEngineer();


    public CustomerDefaults generateValidCustomerDefaults() {
        CustomerReference validCustomerReference = customerReferenceEngineer.generateValidCustomerReference();

        CustomerDefaults validCustomerDefaults = CustomerDefaults.CustomerDefaultsBuilder.aCustomerDefaults()
                .withCustref1(validCustomerReference)
                .build();

        return validCustomerDefaults;
    }
}
