#include <Firmata.h>          // Biblioteca para o protocolo Firmata
#include <SoftwareSerial.h>   // Biblioteca para comunicação serial com o ESP8266
#include <PubSubClient.h>     // Biblioteca MQTT para Arduino

// Definições de pinos
#define RX_PIN 2             // Pino RX do Arduino conectado ao TX do ESP8266
#define TX_PIN 3             // Pino TX do Arduino conectado ao RX do ESP8266
#define SOLENOID_PIN 4       // Pino para controle da válvula solenoide
#define SOIL_MOISTURE_PIN A0 // Pino analógico para leitura da umidade do solo

// Configurações da rede Wi-Fi
const char* ssid = "EDSON RAMOS_5G;
const char* password = "23Abril";

// Configurações do servidor MQTT
const char* mqtt_server = "mqtt.umidadeauto.com";
const int mqtt_port = 1883;                  // Porta padrão do MQTT
const char* mqtt_username = "user";       // Usuário MQTT
const char* mqtt_password = "1234";         // Senha MQTT

SoftwareSerial espSerial(RX_PIN, TX_PIN);    // Criação do objeto de comunicação serial com o ESP8266
WiFiClient espClient;                         // Criação do cliente Wi-Fi para o ESP8266
PubSubClient mqttClient(espClient);           // Criação do cliente MQTT

int soil_moisture_threshold = 500; // Defina aqui o valor de umidade do solo desejado para acionamento da irrigação

void setup() {
  Serial.begin(9600);                         // Inicia a comunicação serial com o monitor serial
  espSerial.begin(115200);                    // Inicia a comunicação serial com o ESP8266
  pinMode(SOLENOID_PIN, OUTPUT);              // Define o pino da válvula solenoide como saída
  setup_wifi();                               // Configura a conexão Wi-Fi
  mqttClient.setServer(mqtt_server, mqtt_port); // Configura o servidor MQTT
  connect_mqtt();                             // Conecta ao servidor MQTT
}

void loop() {
  // Mantém a conexão com o servidor MQTT
  if (!mqttClient.connected()) {
    connect_mqtt();
  }
  mqttClient.loop();
  
  // Realiza leitura da umidade do solo
  int soil_moisture = analogRead(SOIL_MOISTURE_PIN);
  Serial.print("Umidade do solo: ");
  Serial.println(soil_moisture);
  
  // Verifica se a umidade do solo está abaixo do limite
  if (soil_moisture < soil_moisture_threshold) {
    // Aciona a válvula solenoide para irrigação
    digitalWrite(SOLENOID_PIN, HIGH);
    Serial.println("Irrigando...");
  } else {
    // Desliga a válvula solenoide
    digitalWrite(SOLENOID_PIN, LOW);
    Serial.println("Solo úmido, sem irrigação.");
  }
  
  // Envia a leitura para o servidor MQTT
  send_mqtt_message("sensor/umidade_solo", String(soil_moisture));
  delay(5000); // Delay para evitar envio frequente de mensagens
}

void setup_wifi() {
  delay(10);
  // Conecta-se à rede Wi-Fi
  Serial.println();
  Serial.print("Conectando à rede ");
  Serial.println(ssid);
  
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  
  Serial.println("");
  Serial.println("Conexão WiFi estabelecida");
  Serial.print("Endereço IP: ");
  Serial.println(WiFi.localIP());
}

void connect_mqtt() {
  // Tenta conectar-se ao servidor MQTT
  while (!mqttClient.connected()) {
    Serial.println("Conectando ao servidor MQTT...");
    if (mqttClient.connect("arduinoClient", mqtt_username, mqtt_password)) {
      Serial.println("Conectado ao servidor MQTT");
      // Inscreve-se em um tópico MQTT
      mqttClient.subscribe("topico/teste");
    } else {
      Serial.print("Falha na conexão, rc=");
      Serial.print(mqttClient.state());
      Serial.println(" Tentando reconectar em 5 segundos");
      delay(5000);
    }
  }
}

// Função para enviar mensagem MQTT
void send_mqtt_message(String topic, String payload) {
  mqttClient.publish(topic.c_str(), payload.c_str());
}
