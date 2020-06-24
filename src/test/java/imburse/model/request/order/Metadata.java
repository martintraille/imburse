package imburse.model.request.order;

public class Metadata {
    private String key1;
    private String key2;
    private String key3;

    public Metadata(String key1, String key2, String key3) {
        this.key1 = key1;
        this.key2 = key2;
        this.key3 = key3;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }


    public static final class MetadataBuilder {
        private String key1;
        private String key2;
        private String key3;

        private MetadataBuilder() {
        }

        public static MetadataBuilder aMetadata() {
            return new MetadataBuilder();
        }

        public MetadataBuilder withKey1(String key1) {
            this.key1 = key1;
            return this;
        }

        public MetadataBuilder withKey2(String key2) {
            this.key2 = key2;
            return this;
        }

        public MetadataBuilder withKey3(String key3) {
            this.key3 = key3;
            return this;
        }

        public Metadata build() {
            return new Metadata(key1, key2, key3);
        }
    }
}
