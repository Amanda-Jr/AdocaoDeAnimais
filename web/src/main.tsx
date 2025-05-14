import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './pages/Cadastro/index.css'
import Cadastro from './pages/Cadastro/App.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <Cadastro />
  </StrictMode>,
)
