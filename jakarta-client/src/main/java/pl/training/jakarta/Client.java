package pl.training.jakarta;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.NamingException;
import java.util.concurrent.ExecutionException;

public class Client {

    private static final String ID_GENERATOR_JNDI_NAME = "java:/jakarta-1.0-SNAPSHOT/UuidGenerator!pl.training.jakarta.IdGenerator";
    private static final String TIME_PROVIDER_JNDI_NAME = "java:/jakarta-1.0-SNAPSHOT/SystemTimeProvider!pl.training.jakarta.TimeProvider";
    private static final String PROPERTIES_STORE_JNDI_NAME = "java:/jakarta-1.0-SNAPSHOT/MapPropertiesStore!pl.training.jakarta.PropertiesStore";
    private static final String POWER_SERVICE_JNDI_NAME = "java:/jakarta-1.0-SNAPSHOT/AsyncPowerService!pl.training.jakarta.PowerService";
    private static final String JMS_CONNECTION_FACTORY_JNDI_NAME = "jms/RemoteConnectionFactory";
    private static final String MESSAGES_TOPIC_JNDI_NAME = "jms/topic/Messages";

    private static final String LANGUAGE_KEY = "language";
    private static final String LANGUAGE_VALUE = "pl";

    public static void main(String[] args) throws NamingException, ExecutionException, InterruptedException {
        var proxyFactory = new ProxyFactory();
        IdGenerator idGenerator = proxyFactory.createProxy(ID_GENERATOR_JNDI_NAME);
        System.out.println("Id: %s".formatted(idGenerator.getNext()));
        TimeProvider timeProvider = proxyFactory.createProxy(TIME_PROVIDER_JNDI_NAME);
        System.out.println("Time: %s".formatted(timeProvider.getDataTime()));
        PropertiesStore propertiesStore = proxyFactory.createProxy(PROPERTIES_STORE_JNDI_NAME);
        propertiesStore.put(LANGUAGE_KEY, LANGUAGE_VALUE);
        System.out.println("Language: %s".formatted(propertiesStore.get(LANGUAGE_KEY)));
        propertiesStore.close();
        PowerService powerService = proxyFactory.createProxy(POWER_SERVICE_JNDI_NAME);
        var result = powerService.calculate(10L);
        System.out.println("Is done: %s".formatted(result.isDone()));
        System.out.println("Power: %s".formatted(result.get()));
        ConnectionFactory connectionFactory = proxyFactory.createProxy(JMS_CONNECTION_FACTORY_JNDI_NAME);
        Topic topic = proxyFactory.createProxy(MESSAGES_TOPIC_JNDI_NAME);
        var chatMessage = new ChatMessage();
        chatMessage.setText("Hello JMS");
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().send(topic, chatMessage);
        }
    }

}
