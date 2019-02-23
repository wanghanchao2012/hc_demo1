package com.emarbox.example.activemq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloActiveMQ {
	public static void main(String[] args) throws Exception {
//		HelloWorldProducer producer = new HelloWorldProducer();
		HelloWorldConsumer consumer = new HelloWorldConsumer();

//		Thread threadProducer = new Thread(producer);
//		threadProducer.start();
		// 注释掉消费者，不然的话，马上消费者马上把消息消费了，来不及持久化
		 Thread threadConsumer = new Thread(consumer);
		 threadConsumer.start();
	}

	public static class HelloWorldProducer implements Runnable {
		public void run() {
			try {
				// Create a ConnectionFactory
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
						"tcp://localhost:61616");

				// Create a Connection
				Connection connection = connectionFactory.createConnection();
				connection.start();

				// Create a Session
				Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

				// Create the destination (Topic or Queue)
				Destination destination = session.createQueue("DemoQueue");

				// Create a MessageProducer from the Session to the Topic or
				// Queue
				MessageProducer producer = session.createProducer(destination);
				// producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
				producer.setDeliveryMode(DeliveryMode.PERSISTENT);// 消息需要持久化

				// Create a messages
				String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
				TextMessage message = session.createTextMessage(text);

				// Tell the producer to send the message
				System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
				producer.send(message);

				// Clean up
				session.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}
	}

	public static class HelloWorldConsumer implements Runnable, ExceptionListener {
		public void run() {
			try {
				// Create a ConnectionFactory
				ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
						"tcp://localhost:61616");
				// Create a Connection
				Connection connection = connectionFactory.createConnection();
				connection.start();
				connection.setExceptionListener(this);
				// Create a Session
				Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
				// Create the destination (Topic or Queue)
				Destination destination = session.createQueue("DemoQueue");
				// Create a MessageConsumer from the Session to the Topic or
				// Queue
				MessageConsumer consumer = session.createConsumer(destination);
				// Wait for a message
				for (int i = 0; i < 2; i++) {
					Message message = consumer.receive(1000);
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;
						String text = textMessage.getText();
						System.out.println("Received: " + text);
					} else {
						System.out.println("Received: " + message);
					}
					if(i==1){
						message.acknowledge();
					}
				}
				consumer.close();
				session.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}
		}

		public synchronized void onException(JMSException ex) {
			System.out.println("JMS Exception occured.  Shutting down client.");
		}
	}
}