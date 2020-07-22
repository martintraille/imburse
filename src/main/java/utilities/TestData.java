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
