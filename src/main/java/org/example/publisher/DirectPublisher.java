package org.example.publisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DirectPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String messageMobile = "This is message to mobile";
        String messageTv = "This is message to tv";
        String messageAc = "This is message to AC;";
        channel.basicPublish("Direct-Exchange","mobile",null, messageMobile.getBytes());
        channel.basicPublish("Direct-Exchange","tv",null, messageTv.getBytes());
        channel.basicPublish("Direct-Exchange","ac",null, messageAc.getBytes());
        channel.close();
        connection.close();

    }
}
