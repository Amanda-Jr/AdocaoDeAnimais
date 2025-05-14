import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './pages/Cadastro/index.css'
import { BrowserRouter, Routes, Route } from "react-router";
import Cadastro from './pages/Cadastro/App.tsx'
import Home from './pages/Home/Home.tsx';

import './pages/globals.css'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/cadastro" element={<Cadastro />} />
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
