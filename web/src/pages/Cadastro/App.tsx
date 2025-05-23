import { Button, InputForm } from "@/components/InputForm";

export default function Cadastro() {
  return (
    <div className="cadastro">
      <form className="p-5 flex flex-col min-w-2/4">
        <h1 className="text-center font-medium text-[1.75rem]">Cadastrar</h1>
        <p className="text-center font-medium text-[1.25rem]">
          Criar nova conta
        </p>
        <InputForm
          label="Nome de usuário"
          placeholder="Digite o nome de usuário"
          id="username"
        />
        <InputForm label="Email" placeholder="Email" id="email"/>
        <InputForm label="Numero de Telefone" placeholder="Digite o seu numero de Telefone" id="tel"/>
        <InputForm label="Senha" placeholder="Digite sua senha" id="password"/>
        <Button label="Cadastrar"/>
        <p className="pl-5 text-start text-[1.2rem]">Ja tem uma conta?  <Button className="bg-white text-[#091E3E] w-1xs border-4 border-[#C78E00]" label="Login"/></p>
        
      </form>
      <img className="ms-auto w-auto h-screen" src="./src/images/cadastro/gatoCadastro.png" alt="image description"></img>
      
    </div>
    
  );
  
}
