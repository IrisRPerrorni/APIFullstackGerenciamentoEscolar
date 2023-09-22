// Função para fazer uma solicitação GET para a API e exibir todos os alunos
document.getElementById("listarCurso").addEventListener("click", function () {
    fetch('http://localhost:8080/escola/curso') 
        .then(response => response.json())
        .then(data => {
            const listaCursos = document.getElementById("listaCursos");
            listaCursos.style.display = "block";
            listaCursos.innerHTML = "";

            data.forEach(curso => {
                const item = document.createElement("li");
                item.textContent = `ID: ${curso.id}, Nome: ${curso.nome}, Carga Horaria: ${curso.cargaHoraria}`;
                listaCursos.appendChild(item);
            });
        })
        .catch(error => console.error(error));
});

// Função para ocultar 
document.getElementById("ocultarLista").addEventListener("click", function () {
    const listaCursos = document.getElementById("listaCursos");
    listaCursos.style.display = "none"; // Define a propriedade display como "none" para ocultar a lista.
});

// Função para cadastrar 
document.getElementById("cadastrarCurso").addEventListener("click", function () {
    const nome = document.getElementById("nome").value;
    const cargaHoraria = document.getElementById("cargaHoraria").value;

    const novoCurso = {
        nome,
        cargaHoraria,
    };

    fetch('http://localhost:8080/escola/curso', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(novoCurso),
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("cadastroForm").reset();
            alert("Cadastro feito com sucesso!");
        })
        .catch(error => console.error(error));
});