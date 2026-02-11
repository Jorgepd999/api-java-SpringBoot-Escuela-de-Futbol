document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('editarJugadorForm') || document.getElementById('crearJugadorForm');

    if (!form) return;

    form.addEventListener('submit', function(event) {
        let valid = true;

        // --- Nombre ---
        const nombre = form.querySelector('[name="nombre"]');
        const errorNombre = form.querySelector('#error-nombre');
        if (nombre.value.trim() === '') {
            errorNombre.textContent = 'El nombre es obligatorio';
            valid = false;
        } else if (nombre.value.length < 3) {
            errorNombre.textContent = 'El nombre debe tener al menos 3 letras';
            valid = false;
        } else if (!/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/.test(nombre.value)) {
            errorNombre.textContent = 'Solo se permiten letras y espacios';
            valid = false;
        } else {
            errorNombre.textContent = '';
        }

        // --- Apellido ---
        const apellido = form.querySelector('[name="apellido"]');
        const errorApellido = form.querySelector('#error-apellido');
        if (apellido.value.trim() === '') {
            errorApellido.textContent = 'El apellido es obligatorio';
            valid = false;
        } else if (apellido.value.length < 3) {
            errorApellido.textContent = 'El apellido debe tener al menos 3 letras';
            valid = false;
        } else if (!/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/.test(apellido.value)) {
            errorApellido.textContent = 'Solo se permiten letras y espacios';
            valid = false;
        } else {
            errorApellido.textContent = '';
        }

        // --- Edad ---
        const edad = form.querySelector('[name="edad"]');
        const errorEdad = form.querySelector('#error-edad');
        if (edad.value === '') {
            errorEdad.textContent = 'La edad es obligatoria';
            valid = false;
        } else if (edad.value < 5) {
            errorEdad.textContent = 'La edad mínima es 5 años';
            valid = false;
        } else {
            errorEdad.textContent = '';
        }

        // --- Pierna ---
        const pierna = form.querySelector('[name="piernaHabil"]');
        const errorPierna = form.querySelector('#error-pierna');
        if (pierna.value === '') {
            errorPierna.textContent = 'Debes seleccionar una pierna';
            valid = false;
        } else {
            errorPierna.textContent = '';
        }

        // --- Email ---
        const email = form.querySelector('[name="email"]');
        const errorEmail = form.querySelector('#error-email');
        if (email.value.trim() === '') {
            errorEmail.textContent = 'El email es obligatorio';
            valid = false;
        } else if (!/^\S+@\S+\.\S+$/.test(email.value)) {
            errorEmail.textContent = 'Formato de email inválido';
            valid = false;
        } else {
            errorEmail.textContent = '';
        }

        if (!valid) {
            event.preventDefault();
        }
    });
});
