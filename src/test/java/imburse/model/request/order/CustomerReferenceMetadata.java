package imburse.model.request.order;


import java.util.HashMap;
import java.util.Map;

public class CustomerReferenceMetadata {

//    private String key1;
//    private String key2;
//    private String key3;

    Map<String, String> custRefMetadataMap = new HashMap<>();


 //   public CustomerReferenceMetadata (//String key1, String key2, String key3) {
    public CustomerReferenceMetadata (Map<String, String> custRefMetadataMap) {
        this.custRefMetadataMap = custRefMetadataMap;
      //  this.key2 = key2;
      //  this.key3 = key3;
    }

    public static final class CustomerReferenceMetadataBuilder {
        Map<String, String> custRefMetadataMap = new HashMap<>();

        private CustomerReferenceMetadataBuilder() {
        }

        public static CustomerReferenceMetadataBuilder aCustomerReferenceMetadata() {
            return new CustomerReferenceMetadataBuilder();
        }

        public CustomerReferenceMetadataBuilder withCustRefMetadataMap(Map<String, String> custRefMetadataMap) {
            this.custRefMetadataMap = custRefMetadataMap;
            return this;
        }

        public CustomerReferenceMetadata build() {
            return new CustomerReferenceMetadata(custRefMetadataMap);
        }
    }


//    public static final class CustomerReferenceMetadataBuilder {
//        private Map<String, String> custRefMetadataMap = new HashMap<>();
////        private String key1;
////        private String key2;
////        private String key3;
//
//        private CustomerReferenceMetadataBuilder() {
//        }
//
//        public static CustomerReferenceMetadataBuilder aCustomerReferenceMetadata() {
//            return new CustomerReferenceMetadataBuilder();
//        }
//
//        public CustomerReferenceMetadataBuilder withKey1(String key1) {
//            this.key1 = key1;
//            return this;
//        }
//
//        public CustomerReferenceMetadataBuilder withKey2(String key2) {
//            this.key2 = key2;
//            return this;
//        }
//
//        public CustomerReferenceMetadataBuilder withKey3(String key3) {
//            this.key3 = key3;
//            return this;
//        }
//
//        public CustomerReferenceMetadata build() {
//            return new CustomerReferenceMetadata(key1, key2, key3);
//        }
//    }
}

