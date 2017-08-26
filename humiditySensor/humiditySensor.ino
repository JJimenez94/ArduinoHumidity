#include <DHT.h>
#include <DHT_U.h>

// Arduino code for capture the Humidity using a DHT11 sensor
// Based on code written by ladyada, public domain

#define DHTPIN 2     // what digital pin we're connected to

// Setting the type of sensor we're using
#define DHTTYPE DHT11   // DHT 11

// Initialize DHT sensor.
DHT dht(DHTPIN, DHTTYPE);

void setup() {
  //Initialize the serial port 
  Serial.begin(9600);
  Serial.println("Humidity capture module");
  dht.begin();
}

void loop() {  
  //Delaty time to capture the humidity
  delay(30000);
  //Variable declaration and initialize
  float h = dht.readHumidity();
  //Print the captured value using Serial port  
  Serial.println(h);
 //Delaty time to restart the capture thread
  delay(150000);
}
