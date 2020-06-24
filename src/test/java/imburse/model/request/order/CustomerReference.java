package imburse.model.request.order;

public class CustomerReference {
    public CustomerReference(String financialInstrumentId, String schemeId, Metadata metadata) {
        this.financialInstrumentId = financialInstrumentId;
        this.schemeId = schemeId;
        this.metadata = metadata;
    }

    private String financialInstrumentId;
    private String schemeId;
    private Metadata metadata;


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

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }







}
