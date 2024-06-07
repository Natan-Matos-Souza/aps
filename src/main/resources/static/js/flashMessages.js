const flashMessages = document.querySelectorAll('.alert');
setTimeout(() => {
    flashMessages.forEach(e => {
        e.style.display = "none";
    });
}, 3 * 1000);