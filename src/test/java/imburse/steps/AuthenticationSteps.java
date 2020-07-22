
package imburse.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class AuthenticationSteps {

    private EnvironmentVariables environmentVariables;


    public static String generatesHmac(String publicKey, String privateKey) {
     //   String publicKey = "060d457f-2d25-4757-8267-cce6541684ae";
       // String privateKey = "vlObNvrqT0MoyuNxg1b53lSKjvtNyEy9VQl3eyz7rVA";

        byte[] privateKeyBytes = Base64.decodeBase64(privateKey);
        String bodySignature = "";
        long timestamp = new Date().getTime() / 1000;
        long nonce = timestamp;
        String unsignedSignature = publicKey + ":" + nonce + ":" + timestamp + ":" + bodySignature;

        System.out.println("Unsigned Sig is: " + unsignedSignature);

        byte[] utf8Signature = unsignedSignature.getBytes(StandardCharsets.UTF_8);
        byte[] hashedSignature = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, privateKeyBytes).doFinal(utf8Signature);
        String signedSignature = new String(Base64.encodeBase64(hashedSignature));

        String hmac = publicKey + ":" + nonce + ":" + timestamp + ":" + signedSignature;

        System.out.println("Hmac is: " + hmac);

        return hmac;
    }


    public String getResponseBody() {
        return lastResponse().getBody().asString();
    }


    public String getAccessToken() {
        return SerenityRest.lastResponse().jsonPath().getString("accessToken");
    }

    public String getStatusCode() {
        String statusCode = SerenityRest.lastResponse().getStatusLine();
        System.out.println("****STATUSCODE IS****" + statusCode);
        return statusCode;
    }


}

