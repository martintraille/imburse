package imburse.model.request.order;

public class CustomerReference {

    public CustomerReference(String financialInstrumentId, String schemeId, CustomerReferenceMetadata Metadata) {
        this.financialInstrumentId = financialInstrumentId;
        this.schemeId = schemeId;
        this.metadata = Metadata;
    }

    private String financialInstrumentId = " ";
    private String schemeId = "";
    private CustomerReferenceMetadata metadata;

    public CustomerReferenceMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CustomerReferenceMetadata metadata) {
        this.metadata = metadata;
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


    public static final class CustomerReferenceBuilder {
        private String financialInstrumentId = " ";
        private String schemeId = "";
        private CustomerReferenceMetadata customerReferenceMetadata;

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

        public CustomerReferenceBuilder withCustomerReferenceMetadata(CustomerReferenceMetadata customerReferenceMetadata) {
            this.customerReferenceMetadata = customerReferenceMetadata;
            return this;
        }

        public CustomerReference build() {
            return new CustomerReference(financialInstrumentId, schemeId, customerReferenceMetadata);
        }
    }
}
