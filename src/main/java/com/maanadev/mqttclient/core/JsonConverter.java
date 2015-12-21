package com.maanadev.mqttclient.core;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class JsonConverter<T> {

	public JsonConverter() {
	}

	public MqttMessage getJsonMqttmessageOfClass(T t) {

		ObjectMapper mapper = new ObjectMapper();

		String string = null;
		try {
			string = mapper.writeValueAsString(t);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MqttMessage message = new MqttMessage();
		message.setPayload(string.getBytes());

		return message;
	}

	public T getObject(MqttMessage message, Class<T> t) {
		ObjectMapper mapper = new ObjectMapper();
		T t_return = null;
		try {
			t_return = mapper.readValue(message.toString(), t);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t_return;
	}

}
