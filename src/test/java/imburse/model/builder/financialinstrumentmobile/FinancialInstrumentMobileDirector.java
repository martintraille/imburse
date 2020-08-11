package imburse.model.builder.financialinstrumentmobile;

import imburse.model.request.financialinstrumentcreation.FinancialInstrumentMobile;

public class FinancialInstrumentMobileDirector implements FinancialInstrumentMobilePlan {

    private final FinancialInstrumentMobileEngineer financialInstrumentMobileEngineer = new FinancialInstrumentMobileEngineer();

    @Override
    public FinancialInstrumentMobile aValidFinancialInstrumentMobile(String countryCode, String phoneNumber) {
        return financialInstrumentMobileEngineer.generateValidFinancialInstrumentMobile(countryCode, phoneNumber);
    }
}
