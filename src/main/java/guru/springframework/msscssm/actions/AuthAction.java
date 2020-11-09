package guru.springframework.msscssm.actions;

import guru.springframework.msscssm.domain.PaymentEvent;
import guru.springframework.msscssm.domain.PaymentState;
import guru.springframework.msscssm.services.PaymentServiceImpl;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Jiang Wensi on 9/11/2020
 */
@Component
public class AuthAction  implements Action<PaymentState, PaymentEvent>  {

    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("AuthAction");
        if (new Random().nextInt(10) < 8) {
            System.out.println("AUTH_APPROVED");
            context.getStateMachine()
                    .sendEvent(MessageBuilder
                            .withPayload(PaymentEvent.AUTH_APPROVED)
                            .setHeader(PaymentServiceImpl.PAYMENT_ID_HEADER,
                                    context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER))
                            .build());
        } else {
            System.out.println("AUTH_DECLINED");
            context.getStateMachine()
                    .sendEvent(MessageBuilder
                            .withPayload(PaymentEvent.AUTH_DECLINED)
                            .setHeader(PaymentServiceImpl.PAYMENT_ID_HEADER,
                                    context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER))
                            .build());
        }
    }
}
