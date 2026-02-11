document.addEventListener('DOMContentLoaded', function () {
    // Obtener el formulario: crear o editar
    const form = document.getElementById('crearJugadorForm') || document.getElementById('editarJugadorForm');
    if (!form) return;

    // Detectar idioma desde el atributo lang del html
    const lang = document.documentElement.lang || 'es';

    // Mensajes de error por idioma
    const messages = {
        es: {
            required: 'es obligatorio',
            minLength: 'debe tener al menos 3 letras',
            lettersOnly: 'solo se permiten letras y espacios',
            edadMin: 'la edad mínima es 5 años',
            pierna: 'debes seleccionar una pierna',
            categoria: 'debes seleccionar una categoría',
            email: 'formato de email inválido'
        },
        en: {
            required: 'is required',
            minLength: 'must be at least 3 letters',
            lettersOnly: 'only letters and spaces are allowed',
            edadMin: 'minimum age is 5 years',
            pierna: 'you must select a leg',
            categoria: 'you must select a category',
            email: 'invalid email format'
        },
        jp: {
            required: 'は必須です',
            minLength: 'は少なくとも3文字必要です',
            lettersOnly: 'は文字とスペースのみ使用できます',
            edadMin: '最低年齢は5歳です',
            pierna: '利き足を選択してください',
            categoria: 'カテゴリーを選択してください',
            email: '無効なメール形式です'
        }
    };

    form.addEventListener('submit', function (event) {
        let valid = true;

        // --- Nombre ---
        const nombre = form.querySelector('[name="nombre"]');
        const errorNombre = form.querySelector('#error-nombre');
        if (nombre.value.trim() === '') {
            errorNombre.textContent = 'Nombre ' + messages[lang].required;
            valid = false;
        } else if (nombre.value.length < 3) {
            errorNombre.textContent = 'Nombre ' + messages[lang].minLength;
            valid = false;
        } else if (!/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/.test(nombre.value)) {
            errorNombre.textContent = 'Nombre ' + messages[lang].lettersOnly;
            valid = false;
        } else {
            errorNombre.textContent = '';
        }

        // --- Apellido ---
        const apellido = form.querySelector('[name="apellido"]');
        const errorApellido = form.querySelector('#error-apellido');
        if (apellido.value.trim() === '') {
            errorApellido.textContent = 'Apellido ' + messages[lang].required;
            valid = false;
        } else if (apellido.value.length < 3) {
            errorApellido.textContent = 'Apellido ' + messages[lang].minLength;
            valid = false;
        } else if (!/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/.test(apellido.value)) {
            errorApellido.textContent = 'Apellido ' + messages[lang].lettersOnly;
            valid = false;
        } else {
            errorApellido.textContent = '';
        }

        // --- Edad ---
        const edad = form.querySelector('[name="edad"]');
        const errorEdad = form.querySelector('#error-edad');
        if (edad.value === '') {
            errorEdad.textContent = 'Edad ' + messages[lang].required;
            valid = false;
        } else if (parseInt(edad.value) < 5) {
            errorEdad.textContent = messages[lang].edadMin;
            valid = false;
        } else {
            errorEdad.textContent = '';
        }

        // --- Pierna hábil ---
        const pierna = form.querySelector('[name="piernaHabil"]');
        const errorPierna = form.querySelector('#error-pierna');
        if (pierna.value === '') {
            errorPierna.textContent = messages[lang].pierna;
            valid = false;
        } else {
            errorPierna.textContent = '';
        }

        // --- Email ---
        const email = form.querySelector('[name="email"]');
        const errorEmail = form.querySelector('#error-email');
        if (email.value.trim() === '') {
            errorEmail.textContent = 'Email ' + messages[lang].required;
            valid = false;
        } else if (!/^\S+@\S+\.\S+$/.test(email.value)) {
            errorEmail.textContent = messages[lang].email;
            valid = false;
        } else {
            errorEmail.textContent = '';
        }

        if (!valid) {
            event.preventDefault(); // Evita enviar si hay errores
        }

        // --- Categoría solo si es el formulario de crear ---
        if (form.id === 'crearJugadorForm') {
            const categoria = form.querySelector('[name="categoria"]');
            const errorCategoria = form.querySelector('#error-categoria');
            if (!categoria || categoria.value === '') {
                errorCategoria.textContent = messages[lang].categoria;
                valid = false;
            } else {
                errorCategoria.textContent = '';
            }
        }

    });
});
