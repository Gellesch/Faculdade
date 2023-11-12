/*
Nessa aula, foi apresentado como implementar um Web Service utilizando o padrão REST. Para esta atividade, você deve implementar um Web Service RESTful, seguindo as especificações vistas na aula.
Seu Web Service disponibiliza um serviço de uma calculadora com as quatro operações básicas (soma, subtração, divisão e multiplicação). Para tanto, você deve implementar um método para cada uma das operações no Web Service. Os métodos receberão sempre dois valores inteiros e devolverão o resultado das operações como uma String, ou seja, quando estiver criando seu projeto no NetBeans, escolha como tipo de formato da comunicação (MIME Type), o formato texto (text/plain). Além disso, depois de criar seu projeto, não se esqueça de adicionar a JAX-RS 2.0 nas Libraries de seu Web Service.
Os testes em seu Web Service serão realizados por meio de requisições na barra de endereço do browser; para cada operação de sua calculadora, você deve definir um nome para recurso que receberá os dois parâmetros da operação. Por exemplo, para a operação de soma, poderíamos ter a URI como http://localhost:8080/calculadora/operacao/soma/10/2, em que:
• URL: http://localhost:8080/calculadora/ (URL + nome do nosso Web Service)
• caminho: /operacao/
• nome do recurso e parâmetros: /soma/10/2
e o resultado para requisição acima seria:
Em sua implementação, não é necessário você ter a mesma URI apresentada acima, mas, para cada operação, você deve definir um nome de recurso.*/

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/calculadora")
public class CalculatorResource {

    @GET
    @Path("/soma/{a}/{b}")
    public String soma(@PathParam("a") int a, @PathParam("b") int b) {
        int resultado = a + b;
        return Integer.toString(resultado);
    }

    @GET
    @Path("/subtracao/{a}/{b}")
    public String subtracao(@PathParam("a") int a, @PathParam("b") int b) {
        int resultado = a - b;
        return Integer.toString(resultado);
    }

    @GET
    @Path("/multiplicacao/{a}/{b}")
    public String multiplicacao(@PathParam("a") int a, @PathParam("b") int b) {
        int resultado = a * b;
        return Integer.toString(resultado);
    }

    @GET
    @Path("/divisao/{a}/{b}")
    public String divisao(@PathParam("a") int a, @PathParam("b") int b) {
        if (b != 0) {
            int resultado = a / b;
            return Integer.toString(resultado);
        } else {
            return "Erro: divisão por zero.";
        }
    }
}

// Precisa configurar o servlet no seu arquivo web.xml. Crie ou modifique o
// arquivo web.xml em WEB-INF.

// xml

<?xml version="1.0"encoding="UTF-8"?><web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"xmlns="http://xmlns.jcp.org/xml/ns/javaee"xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"id="WebApp_ID"version="3.1"><display-name>CalculadoraWebService</display-name><servlet><servlet-name>Jersey Web Application</servlet-name><servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class><init-param><param-name>jersey.config.server.provider.packages</param-name><param-value>seu.pacote.da.calculadora</param-value></init-param><load-on-startup>1</load-on-startup></servlet><servlet-mapping><servlet-name>Jersey Web Application</servlet-name><url-pattern>/api
/*
 * </url-pattern>
 * </servlet-mapping>
 * </web-app>
 * 
 * /*Agora, você pode implantar o projeto no seu servidor. Supondo que esteja
 * usando o GlassFish, você pode testar acessando URLs como:
 * http://localhost:8080/seu-projeto/api/calculadora/soma/10/2
 * http://localhost:8080/seu-projeto/api/calculadora/subtracao/10/2
 * http://localhost:8080/seu-projeto/api/calculadora/multiplicacao/10/2
 * http://localhost:8080/seu-projeto/api/calculadora/divisao/10/2
 */