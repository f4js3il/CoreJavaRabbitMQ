package org.example.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public void consumeMessage() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel= connection.createChannel();

        DeliverCallback deliverCallback =(consumerTag,delivery)->{
            String message = new String(delivery.getBody());
            System.out.println(message);
        };

        channel.basicConsume("Queue-1",true,deliverCallback,consumerTag->{});
    }
}
