
package imburse.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class AuthenticationSteps {

    private EnvironmentVariables environmentVariables;


    public static String generatesHmac() throws UnsupportedEncodingException {
        String publicKey = "bfaa9a45-5c5a-4bbc-b353-eb6989486c87";
        String privateKey = "x7uNykwHN3F4ATXMqVcWcCqrc2PnNId7mZ0Ei6IfIMY=";

        byte[] privateKeyBytes = Base64.decodeBase64(privateKey);
        String bodySignature = "";
        long timestamp = new Date().getTime() / 1000;
        long nonce = timestamp;
        String unsignedSignauture = publicKey + ":" + nonce + ":" + timestamp + ":" + bodySignature;

        System.out.println("Unsigned Sig is: " + unsignedSignauture);

        byte[] utf8Signature = unsignedSignauture.getBytes("UTF-8");
        byte[] hashedSignature = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_256, privateKeyBytes).doFinal(utf8Signature);
        String signedSignature = new String(Base64.encodeBase64(hashedSignature));

        String hmac = publicKey + ":" + nonce + ":" + timestamp + ":" + signedSignature;

        System.out.println("Hmac is: " + hmac);

        return hmac;
    }


    public String getResponseBody() {
        String response = lastResponse().getBody().asString();
        return response;
    }


    public String getAccessToken() {
        String accessToken = SerenityRest.lastResponse().jsonPath().getString("accessToken");
        return accessToken;
    }

    public String getStatusCode() {
        String statusCode = SerenityRest.lastResponse().getStatusLine();
        System.out.println("****STATSCODE IS****" + statusCode);
        return statusCode;
    }


}

