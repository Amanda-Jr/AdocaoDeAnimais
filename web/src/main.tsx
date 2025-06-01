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
import { PetDetailsPage } from './pages/Pet/petId/details/PetDetailsPage.tsx';
import { AdoptionPage } from './pages/Pet/petId/adoption/AdoptionPage.tsx';

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <Header />
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/login" element={<Login />} />
        <Route path="/pet/:petId/details" element={<PetDetailsPage />} />
        <Route path="/pet/:petId/adoption" element={<AdoptionPage />} />
      </Routes>
    </BrowserRouter>
    <Footer />
  </StrictMode>
);
