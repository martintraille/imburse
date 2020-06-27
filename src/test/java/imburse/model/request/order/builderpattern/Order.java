package imburse.model.request.order.builderpattern;

import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;
import io.cucumber.java.bs.I;

import java.util.List;

public class Order implements OrderPlan {

    private String ordersOrderRef;
    private List <Instruction> ordersOrderInstructions;
    private Metadata ordersOrderMetadata;
    private CustomerDefaults ordersOrderCustomerDefaults;


    @Override
    public void setOrdersOrderRef(String orderRef) {

        ordersOrderRef = orderRef;

    }

    @Override
    public void setOrdersOrderInstructions(List<Instruction> instructions) {
        ordersOrderInstructions = instructions;
    }

    public String getOrdersOrderRef() {
        return ordersOrderRef;
    }


    @Override
    public void setOrdersOrderMetadata(Metadata metadata) {
        ordersOrderMetadata = metadata;
    }

    @Override
    public void setOrdersOrderCustomerDefaults(CustomerDefaults customerDefaults) {
        ordersOrderCustomerDefaults = customerDefaults;
    }


    public List<Instruction> getOrdersOrderInstructions(Instruction newInstruction) {
        return ordersOrderInstructions;
    }

    public Metadata getOrdersOrderMetadata() {
        return ordersOrderMetadata;
    }

    public CustomerDefaults getOrdersOrderCustomerDefaults() {
        return ordersOrderCustomerDefaults;
    }


}
