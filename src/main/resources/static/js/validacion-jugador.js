document.addEventListener('DOMContentLoaded', function () {
    // Obtener el formulario: crear o editar
    const form = document.getElementById('crearJugadorForm') || document.getElementById('editarJugadorForm');
    if (!form) return;

    // Detectar idioma desde el atributo lang del html
   let lang = document.documentElement.lang || 'es';
    lang = lang.substring(0, 2); // es-ES -> es

    // Mensajes de error por idioma
    const messages = {
        es: {
            nombre: 'El nombre ',
            apellido: 'El apellido ',
            edad: 'La edad ',
            required: ' es obligatorio ',
            minLength: ' debe tener al menos 3 letras ',
            lettersOnly: ' solo se permiten letras y espacios ',
            edadMin: 'La edad mínima es 5 años ',
            pierna: 'Debes seleccionar una pierna ',
            categoria: 'Debes seleccionar una categoría ',
            email: 'Formato de email inválido '
        },
        en: {
            nombre: 'The name ',
            apellido: 'The last name ',
            edad: 'The age ',
            required: 'is required',
            minLength: 'must be at least 3 letters ',
            lettersOnly: 'only letters and spaces are allowed ',
            edadMin: 'Minimum age is 5 years ',
            pierna: 'You must select a leg ',
            categoria: 'You must select a category ',
            email: 'Invalid email format '
        },
        jp: {
            nombre: '名前 ',
            apellido: '姓 ',
            edad: '年齢 ',
            required: 'は必須です ',
            minLength: 'は少なくとも3文字必要です ',
            lettersOnly: 'は文字とスペースのみ使用できます ',
            edadMin: '最低年齢は5歳です ',
            pierna: '利き足を選択してください',
            categoria: 'カテゴリーを選択してください ',
            email: '無効なメール形式です '
        }
    };




    form.addEventListener('submit', function (event) {
        let valid = true;

        // --- Nombre ---
        const nombre = form.querySelector('[name="nombre"]');
        const errorNombre = form.querySelector('#error-nombre');
        if (nombre.value.trim() === '') {
            errorNombre.textContent = messages[lang].nombre + messages[lang].required;
            valid = false;
        } else if (nombre.value.length < 3) {
            errorNombre.textContent = messages[lang].nombre + messages[lang].minLength;
            valid = false;
        } else if (!/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/.test(nombre.value)) {
            errorNombre.textContent = messages[lang].nombre + messages[lang].lettersOnly;
            valid = false;
        } else {
            errorNombre.textContent = '';
        }

        // --- Apellido ---
        const apellido = form.querySelector('[name="apellido"]');
        const errorApellido = form.querySelector('#error-apellido');
        if (apellido.value.trim() === '') {
            errorApellido.textContent = messages[lang].apellido + messages[lang].required;
            valid = false;
        } else if (apellido.value.length < 3) {
            errorApellido.textContent = messages[lang].apellido + messages[lang].minLength;
            valid = false;
        } else if (!/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/.test(apellido.value)) {
            errorApellido.textContent = messages[lang].apellido + messages[lang].lettersOnly;
            valid = false;
        } else {
            errorApellido.textContent = '';
        }

        // --- Edad ---
        const edad = form.querySelector('[name="edad"]');
        const errorEdad = form.querySelector('#error-edad');
        if (edad.value === '') {
            errorEdad.textContent = messages[lang].edad + messages[lang].required;
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
            errorEmail.textContent = messages[lang].email + messages[lang].required;
            valid = false;
        } else if (!/^\S+@\S+\.\S+$/.test(email.value)) {
            errorEmail.textContent = messages[lang].email;
            valid = false;
        } else {
            errorEmail.textContent = '';
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

         if (!valid) {
            event.preventDefault(); // Evita enviar si hay errores
        }

    });
});
