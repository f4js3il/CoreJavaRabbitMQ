package org.example;

import org.example.consumer.Consumer;
import org.example.publisher.Publisher;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, TimeoutException {
     Publisher publisher = new Publisher();
     publisher.publishMessage();
     Consumer consumer = new Consumer();
     consumer.consumeMessage();
    }
}
