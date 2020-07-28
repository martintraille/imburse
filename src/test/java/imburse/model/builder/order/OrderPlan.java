package imburse.model.builder.order;

import imburse.model.request.order.Order;

public interface OrderPlan {

    Order anOrderWithNoInstruction();

    Order anOrderWithABlankOrderRef(String attribute);

    Order anOrderWithAnInstruction();

    Order anOrderWithAnOutOfBoundsOrderRef(String attribute);

    Order anOrderWithAnAlphaNumericOrderReference(String attribute);

    Order anOrderWith50CharOrderReference();

    Order anOrderWithADuplicateOrderReference();

    Order anOrderContainingCustomNoOfInstructions(int customNumber);

    Order anOrderWithCustomMetadataKeyLength (int customNumber);

    Order anOrderWithCustomMetadataValueLength (int customNumber);

    Order anOrderWithDuplicatedMetadataKeys();


}
