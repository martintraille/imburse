package imburse.model.request.order.builderpattern;

import imburse.model.request.order.CustomerDefaults;
import imburse.model.request.order.Instruction;
import imburse.model.request.order.Metadata;

import java.util.List;

public interface OrderPlan {


    public void setOrdersOrderRef(String orderRef);

    public void setOrdersOrderInstructions(List<Instruction> instructions);

    public void setOrdersOrderMetadata(Metadata metadata);

    public void setOrdersOrderCustomerDefaults(CustomerDefaults customerDefaults);


}
