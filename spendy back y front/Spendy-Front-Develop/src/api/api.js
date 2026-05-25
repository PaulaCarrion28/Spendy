// Definimos la URL base del backend
// Aquí es donde vive tu servidor (puede ser local o en la nube)
const BASE_URL = "https://jsonplaceholder.typicode.com"


// Creamos un objeto que contiene todos los endpoints de la app
// Esto evita repetir URLs en todo el proyecto
export const endpoints = {
  login: `${BASE_URL}/posts`,     // Simulación de login
  register: `${BASE_URL}/posts`,  // Simulación de registro
  gastos: `${BASE_URL}/posts`     // Simulación de guardar gastos
}


// =============================
// FUNCIÓN PARA LOGIN
// =============================

// Creamos una función asíncrona para hacer petición al backend
export const loginRequest = async (data) => {

  // fetch hace la petición HTTP
  const response = await fetch(endpoints.login, {

    method: "POST", // Tipo de petición (enviar datos)

    headers: {
      "Content-Type": "application/json" // Indicamos que enviamos JSON
    },

    // Convertimos el objeto JS a JSON
    body: JSON.stringify(data)
  })

  // Convertimos la respuesta del servidor a JSON
  const result = await response.json()

  // Retornamos la respuesta para usarla en el componente
  return result
}


// =============================
// FUNCIÓN PARA REGISTRO
// =============================
export const registerRequest = async (data) => {

  const response = await fetch(endpoints.register, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
  })

  const result = await response.json()

  return result
}


// =============================
// FUNCIÓN PARA CREAR GASTO
// =============================
export const createExpense = async (data) => {

  const response = await fetch(endpoints.gastos, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
  })

  const result = await response.json()

  return result
}