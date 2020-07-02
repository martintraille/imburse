package imburse.model.request.order;

public class CustomerDefaults {


    private final CustomerReference custref1;
    private final CustomerReference custref2;
    private final CustomerReference custref3;

    public CustomerDefaults(CustomerReference custref1, CustomerReference custref2, CustomerReference custref3) {
        this.custref1 = custref1;
        this.custref2 = custref2;
        this.custref3 = custref3;
    }



    public static final class CustomerDefaultsBuilder {
        private CustomerReference custref1;
        private CustomerReference custref2;
        private CustomerReference custref3;

        private CustomerDefaultsBuilder() {
        }

        public static CustomerDefaultsBuilder aCustomerDefaults() {
            return new CustomerDefaultsBuilder();
        }

        public CustomerDefaultsBuilder withCustref1(CustomerReference custref1) {
            this.custref1 = custref1;
            return this;
        }

        public CustomerDefaultsBuilder withCustref2(CustomerReference custref2) {
            this.custref2 = custref2;
            return this;
        }

        public CustomerDefaultsBuilder withCustref3(CustomerReference custref3) {
            this.custref3 = custref3;
            return this;
        }

        public CustomerDefaults build() {
            return new CustomerDefaults(custref1, custref2, custref3);
        }
    }
}
