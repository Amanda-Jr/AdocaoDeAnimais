import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './pages/Cadastro/index.css'
import './pages/Login/index.css'
import { BrowserRouter, Routes, Route } from "react-router";
import Cadastro from './pages/Cadastro/App.tsx'
import Home from './pages/Home/Home.tsx';

import './pages/globals.css'
import Login from './pages/Login/App.tsx';
import { Header } from "./components/Header";
import { Footer } from "./components/Footer";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <Header />
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
    <Footer />
  </StrictMode>
);
