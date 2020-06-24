package imburse.model.request.order;

public class Instruction {
    private String instructionRef;
    private String customerRef;
    private String direction;
    private String financialInstrumentId;
    private String amount;
    private String currency;
    private String country;
    private String settledByDate;
    private String schemeId;



    private Metadata metadata;

    public Instruction(String instructionRef, String customerRef, String direction, String financialInstrumentId, String amount, String currency,
                       String country, String settledByDate, String schemeId, Metadata metadata) {
        this.instructionRef = instructionRef;
        this.customerRef = customerRef;
        this.direction = direction;
        this.financialInstrumentId = financialInstrumentId;
        this.amount = amount;
        this.currency = currency;
        this.country = country;
        this.settledByDate = settledByDate;
        this.schemeId = schemeId;
        this.metadata = metadata;

    }


    public String getInstructionRef() {
        return instructionRef;
    }

    public void setInstructionRef(String instructionRef) {
        this.instructionRef = instructionRef;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFinancialInstrumentId() {
        return financialInstrumentId;
    }

    public void setFinancialInstrumentId(String financialInstrumentId) {
        this.financialInstrumentId = financialInstrumentId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSettledByDate() {
        return settledByDate;
    }

    public void setSettledByDate(String settledByDate) {
        this.settledByDate = settledByDate;
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
