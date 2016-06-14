# Mqtt-client
User can send and recevie Mqtt messages .Also convert java object to Json and create Mqtt Message


Instructions to bulid :


1. clone the repo
2. execute mvn clean install


At this moment you will have target folder inside the project folder which will contain a jar called "mqtt-client-0.0.1.one-jar.jar".
This contains all the dependencies and you can run as follows,

1. To get the Mqtt messages

  subscribe -ConnectionName  -Topic
  
  ex: subscribe -TestingSub -TestTopic
  
2. To send Messages

  send -ConnectionName  -Topic  -Message
  
  ex: send  -TestingSen -TestTopic -"testing mqtt messages"
  
*Here each Connection Name should be UNIQUE !!

Also you can use this repo in your project as a maven repo and Sample codes are provide ins the Example class 
