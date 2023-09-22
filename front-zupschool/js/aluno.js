$(document).ready(function () {
    $("#form-cadastro-aluno").submit(function (event) {
        event.preventDefault();

        var nome = $("#nome").val();
        var idade = $("#idade").val();
        var email = $("#email").val();

        var data = {
            nome: nome,
            idade: idade,
            email: email
        };

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "http://localhost:8080/alunos",
            data: JSON.stringify(data),
            success: function (response) {
                if (response.status === "success") {
                    alert("Aluno cadastrado com sucesso!");
                    $("#form-cadastro-aluno")[0].reset();
                } else {
                    alert("Erro ao cadastrar aluno: " + response.message);
                }
            },
            error: function (error) {
                alert("Erro ao cadastrar aluno.");
            }
        });
    });
    $("#verAlunos").click(function () {
        alert("Lógica para listar alunos não implementada.");
    });
});