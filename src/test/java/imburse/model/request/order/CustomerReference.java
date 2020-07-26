package imburse.model.request.order;

import java.util.HashMap;
import java.util.Map;

public class CustomerReference {

    public CustomerReference(String financialInstrumentId, String schemeId, Map<String,String> Metadata) {
        this.financialInstrumentId = financialInstrumentId;
        this.schemeId = schemeId;
        this.metadata = Metadata;
    }

    private String financialInstrumentId = " ";
    private String schemeId = "";
    private Map<String, String> metadata = new HashMap<>();

   // public CustomerReferenceMetadata getMetadata() {
     //   return metadata;
    //}

    //public void setMetadata(CustomerReferenceMetadata metadata) {
      //  this.metadata = metadata;
    //}

    public static final class CustomerReferenceBuilder {

        private String financialInstrumentId = " ";
        private String schemeId = "";
        private Map<String, String> metadata = new HashMap<>();

        private CustomerReferenceBuilder() {
        }

        public static CustomerReferenceBuilder aCustomerReference() {
            return new CustomerReferenceBuilder();
        }

        public CustomerReferenceBuilder withFinancialInstrumentId(String financialInstrumentId) {
            this.financialInstrumentId = financialInstrumentId;
            return this;
        }

        public CustomerReferenceBuilder withSchemeId(String schemeId) {
            this.schemeId = schemeId;
            return this;
        }

        public CustomerReferenceBuilder withMetadata(Map<String, String> metadata) {
            this.metadata = metadata;
            return this;
        }

        public CustomerReference build() {
            CustomerReference customerReference = new CustomerReference(financialInstrumentId, schemeId, metadata);
           // customerReference.setMetadata(metadata);
            return customerReference;
        }

        public String getFinancialInstrumentId() {
            return financialInstrumentId;
        }

        public void setFinancialInstrumentId(String financialInstrumentId) {
            this.financialInstrumentId = financialInstrumentId;
        }

        public String getSchemeId() {
            return schemeId;
        }

        public void setSchemeId(String schemeId) {
            this.schemeId = schemeId;
        }

        public Map<String, String> getMetadata() {
            return metadata;
        }

        public void setMetadata(Map<String, String> metadata) {
            this.metadata = metadata;
        }
    }


//    public static final class CustomerReferenceBuilder {
//        private String financialInstrumentId = " ";
//        private String schemeId = "";
//        private CustomerReferenceMetadata customerReferenceMetadata;
//
//        private CustomerReferenceBuilder() {
//        }
//
//        public static CustomerReferenceBuilder aCustomerReference() {
//            return new CustomerReferenceBuilder();
//        }
//
//        public CustomerReferenceBuilder withFinancialInstrumentId(String financialInstrumentId) {
//            this.financialInstrumentId = financialInstrumentId;
//            return this;
//        }
//
//        public CustomerReferenceBuilder withSchemeId(String schemeId) {
//            this.schemeId = schemeId;
//            return this;
//        }
//
//        public CustomerReferenceBuilder withCustomerReferenceMetadata(CustomerReferenceMetadata customerReferenceMetadata) {
//            this.customerReferenceMetadata = customerReferenceMetadata;
//            return this;
//        }
//
//        public CustomerReference build() {
//            return new CustomerReference(financialInstrumentId, schemeId, customerReferenceMetadata);
//        }
//    }
}
