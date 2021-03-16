package org.example.publisher;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class HeaderPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String messageMobileTv = "This is message to mobile and Tv";

        Map<String,Object> headersMap = new HashMap<String,Object>();
        headersMap.put("item1","mobile");
        headersMap.put("item2","television");

        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties();
        basicProperties = basicProperties.builder().headers(headersMap).build();

        channel.basicPublish("Headers","",basicProperties, messageMobileTv.getBytes());

        channel.close();
        connection.close();

    }
}
