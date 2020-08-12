package utilities;

import lombok.NoArgsConstructor;
import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@NoArgsConstructor
public class TestData {

    private static Logger logger = LoggerFactory.getLogger(TestData.class);

    public <T> void setData(DataKeys key, T value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public <T> T getData(DataKeys key) {
        return Serenity.sessionVariableCalled(key);
    }

    private boolean keyExist(DataKeys key) {
        return Serenity.hasASessionVariableCalled(key);
    }

    private boolean keyNotExist(DataKeys key) {
        return !Serenity.hasASessionVariableCalled(key);
    }

    public boolean dataExist(DataKeys key) {
        return keyExist(key) && Objects.nonNull(getData(key));
    }

    public enum DataKeys {
        ACCOUNT_PORTAL_URL,
        TENANT_PORTAL_URL,
        TENANT_PORTAL_EMAIL_ADDRESS,
        TENANT_PORTAL_PASSWORD,
        SINGLE_TENANT_PORTAL_EMAIL_ADDRESS,
        SINGLE_TENANT_PORTAL_PASSWORD,
        ACCOUNT_PORTAL_EMAIL_ADDRESS,
        ACCOUNT_PORTAL_PASSWORD,
        SCENARIO,
        ACCOUNTID,
        TENANTID,
        ACCESS_TOKEN,
        SCHEMEID,
        PUBLICKEY,
        PRIVATEKEY,
        EXPECTED_STATUS_CODE,
        EXPECTED_STATUS_CODE_MESSAGE,
        ORDER_REFERENCE,
    }

}
