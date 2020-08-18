package imburse.tasks.callendpoints;

import imburse.model.request.order.RequestBody;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import utilities.TestData;

import static utilities.TestData.DataKeys.*;

public class Api {

    @Steps
    private TestData testData;

    @Steps
    private Post post;

    @Steps
    private Get get;


    public void call(String apiVersion, String endpoint, RequestBody body) {
        switch (endpoint) {
            case "/mandates":
                String api = apiVersion + "/mandates";
                post.to(api, body);
                break;
        }

    }

    public void call(String apiVersion, String endpoint) {
        switch (endpoint) {
            case "/mandates":
                String api = apiVersion + "/mandates";
                get.from(api);
                break;

        }


    }

}
