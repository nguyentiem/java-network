
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>
#include <ESP8266mDNS.h>

int port = 88;  //Port number
WiFiServer server(port);

//Server connect to WiFi Network
const char *ssid = "Nguyen Tiem";  //Enter your wifi SSID
const char *password = "58642110";  //Enter your wifi Password

int count=0;
//=======================================================================
//                    Power on setup
//=======================================================================
void setup() 
{
  Serial.begin(9600);
 
  Serial.println();

//  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password); //Connect to wifi
 
  // Wait for connection  
  Serial.println("Connecting to Wifi");
  while (WiFi.status() != WL_CONNECTED) {   
    delay(500);
    Serial.print(".");
    delay(500);
  }

  Serial.println("");
  Serial.print("Connected to ");
  Serial.println(ssid);

  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());  
  server.begin();
  Serial.print("Open Telnet and connect to IP:");
  Serial.print(WiFi.localIP());
  Serial.print(" on port ");
  Serial.println(port);
}


void loop() 
{
  WiFiClient client = server.available();
  
  if (client) {
    if(client.connected())
    {
      Serial.println("Client Connected");
    }
    
    if(client.connected()){      
//      if(client.available()>0){
//        Serial.println("co dl gui den");
//         String req = client.readStringUntil('\r');
//         Serial.println(req);
//      }
       while (client.available()>0) {
        char c = client.read();
        Serial.write(c);
      }
     
        client.println("esp8266 server hello");
    
    }
    client.stop();
    Serial.println("Client disconnected");    
  }
}
