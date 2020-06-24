package imburse.model.request.order;

import java.util.List;

public class Order {

    public Order(String orderRef, List<Instruction> instructions, Metadata metadata, CustomerDefaults customerDefaults) {
        this.orderRef = orderRef;
        this.instructions = instructions;
        this.metadata = metadata;
        this.customerDefaults = customerDefaults;
    }

    private String orderRef;
    private List<Instruction> instructions;
    private Metadata metadata;
    private CustomerDefaults customerDefaults;

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public CustomerDefaults getCustomerDefaults() {
        return customerDefaults;
    }

    public void setCustomerDefaults(CustomerDefaults customerDefaults) {
        this.customerDefaults = customerDefaults;
    }

    public static final class OrderBuilder {
        private String orderRef;
        private List<Instruction> instructions;
        private Metadata metadata;
        private CustomerDefaults customerDefaults;

        private OrderBuilder() {
        }

        public static OrderBuilder anOrder() {
            return new OrderBuilder();
        }

        public OrderBuilder withOrderRef(String orderRef) {
            this.orderRef = orderRef;
            return this;
        }

        public OrderBuilder withInstructions(List<Instruction> instructions) {
            this.instructions = instructions;
            return this;
        }

        public OrderBuilder withMetadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public OrderBuilder withCustomerDefaults(CustomerDefaults customerDefaults) {
            this.customerDefaults = customerDefaults;
            return this;
        }

        public Order build() {
            return new Order(orderRef, instructions, metadata, customerDefaults);
        }


    }
}
