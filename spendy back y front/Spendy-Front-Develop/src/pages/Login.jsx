import React from 'react'
import Footer from '../components/Footer'
import "./Login.css";

const Login = () => {
  return (
    <>
      <div className="contenedor">

        <div className="formulario">
          <h2>Registro</h2>

          <form>
            <div className="input-group">
              <label>Nombre</label>
              <input type="text" placeholder="Ingresa tu nombre" />
            </div>

            <div className="input-group">
              <label>Correo</label>
              <input type="email" placeholder="Ingresa tu correo" />
            </div>

            <div className="input-group">
              <label>Contraseña</label>
              <input type="password" placeholder="Ingresa tu contraseña" />
            </div>

            <button type="submit">Guardar</button>
          </form>
        </div>
        
           <Footer />
      </div>

     
    </>
  )
}

export default Login