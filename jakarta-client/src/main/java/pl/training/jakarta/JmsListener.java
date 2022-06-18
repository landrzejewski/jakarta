package pl.training.jakarta;

import javax.jms.*;
import javax.naming.NamingException;
import java.util.Scanner;

public class JmsListener {

    private static final String JMS_CONNECTION_FACTORY_JNDI_NAME = "jms/RemoteConnectionFactory";
    private static final String MESSAGES_TOPIC_JNDI_NAME = "jms/topic/Messages";

    private static MessageListener listener = message -> {
        try {
            var payload = message.getBody(ChatMessage.class);
            System.out.println("New message: %s".formatted(payload.getText()));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    };

    public static void main(String[] args) throws NamingException {
        var proxyFactory = new ProxyFactory();
        ConnectionFactory connectionFactory = proxyFactory.createProxy(JMS_CONNECTION_FACTORY_JNDI_NAME);
        Topic topic = proxyFactory.createProxy(MESSAGES_TOPIC_JNDI_NAME);
        try (JMSContext jmsContext = connectionFactory.createContext();
             JMSConsumer jmsConsumer = jmsContext.createConsumer(topic)) {
            jmsConsumer.setMessageListener(listener);
            new Scanner(System.in).next();
        }
    }

}
