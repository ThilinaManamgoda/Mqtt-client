package com.maanadev.mqttclient.core;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.maanadev.mqttclient.constants.MQTTSampleConstants;

public class RunClient {
	private static final String SUBSCRIBE = "subscribe";
	private static final String SEND = "send";
	private static final int SUBSCRIBE_Count = 3;
	private static final int SEND_Count = 4;
	private static final String DASH = "-";

	private static final int KEYWORD = 0;
	private static final int CONNECTION_NAME = 1;
	private static final int TOPIC = 2;
	private static final int MESSAGE = 3;

	public static void main(String[] args) throws MqttException {
		// subscribe -<Connection Name> -<topic>
		// send -<Connection Name> -<topic> -<message>

		MQTTListener mqttListener;
		MQTTSender mqttSender;
		try {
			if (args[KEYWORD].equals(SUBSCRIBE)) {
				if (args.length == SUBSCRIBE_Count) {
					if (args[CONNECTION_NAME].startsWith(DASH)) {
						if (args[TOPIC].startsWith(DASH)) {
							String topic =args[TOPIC].split(DASH)[1];
							mqttListener = new MQTTListener(true, MQTTSampleConstants.DEFAULT_USER_NAME,
									MQTTSampleConstants.DEFAULT_PASSWORD, args[CONNECTION_NAME].split(DASH)[1], topic);
							System.out.println("Connected to the topic: "+topic+" : wating for Messages !!!");

						}

					}
				} else {
					System.out.println("Wrong Argument/arguments !!");
				}

			} else if (args[KEYWORD].equals(SEND)) {
				System.out.println(args.length);
				if (args.length == SEND_Count) {
				
					if (args[CONNECTION_NAME].startsWith(DASH)) {
						if (args[TOPIC].startsWith(DASH)) {
							if (args[MESSAGE].startsWith(DASH)) {

								mqttSender = new MQTTSender(args[CONNECTION_NAME].split(DASH)[1], true, MQTTSampleConstants.DEFAULT_USER_NAME,
										MQTTSampleConstants.DEFAULT_PASSWORD);
								MqttMessage message = new MqttMessage();
								message.setPayload(args[MESSAGE].split(DASH)[1].getBytes());
								mqttSender.sendMessage(args[TOPIC].split(DASH)[1], message);
								mqttSender.close();
								System.out.println("Message sent !!");
							}
						}

					}

				}
			} else {
				System.out.println("Wrong Argument/arguments !!");
			}
		} catch (MqttException e) {
			System.out.println("Something wrong with the Mqtt message broker");
			System.out.println(e.getMessage());
		}

	}
}
