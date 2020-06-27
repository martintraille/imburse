package imburse.model.request.order.builderpattern;

public interface OrderBuilder {

    public void buildOrdersOrderRef();
    public void buildOrdersOrderInstructions();
    public void buildOrdersOrderMetadata();
    public void buildOrdersCustomerDefaults();

    public Order getOrder();

}
