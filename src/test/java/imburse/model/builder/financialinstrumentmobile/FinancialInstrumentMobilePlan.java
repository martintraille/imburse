package imburse.model.builder.financialinstrumentmobile;

import imburse.model.request.financialinstrumentcreation.FinancialInstrumentMobile;

public interface FinancialInstrumentMobilePlan {


    FinancialInstrumentMobile aValidFinancialInstrumentMobile(String countryCode, String mobileNumber);


}
