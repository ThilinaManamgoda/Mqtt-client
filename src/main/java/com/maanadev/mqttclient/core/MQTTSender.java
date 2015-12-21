package com.maanadev.mqttclient.core;

import java.io.File;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

import com.maanadev.mqttclient.constants.MQTTSampleConstants;

public class MQTTSender {

	private MqttClient mqttClient;

	public MQTTSender(String clientId, boolean cleanSession, String userName, String password) throws MqttException {
		MqttConnectOptions options = new MqttConnectOptions();
		options.setCleanSession(cleanSession);
		options.setUserName(userName);
		options.setPassword(password.toCharArray());

		mqttClient = new MqttClient(MQTTSampleConstants.BROKER_URL, clientId,
				new MqttDefaultFilePersistence(MQTTSampleConstants.TMP_DIR + File.separator + clientId));
		mqttClient.connect(options);
	}

	public void sendMessage(String topic, MqttMessage message) throws MqttException {
		// mqttClient.publish(topic, message.getPayload(), qos, false);
		mqttClient.publish(topic, message);
	}

	public void close() {

		try {
			mqttClient.disconnect();
			mqttClient.close();
		} catch (MqttException e) {
			e.printStackTrace();
		}

	}
}
