package org.example.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Exchanges_Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
      ConnectionFactory connectionFactory = new ConnectionFactory();
      Connection connection = connectionFactory.newConnection();
      Channel channel = connection.createChannel();

        DeliverCallback deliverCallback =(consumerTag,delivery)->{
         System.out.println(new String(delivery.getBody()));
        };

        channel.basicConsume("TV", true,deliverCallback,consumerTag->{});
        channel.basicConsume("AC", true,deliverCallback,consumerTag->{});
        channel.basicConsume("Mobile", true,deliverCallback,consumerTag->{});

    }


}
