import { useState } from "react";
import axios from "axios";
import { Button } from "@/components/Button";
import { InputForm } from "@/components/InputForm";
import { useNavigate } from "react-router-dom";

const api = axios.create({
  baseURL: "http://localhost:8081/api",
  headers: {
    Authorization: "Basic " + btoa("admin:admin"),
    "Content-Type": "application/json",
  },
});

export default function Cadastro() {
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    tel: "",
    password: "",
  });

  const navigate = useNavigate();
  const [errorMessage, setErrorMessage] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
    setFormData({ ...formData, [e.target.id]: e.target.value });
  }

  const irParaLogin = () => {
    navigate('/login');
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    // Validação: verifica se algum campo está vazio
    if (
        !formData.username.trim() ||
        !formData.email.trim() ||
        !formData.tel.trim() ||
        !formData.password.trim()
    ) {
      setErrorMessage("Por favor, preencha todos os campos!");
      setSuccessMessage("");
      return; // Interrompe o envio dos dados se houver campos vazios
    }

    try {
      const response = await api.post("/adotante/cadastro", {
        nome: formData.username,
        email: formData.email,
        telefone: formData.tel,
        senha: formData.password,
      });
      console.log("Cadastro realizado:", response.data);
      setSuccessMessage("Cadastro realizado com sucesso!");
      setErrorMessage("");
    } catch (error: unknown) {
      console.error("Erro ao cadastrar:", error);

      if (axios.isAxiosError(error) && error.response?.data?.message) {
        setErrorMessage(error.response.data.message);
      } else if (error instanceof Error) {
        setErrorMessage(error.message);
      } else {
        setErrorMessage("Erro ao cadastrar. Por favor, verifique os dados e tente novamente.");
      }
      setSuccessMessage("");
    }
  }


  return (
      <div className="cadastro">
        <form className="p-5 flex flex-col min-w-2/4" onSubmit={handleSubmit}>
          <h1 className="text-center font-medium text-[1.75rem]">Cadastrar</h1>
          <p className="text-center font-medium text-[1.25rem]">Criar nova conta</p>
          <InputForm
              label="Nome de usuário"
              placeholder="Digite o nome de usuário"
              id="username"
              onChange={handleChange}
              value={formData.username}
              required
          />
          <InputForm
              label="Email"
              placeholder="Email"
              id="email"
              onChange={handleChange}
              value={formData.email}
          />
          <InputForm
              label="Número de Telefone"
              placeholder="Digite o seu número de Telefone"
              id="tel"
              onChange={handleChange}
              value={formData.tel}
          />
          <InputForm
              label="Senha"
              placeholder="Digite sua senha"
              id="password"
              onChange={handleChange}
              value={formData.password}
          />
          <Button label="Cadastrar" type="submit" />
          <p className="pl-5 text-start text-[1.2rem]">
            Já tem uma conta?{" "}
            <Button
                className="bg-white text-[#091E3E] w-1xs border-4 border-[#C78E00]"
                label="Login"
                onClick={irParaLogin}
            />
          </p>
        </form>
        {errorMessage && (
            <p style={{ color: "red", marginTop: "1rem" }}>{errorMessage}</p>
        )}
        {successMessage && (
            <p style={{ color: "green", marginTop: "1rem" }}>{successMessage}</p>
        )}
        <img
            className="h-auto max-w-md ms-auto"
            src="./src/images/cadastro/gatoCadastro.png"
            alt="Descrição da imagem"
        />
      </div>
  );
}
