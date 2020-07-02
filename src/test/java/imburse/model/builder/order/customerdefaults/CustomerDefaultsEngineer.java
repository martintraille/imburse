package imburse.model.builder.order.customerdefaults;

import imburse.model.builder.order.customerdefaults.customerreference.CustomerReferenceEngineer;
import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.CustomerReference;

public class CustomerDefaultsEngineer {

    CustomerReferenceEngineer customerReferenceEngineer = new CustomerReferenceEngineer();


    public CustomerDefaults generateValidCustomerDefaults() {
        CustomerReference validCustomerReference = customerReferenceEngineer.generateValidCustomerReference();

        return CustomerDefaults.CustomerDefaultsBuilder.aCustomerDefaults()
                .withCustref1(validCustomerReference)
                .build();

    }
}
