package com.maanadev.mqttclient.core;

import java.io.File;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

import com.maanadev.mqttclient.constants.MQTTSampleConstants;

public class MQTTListener implements MqttCallback {

	private MqttClient mqttClient;
	


	public MQTTListener(boolean cleanSession, String userName, String password, String clientId,String topic) throws MqttException {
		 MqttConnectOptions options = new MqttConnectOptions();
	        options.setCleanSession(cleanSession);
	        options.setUserName(userName);
	        options.setPassword(password.toCharArray());
	        mqttClient = new MqttClient(MQTTSampleConstants.BROKER_URL, clientId,
	                new MqttDefaultFilePersistence(MQTTSampleConstants.TMP_DIR + File.separator + clientId));
	        mqttClient.setCallback(this);
	        mqttClient.connect(options);
	        mqttClient.subscribe(topic);

	}

	public void close(){
		
		try {
			mqttClient.disconnect();
			mqttClient.close();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	public void connectionLost(Throwable arg0) {
		System.out.println("Connection losed !");
	}



	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("Delivery Completed !");
	}



	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		System.out.println(arg1.toString());
	}
}
