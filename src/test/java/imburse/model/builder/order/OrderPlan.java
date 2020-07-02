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

    Order anOrderWith101MetadataValueCharacters();

    Order anOrderContainingCustomNoOfInstructions(int customNumber);


}
