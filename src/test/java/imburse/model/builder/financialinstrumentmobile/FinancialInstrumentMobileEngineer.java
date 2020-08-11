package imburse.model.builder.financialinstrumentmobile;

import imburse.model.request.financialinstrumentcreation.FinancialInstrumentMobile;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

public class FinancialInstrumentMobileEngineer {
    @Steps(shared = true)
    private final TestData testData = new TestData();

    public FinancialInstrumentMobile generateValidFinancialInstrumentMobile(String countryCode, String phoneNumber) {

        return FinancialInstrumentMobile.FinancialInstrumentMobileBuilder.aFinancialInstrumentMobile()
                .withCountryCode(countryCode)
                .withPhoneNumber(phoneNumber)
                .build();
    }


}
