// Função para fazer uma solicitação GET para a API e exibir todos os alunos
document.getElementById("listarAlunos").addEventListener("click", function () {
    fetch('http://localhost:8080/escola/aluno') 
        .then(response => response.json())
        .then(data => {
            const listaAlunos = document.getElementById("listaAlunos");
            listaAlunos.style.display = "block";
            listaAlunos.innerHTML = "";

            data.forEach(aluno => {
                const item = document.createElement("li");
                item.textContent = `ID: ${aluno.id}, Nome: ${aluno.nome}, Idade: ${aluno.idade}, E-mail: ${aluno.email}`;
                listaAlunos.appendChild(item);
            });
        })
        .catch(error => console.error(error));
});

// Função para ocultar a lista de alunos
document.getElementById("ocultarLista").addEventListener("click", function () {
    const listaAlunos = document.getElementById("listaAlunos");
    listaAlunos.style.display = "none"; // Define a propriedade display como "none" para ocultar a lista.
});

// Função para cadastrar um novo aluno
document.getElementById("cadastrarAluno").addEventListener("click", function () {
    const nome = document.getElementById("nome").value;
    const idade = document.getElementById("idade").value;
    const email = document.getElementById("email").value;

    const novoAluno = {
        nome,
        idade,
        email,
    };

    fetch('http://localhost:8080/escola/aluno', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(novoAluno),
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("cadastroForm").reset();
            alert("Cadastro feito com sucesso!");
        })
        .catch(error => console.error(error));
});

