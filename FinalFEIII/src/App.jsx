import Home from "./Routes/Home"
import Detail from "./Routes/Detail"
import Contact from "./Routes/Contact"
import Footer from "./Components/Footer";
import Navbar from "./Components/Navbar";
import { useContextGlobal } from "./Components/utils/global.context";
import { Route, Routes } from "react-router-dom"
import Favs from "./Routes/Favs";
import React, { useState } from "react";
import Login from "./Routes/Login";

function App() {
    const { state } = useContextGlobal()
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const handleLogin = (email, password) => {
        const expectedEmail = 'admin@admin.com';
        const expectedPassword = 'admin123';
        if (email === expectedEmail && password === expectedPassword) {
            setIsLoggedIn(true);
        } else {
            window.alert('Correo electrónico o contraseña incorrectos');
        }
    };

    return (
        <div className={"App " + state.theme}>
            {!isLoggedIn && <Login onLogin={handleLogin} />}
            {isLoggedIn && (
                <>
                    <Navbar />
                    <Routes>
                        <Route path='/home' element={<Home />} />
                        <Route path='/dentist/:id' element={<Detail />} />
                        <Route path='/contacto' element={<Contact />} />
                        <Route path="/favs" element={<Favs />} />
                        <Route path="/" element={<Home />} />
                    </Routes>
                    <Footer />
                </>
            )}
        </div>
    );
}

export default App;

