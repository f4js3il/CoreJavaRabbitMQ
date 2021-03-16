package org.example.publisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicPublisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String messageMobAC = "This is message to mobile and AC";
        String messageTv = "This is message to tv;";
        channel.basicPublish("Topic","tv.mobile.ac",null, messageMobAC.getBytes());
        channel.basicPublish("Topic","tv.tv.tc",null, messageTv.getBytes());
        channel.close();
        connection.close();

    }
}
