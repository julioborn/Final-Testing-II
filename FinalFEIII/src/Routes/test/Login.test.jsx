import { render, screen } from '@testing-library/react';
import Login from '../Login';

test('Renderizado del Login', () => {
    render(<Login />);
    const botonEmail = screen.getByPlaceholderText('Correo');
    const botonPassword = screen.getByPlaceholderText('Contraseña');
    const botonSubmit = screen.getByRole("button", { name: 'Iniciar sesión' })

    expect(botonEmail).toBeInTheDocument();
    expect(botonPassword).toBeInTheDocument();
    expect(botonSubmit).toBeInTheDocument();
});

