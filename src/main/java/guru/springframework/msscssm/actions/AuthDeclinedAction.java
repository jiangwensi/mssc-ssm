package guru.springframework.msscssm.actions;

import guru.springframework.msscssm.domain.PaymentEvent;
import guru.springframework.msscssm.domain.PaymentState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * Created by Jiang Wensi on 9/11/2020
 */
@Component
public class AuthDeclinedAction implements Action<PaymentState, PaymentEvent>  {

    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("Sending Notification of AuthDeclinedAction");
    }
}
