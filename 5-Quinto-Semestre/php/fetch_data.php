<?php
// Conexão com o banco de dados MySQL
$servername = "localhost";
$username = "seu_usuario";
$password = "sua_senha";
$dbname = "seu_banco_de_dados";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Conexão falhou: " . $conn->connect_error);
}

// Consulta SQL para recuperar os dados da lista de presença
$sql = "SELECT dia_semana, mes_ano, nome_turma, aluno FROM lista_presenca";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Saída dos dados de cada linha
    while($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . $row["dia_semana"] . "</td>";
        echo "<td>" . $row["mes_ano"] . "</td>";
        echo "<td>" . $row["nome_turma"] . "</td>";
        echo "<td>" . $row["aluno"] . "</td>";
        echo "<td><input type='checkbox'></td>"; // Checkbox de presença
        echo "</tr>";
    }
} else {
    echo "0 resultados";
}
$conn->close();
?>
