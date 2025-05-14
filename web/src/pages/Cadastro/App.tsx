import { InputForm } from "@/components/InputForm";

export default function Cadastro() {
  return (
    <div className="cadastro">
      <form className="p-5 flex flex-col min-w-3/4">
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
      </form>
    </div>
  );
}
