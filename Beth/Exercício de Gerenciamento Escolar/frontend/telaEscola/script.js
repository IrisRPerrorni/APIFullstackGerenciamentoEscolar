//Cadastrar aluno
const formaluno = document.getElementById("formaluno");

formaluno.addEventListener("submit", event => {
  event.preventDefault();

  const formData = new FormData(formaluno);
  const data = {};
  
  formData.forEach((value, key) => {
    data[key] = value;
  });

  fetch("http://localhost:8080/api/alunos", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(res => res.json())
  .then(data => {
    console.log(data);
    mensagem(); 
  })
  .catch(error => console.error(error));
});

function mensagem1() {
  alert("Aluno adicionado com sucesso!");
  window.location.reload(true);
}

//Cadastrar curso
const formcurso = document.getElementById("formcurso");

formcurso.addEventListener("submit", event => {
  event.preventDefault();

  const formData = new FormData(formcurso);
  const data = {};
  
  formData.forEach((value, key) => {
    data[key] = value;
  });

  fetch("http://localhost:8080/api/cursos", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(res => res.json())
  .then(data => {
    console.log(data);
    mensagem(); 
  })
  .catch(error => console.error(error));
});

function mensagem2() {
  alert("Curso adicionado com sucesso!");
  window.location.reload(true);
}

//Cadastrar professor
const formprofessor = document.getElementById("formprofessor");

formprofessor.addEventListener("submit", event => {
  event.preventDefault();

  const formData = new FormData(formprofessor);
  const data = {};
  
  formData.forEach((value, key) => {
    data[key] = value;
  });

  fetch("http://localhost:8080/api/professores", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(res => res.json())
  .then(data => {
    console.log(data);
    mensagem(); 
  })
  .catch(error => console.error(error));
});

function mensagem3() {
  alert("Professor adicionado com sucesso!");
  window.location.reload(true);
}

//Listar alunos
fetch("http://localhost:8080/api/alunos").then((data)=>{
    return data.json();
    }).then((todos) => {
    let data1 = "";
    todos.map((values) => {
        data1 += `
        <tbody>
            <tr>
            <th scope="row">${values.id}</td>
            <td>${values.nome}</td>
            <td>${values.idade}</td>
            <td>${values.email}</td>
            <tr>
        </tbody>
        `
    })
    document.getElementById("buscaaluno").innerHTML = data1;
    console.log(todos);
})

//Listar cursos
fetch("http://localhost:8080/api/cursos").then((data)=>{
    return data.json();
    }).then((todos) => {
    let data1 = "";
    todos.map((values) => {
        data1 += `
        <tbody>
            <tr>
            <th scope="row">${values.id}</td>
            <td>${values.nome}</td>
            <td>${values.cargaHoraria}</td>
            <tr>
        </tbody>
        `
    })
    document.getElementById("buscacurso").innerHTML = data1;
    console.log(todos);
})

//Listar professores
fetch("http://localhost:8080/api/professores").then((data)=>{
    return data.json();
    }).then((todos) => {
    let data1 = "";
    todos.map((values) => {
        data1 += `
        <tbody>
            <tr>
            <th scope="row">${values.id}</td>
            <td>${values.nome}</td>
            <td>${values.idade}</td>
            <td>${values.curso}</td>
            <td>${values.salario}</td>
            <tr>
        </tbody>
        `
    })
    document.getElementById("buscaprofessor").innerHTML = data1;
    console.log(todos);
})