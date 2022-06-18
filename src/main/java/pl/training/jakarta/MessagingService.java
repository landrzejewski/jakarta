package pl.training.jakarta;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "Messages"),
})
public class MessagingService implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            var payload = message.getBody(ChatMessage.class);
            System.out.println("New message: %s".formatted(payload.getText()));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("%s: postConstruct".formatted(getClass().getSimpleName()));
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("%s: preDestroy".formatted(getClass().getSimpleName()));
    }

}
