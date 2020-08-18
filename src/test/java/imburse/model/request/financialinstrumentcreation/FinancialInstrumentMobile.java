package imburse.model.request.financialinstrumentcreation;

public class FinancialInstrumentMobile {

    private String countryCode;
    private String phoneNumber;

    public FinancialInstrumentMobile(String countryCode, String phoneNumber) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static final class FinancialInstrumentMobileBuilder {
        private String countryCode;
        private String phoneNumber;

        private FinancialInstrumentMobileBuilder() {
        }

        public static FinancialInstrumentMobileBuilder aFinancialInstrumentMobile() {
            return new FinancialInstrumentMobileBuilder();
        }

        public FinancialInstrumentMobileBuilder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public FinancialInstrumentMobileBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public FinancialInstrumentMobile build() {
            return new FinancialInstrumentMobile(countryCode, phoneNumber);
        }
    }
}
