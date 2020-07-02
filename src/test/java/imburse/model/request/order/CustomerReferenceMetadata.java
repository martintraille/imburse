package imburse.model.request.order;



public class CustomerReferenceMetadata {

    private String key1;
    private String key2;
    private String key3;

    public CustomerReferenceMetadata (String key1, String key2, String key3) {
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }


    public static final class CustomerReferenceMetadataBuilder {
        private String key1;
        private String key2;
        private String key3;

        private CustomerReferenceMetadataBuilder() {
        }

        public static CustomerReferenceMetadataBuilder aCustomerReferenceMetadata() {
            return new CustomerReferenceMetadataBuilder();
        }

        public CustomerReferenceMetadataBuilder withKey1(String key1) {
            this.key1 = key1;
            return this;
        }

        public CustomerReferenceMetadataBuilder withKey2(String key2) {
            this.key2 = key2;
            return this;
        }

        public CustomerReferenceMetadataBuilder withKey3(String key3) {
            this.key3 = key3;
            return this;
        }

        public CustomerReferenceMetadata build() {
            return new CustomerReferenceMetadata(key1, key2, key3);
        }
    }
}

