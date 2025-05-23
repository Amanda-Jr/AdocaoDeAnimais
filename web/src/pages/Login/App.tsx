import { Button, InputForm } from "@/components/InputForm";

export default function Login() {
  return (
    <div className="login">
      <form className="p-5 flex flex-col min-w-2/4">
        <h1 className="text-center font-medium text-[1.75rem]">Login</h1>
        <p className="text-center font-medium text-[1.25rem]">
          Entrar com a sua conta
        </p>
        <InputForm label="Email" placeholder="Email" id="email"/>
        <InputForm label="Senha" placeholder="Digite sua senha" id="password"/>
        <Button label="Login"/>
        <p className="pl-5 text-start text-[1.2rem]">Nao tem uma conta?  <Button className="bg-white text-[#091E3E] w-1xs border-4 border-[#C78E00]" label="Cadastrar"/></p>
        
      </form>
      <img className="h-auto max-w-md ms-auto" src="./src/vectors/pataVetor.svg" alt="image description"></img>
      <img className="h-auto max-w-md ms-auto" src="./src/images/login/gatoCachorro.png" alt="image description"></img>
      
    </div>
    
  );
  
}
