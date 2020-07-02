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

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }


    public static final class InstructionBuilder {
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

        private InstructionBuilder() {
        }

        public static InstructionBuilder anInstruction() {
            return new InstructionBuilder();
        }

        public InstructionBuilder withInstructionRef(String instructionRef) {
            this.instructionRef = instructionRef;
            return this;
        }

        public InstructionBuilder withCustomerRef(String customerRef) {
            this.customerRef = customerRef;
            return this;
        }

        public InstructionBuilder withDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public InstructionBuilder withFinancialInstrumentId(String financialInstrumentId) {
            this.financialInstrumentId = financialInstrumentId;
            return this;
        }

        public InstructionBuilder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public InstructionBuilder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public InstructionBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public InstructionBuilder withSettledByDate(String settledByDate) {
            this.settledByDate = settledByDate;
            return this;
        }

        public InstructionBuilder withSchemeId(String schemeId) {
            this.schemeId = schemeId;
            return this;
        }

        public InstructionBuilder withMetadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Instruction build() {
            return new Instruction(instructionRef, customerRef, direction, financialInstrumentId, amount, currency, country, settledByDate, schemeId, metadata);
        }
    }
}
