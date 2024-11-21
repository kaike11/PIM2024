// Exibir o menu ao clicar no ícone do menu
document.querySelector('.menu-icon').addEventListener('click', () => {
    document.querySelector('nav ul').classList.add('active');
    document.querySelector('.menu-icon').style.display = 'none';
    document.querySelector('.close-icon').style.display = 'block';
});

// Ocultar o menu ao clicar no ícone de fechar
document.querySelector('.close-icon').addEventListener('click', () => {
    document.querySelector('nav ul').classList.remove('active');
    document.querySelector('.menu-icon').style.display = 'block';
    document.querySelector('.close-icon').style.display = 'none';
});
function abrirMenu() {
    const menu = document.querySelector("nav ul");
    menu.classList.add("active");
}

function fecharMenu() {
    const menu = document.querySelector("nav ul");
    menu.classList.remove("active");
}