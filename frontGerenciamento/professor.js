// Função para fazer uma solicitação GET para a API e exibir todos os professores
document.getElementById("listarProfessor").addEventListener("click", function () {
    fetch('http://localhost:8080/escola/professor') 
        .then(response => response.json())
        .then(data => {
            const listaProfessor = document.getElementById("listaProfessor");
            listaProfessor.style.display = "block";
            listaProfessor.innerHTML = "";

            data.forEach(professor => {
                const item = document.createElement("li");
                item.textContent = `ID: ${professor.id}, Nome: ${professor.nome}, Idade: ${professor.idade}, Salario: ${professor.salario}, Curso: ${professor.curso}`;
                listaProfessor.appendChild(item);
            });
        })
        .catch(error => console.error(error));
});


// Função para ocultar a lista de alunos
document.getElementById("ocultarLista").addEventListener("click", function () {
    const listaProfessor = document.getElementById("listaProfessor");
    listaProfessor.style.display = "none"; // Define a propriedade display como "none" para ocultar a lista.
});

// Função para cadastrar um novo Professor
document.getElementById("cadastrarProfessor").addEventListener("click", function () {
    const nome = document.getElementById("nome").value;
    const idade = document.getElementById("idade").value;
    const salario = document.getElementById("salario").value;
    const curso = document.getElementById("curso").value;

    const novoProfessor = {
        nome,
        idade,
        salario,
        curso,
    };

    fetch('http://localhost:8080/escola/professor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(novoProfessor),
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("cadastroForm").reset();
            alert("Cadastro feito com sucesso!");
        })
        .catch(error => console.error(error));
});
