import { Button } from "@/components/Button";
import { InputForm } from "@/components/InputForm";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const navigate = useNavigate();

    const handleLogin = async () => {
        setErrorMessage("");
        try {
            const response = await fetch("http://localhost:8081/api/sistema/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ email, senha }),
            });

            if (!response.ok) {
                const errorData = await response.json();
                throw new Error(errorData.message || "Falha na autenticação");
            }

            const data = await response.json();
            console.log("Dados do login:", data);
            navigate("/");
        } catch (error) {
            if (error instanceof Error) {
                setErrorMessage(error.message);
            } else {
                setErrorMessage("Ocorreu um erro inesperado.");
            }
        }

    };

    const irParaCadastro = () => {
        navigate('/cadastro');
    }


    return (
        <div className="login">
            <form
                className="p-5 flex flex-col min-w-2/4"
                onSubmit={(e) => {
                    e.preventDefault();
                    handleLogin();
                }}
            >
                <h1 className="text-center font-medium text-[1.75rem]">Login</h1>
                <p className="text-center font-medium text-[1.25rem]">
                    Entrar com a sua conta
                </p>

                <InputForm
                    label="Email"
                    placeholder="Email"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail((e.target as HTMLInputElement).value)}
                    required
                />
                <InputForm
                    label="Senha"
                    placeholder="Digite sua senha"
                    id="password"
                    type="password"
                    value={senha}
                    onChange={(e) => setSenha((e.target as HTMLInputElement).value)}
                />

                {errorMessage && <p className="text-red-500">{errorMessage}</p>}

                <Button type="submit" label="Login"/>

                <p className="pl-5 text-start text-[1.2rem]">
                    Não tem uma conta?
                    <Button className="bg-white text-[#091E3E] w-1xs border-4 border-[#C78E00]"
                            label="Cadastrar"
                            onClick={irParaCadastro}/>
                </p>
            </form>

              <div className="relative min-w-2/4 h-auto max-w-md ms-aut h-screen overflow-hidden">
                <img
                src="./src/vectors/pataVetor.svg"
                alt="Imagem de fundo"
                className="w-[120%] h-[120%] object-cover"
                />

                <img
                src="./src/images/login/gatoCachorro.png"
                alt="Imagem sobreposta"
                className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 scale-x-[-1]"
                />
            </div>
        </div>
    );
}
