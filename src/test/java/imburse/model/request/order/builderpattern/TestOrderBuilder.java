package imburse.model.request.order.builderpattern;

public class TestOrderBuilder {

    public static void main(String[] args){


        OrderBuilder happyOrder = new HappyOrderBuilder();

        OrderDirector orderDirector = new OrderDirector(happyOrder);

        orderDirector.createOrder();

        Order generatedHappyOrder = orderDirector.getOrder();

        System.out.println("Order built " + generatedHappyOrder.toString());


        System.out.println("Order ref:  "  + generatedHappyOrder.getOrdersOrderRef());
      //  System.out.println("Instructions:  "  + generatedHappyOrder.getOrdersOrderInstructions().);
        System.out.println("Order MetaData:  "  + generatedHappyOrder.getOrdersOrderMetadata().getKey1());
        System.out.println("Customer Defaults:  "  + generatedHappyOrder.getOrdersOrderCustomerDefaults().getCustref1());
    }
}
