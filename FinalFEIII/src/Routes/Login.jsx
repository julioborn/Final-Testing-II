import React, { useState } from 'react';
import dh from "../assets/DH.png"

function Login({ onLogin }) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    };
    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };
    const handleSubmit = (event) => {
        event.preventDefault();
        onLogin(email, password);
    };

    return (
        <div className="login-background">
            <form className='form-login' onSubmit={handleSubmit}>
                <h2>Login</h2>
                <label>
                    <input 
                    type="email" 
                    value={email} 
                    placeholder='Correo' 
                    onChange={handleEmailChange} 
                    autoComplete='email' 
                    required />
                </label>
                <label>
                    <input 
                    type="password" 
                    value={password} 
                    placeholder='Contraseña' 
                    onChange={handlePasswordChange} 
                    required />
                </label>
                <button type="submit">Iniciar sesión</button>
                <br />
                <img src={dh} />
            </form>
        </div>
    );
}

export default Login;
