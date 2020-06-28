package imburse.model.builder;

import imburse.model.request.order.Order;


public class OrderDirector {

    private OrderEngineer orderEngineer = new OrderEngineer();

    public Order anOrderWithNoInstruction() {
        return orderEngineer.generatedOrderWithNoInstruction();
    }

    public Order anOrderWithABlankOrderRef(String attribute) {
        return orderEngineer.generatedOrderWithABlankOrderRef(attribute);
    }

    public Order anOrderWithAnInstruction() {
        return orderEngineer.generateOrderWithAnInstruction();
    }

    public Order anOrderWithAnOutOfBoundsOrderRef(String attribute) {
        return orderEngineer.generateOrderWithAnOutOfBoundsOrderRef(attribute);
    }

    public Order anOrderWithAnAlphaNumericOrderReference(String attribute) {
        return orderEngineer.generateOrderWithAnAlphaNumericOrderReference(attribute);
    }

    public Order anOrderWith50CharOrderReference() {
        return orderEngineer.generateOrderWith50CharOrderRef();
    }

    public Order anOrderWithADuplicateOrderReference() {
        return orderEngineer.generateOrderWithADuplicateOrderReference();
    }

    public Order anOrderWith101MetadataValueCharacters() {
        return orderEngineer.generateOrderWith101MetadataValueCharacters();
    }

    public Order anOrderContaining100Instructions() {
        return orderEngineer.generateAnOrderWith100Instructions();
    }

    //TODO Refactor this!!
    public Order anOrderContaining101Instructions() {
        return orderEngineer.generateAnOrderWith101Instructions();
    }

}
