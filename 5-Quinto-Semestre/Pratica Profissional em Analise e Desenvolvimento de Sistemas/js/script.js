document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Impede o envio do formulário

    // Obter os valores inseridos
    var username = document.getElementById("nome_login").value;
    var password = document.getElementById("senha_login").value;

    // Verificar as credenciais do administrador
    if (username === "Administrador" && password === "123456") {
        window.location.replace("./5-Quinto-Semestre/administrador.html"); // Redirecionar para a página do administrador
    }
    // Verificar as credenciais do professor
    else if (username === "Professor" && password === "123456") {
        window.location.replace("pagina_professor.html"); // Redirecionar para a página do professor
    } else {
        alert("Usuário ou senha incorretos."); // Exibir mensagem de erro
    }
});
