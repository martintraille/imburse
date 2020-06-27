package imburse.model.request.order.builderpattern;

public class OrderDirector {

private  OrderBuilder orderBuilder;

public OrderDirector(OrderBuilder orderBuilder){

    this.orderBuilder = orderBuilder;
}

public Order getOrder(){
    return this.orderBuilder.getOrder();
}

public void createOrder() {
    this.orderBuilder.buildOrdersOrderRef();
    this.orderBuilder.buildOrdersOrderInstructions();
    this.orderBuilder.buildOrdersOrderMetadata();
}

}
