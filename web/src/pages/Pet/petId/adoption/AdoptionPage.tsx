import { Button } from "@/components/Button";
import { InputForm } from "@/components/InputForm";
import { useForm } from "react-hook-form";
import { useParams } from "react-router";

type AdoptionFormInputs = {
  qtdPeopleInHome: number;
  income: string;
  otherPets: string;
  walkAvailability: string;
  documentType: string;
  document: string;
  address: {
    zipCode: string;
    city: string;
    state: string;
    neighborhood: string;
    street: string;
  };
};

export function AdoptionPage() {
  const { register, handleSubmit } = useForm<AdoptionFormInputs>();
  const { petId } = useParams<{ petId:string }>();
  // id do adotante deve ser pego pelo cookie, criado no momento da autenticação

  function onSubmit(data: AdoptionFormInputs) {
    console.log(data);
    // Aqui você pode enviar os dados para o servidor ou fazer outra ação
  }

  return (
    <div className="p-4 flex flex-col items-center">
      <h1 className="font-bold text-xl text-secondary mb-2">
        Formulário de solicitação de adoção
      </h1>
      <form
        className="**:placeholder:font-normal flex flex-col max-w-xl border-t"
        onSubmit={handleSubmit(onSubmit)}
      >
        <p className="font-bold text-secondary mt-3 mb-2">Disponibilidade</p>
        <div className="flex flex-wrap justify-between">
          <InputForm
            type="number"
            id="qtdPeopleInHome"
            placeholder="Ex. 2"
            min={1}
            label="Qtd. de pessoas na casa"
            {...register("qtdPeopleInHome", { required: true })}
          />
          <InputForm
            type="text"
            id="income"
            placeholder="Ex. 2000"
            label="Renda"
            {...register("income", { required: true })}
          />
          <InputForm
            type="text"
            id="otherPets"
            placeholder="Ex. 1 Cachorro, 1 Gato"
            label="Outros animais que possui"
            {...register("otherPets", { required: true })}
          />
          <InputForm
            type="text"
            id="walkAvailability"
            placeholder="Ex. 3 vezes por semana"
            label="Disponibilidade para passeio"
            {...register("walkAvailability", { required: true })}
          />
        </div>
        <p className="font-bold text-secondary mt-6 mb-2">Identificação</p>
        <div className="flex gap-6">
          <div className="mt-1.5">
            <label
              htmlFor="documentType"
              className="mr-2 font-semibold text-primary"
            >
              Tipo do documento:
            </label>
            <select
              id="documentType"
              className="text-primary block mt-1.5"
              {...register("documentType", { required: true })}
            >
              <option value="cpf">CPF</option>
              <option value="rg">RG</option>
              <option value="cnh">CNH</option>
              <option value="carteiraTrabalho">Carteira de Trabalho</option>
            </select>
          </div>

          <InputForm
            type="text"
            id="document"
            placeholder="Ex. 37481639600"
            label="Número do documento"
            {...register("document", { required: true })}
          />
        </div>
        <p className="font-bold text-secondary mt-6 mb-1">Endereço</p>
        <div className="flex flex-wrap justify-between">
          <InputForm
            type="text"
            id="zipCode"
            placeholder="Ex. 12345-678"
            label="CEP"
            {...register("address.zipCode", { required: true })}
          />
          <InputForm
            type="text"
            id="city"
            placeholder="Ex. São Paulo"
            label="Cidade"
            {...register("address.city", { required: true })}
          />
          <InputForm
            type="text"
            id="state"
            placeholder="Ex. SP"
            label="Estado"
            {...register("address.state", { required: true })}
          />
          <InputForm
            type="text"
            id="neighborhood"
            placeholder="Ex. Jardim das Flores"
            label="Bairro"
            {...register("address.neighborhood", { required: true })}
          />
          <InputForm
            type="text"
            id="street"
            label="Endereço"
            placeholder="Ex. Rua das Flores, 123"
            {...register("address.street", { required: true })}
          />
        </div>
        <Button label="Solicitar Adoção" type="submit" className="p-4" />
      </form>
    </div>
  );
}
