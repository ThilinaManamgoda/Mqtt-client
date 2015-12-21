package com.maanadev.mqttclient.examples;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.maanadev.mqttclient.constants.MQTTSampleConstants;
import com.maanadev.mqttclient.core.JsonConverter;
import com.maanadev.mqttclient.core.MQTTListener;
import com.maanadev.mqttclient.core.MQTTSender;

public class Example {

	public static void main(String[] args) throws MqttException {

		// SET MQTT LISTENER FOR RECEIVE MQTT MESSAGE
		MQTTListener mqttListener = new MQTTListener(true, MQTTSampleConstants.DEFAULT_USER_NAME,
				MQTTSampleConstants.DEFAULT_PASSWORD, "client2", "test");

		// SEND A MQTT MESSAGE THAT CONTAIN PERSON OBJECT AS PAYLOAD

		Person p = new Person();
		p.setAge(45);
		p.setHeigth(6);
		p.setName("maanadev");

		JsonConverter<Person> converter = new JsonConverter<Person>();

		MqttMessage message = converter.getJsonMqttmessageOfClass(p);

		MQTTSender sender = new MQTTSender("client1", true, MQTTSampleConstants.DEFAULT_USER_NAME,
				MQTTSampleConstants.DEFAULT_PASSWORD);
		sender.sendMessage("test", message);
		sender.close();
		
		//DEMONSTRATE HOW TO GET OBJECT FOMR MQTT MESSAGE
//		Person person = converter.getObject(message, Person.class);
//		System.out.println(person.toString());
		
		
	}

}
