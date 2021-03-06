package imburse.model.builder.order;

import imburse.model.request.order.Order;


public class OrderDirector implements OrderPlan {

    private final OrderEngineer orderEngineer = new OrderEngineer();

    @Override
    public Order anOrderWithNoInstruction() {
        return orderEngineer.generatedOrderWithNoInstruction();
    }

    @Override
    public Order anOrderWithABlankOrderRef(String attribute) {
        return orderEngineer.generatedOrderWithABlankOrderRef(attribute);
    }

    @Override
    public Order anOrderWithAnInstruction() {
        return orderEngineer.generateOrderWithAnInstruction();
    }

    @Override
    public Order anOrderWithAnOutOfBoundsOrderRef(String attribute) {
        return orderEngineer.generateOrderWithAnOutOfBoundsOrderRef(attribute);
    }

    @Override
    public Order anOrderWithAnAlphaNumericOrderReference(String attribute) {
        return orderEngineer.generateOrderWithAnAlphaNumericOrderReference(attribute);
    }

    @Override
    public Order anOrderWith50CharOrderReference() {
        return orderEngineer.generateOrderWith50CharOrderRef();
    }

    @Override
    public Order anOrderWithADuplicateOrderReference() {
        return orderEngineer.generateOrderWithADuplicateOrderReference();
    }
    @Override
    public Order anOrderContainingCustomNoOfInstructions(int noOfInstructions) {
        return orderEngineer.generateAnOrderWithCustomNoOfInstructions(noOfInstructions);
    }

    @Override
    public Order anOrderWithCustomMetadataKeyLength(int customNumber) {
       return orderEngineer.generateAnOrderWithCustomMetadataKeyLength(customNumber);
    }

    @Override
    public Order anOrderWithCustomMetadataValueLength(int customNumber) {
       return orderEngineer.generateAnOrderWithCustomerMetadataValueLength(customNumber);
    }

    @Override
    public Order anOrderWithDuplicatedMetadataKeys() {
        return orderEngineer.generateAnOrderWithDuplicatedMetadataKeys();
    }


}
