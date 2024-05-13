# Sistema de Monitoramento e Irrigação de Plantas

Este projeto consiste em um sistema de monitoramento inteligente para auxiliar na gestão eficiente da irrigação e do manejo de cultivos agrícolas. O sistema utiliza sensores de umidade do solo e uma válvula solenoide para controlar a irrigação das plantações de forma automática e remota.

## Funcionamento

O sistema realiza leituras da umidade do solo por meio do sensor de umidade do solo (modelo FC-28). Caso a umidade do solo esteja abaixo de um limite predefinido, a válvula solenoide é acionada para irrigação das plantas. As leituras da umidade do solo são enviadas para um servidor MQTT para monitoramento remoto.

## Componentes Utilizados

- Arduino UNO programado com o protocolo Firmata
- Módulo ESP8266 para comunicação Wi-Fi
- Sensor de Umidade do Solo (FC-28)
- Válvula Solenoide para controle da irrigação
- Servidor MQTT para troca de mensagens

## Configuração

Antes de utilizar o código, é necessário configurar os seguintes parâmetros:

- Rede Wi-Fi: SSID e senha da rede Wi-Fi.
- Servidor MQTT: Endereço do servidor MQTT, porta, usuário e senha.
- Limite de Umidade do Solo: Defina o valor de umidade do solo desejado para acionamento da irrigação.

## Instalação e Uso

1. Carregue o código para o Arduino UNO utilizando a IDE do Arduino.
2. Conecte os sensores e a válvula solenoide conforme descrito no código.
3. Inicie o servidor MQTT e configure-o conforme as especificações do código.
4. Alimente o Arduino UNO e observe o sistema realizar as leituras da umidade do solo e controlar a irrigação conforme necessário.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas (issues) e enviar pull requests com melhorias ou correções.


