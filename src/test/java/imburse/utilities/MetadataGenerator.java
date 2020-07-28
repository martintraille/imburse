package imburse.utilities;

import java.util.HashMap;
import java.util.Map;

public class MetadataGenerator {

    public Map<String, String> generateOrderMetadata() {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("Key1", "Something");
        crmetadata.put("key2", "Something else");
        return crmetadata;
    }

    public Map<String, String> generateOrderMetadata(String key) {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put(key, "Something");
        crmetadata.put("key2", "Something else");
        return crmetadata;
    }

    public Map<String, String> generateOrderMetadataWithCustomValue(String value) {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("key1", value);
        crmetadata.put("key2", "Something else");
        return crmetadata;
    }

    public Map<String, String> generateDuplicateMetadata() {
        Map<String, String> crmetadata = new HashMap<>();
        crmetadata.put("AIS Insurance1", "Something");
        crmetadata.put("AIS Insurance", "Something");
        return crmetadata;
    }

}
