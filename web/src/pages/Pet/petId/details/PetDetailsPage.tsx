import type { Animal } from "@/@types/Animal";
import { AnimalsSection } from "@/components/AnimalsSection";
import { Button } from "@/components/Button";
import { useParams } from "react-router";

enum ANIMAL_AGE_LABEL {
  adult = "Adulto",
  puppy = "Filhote",
}

enum ANIMAL_SIZE_LABEL {
  small = "Pequeno",
  medium = "Médio",
  large = "Grande",
}

export function PetDetailsPage() {
  // Obtendo o ID do animal da URL
  const { petId } = useParams();

  // Faltando informações, não sei o nome dos campos retornados no BD
  const testeAnimal = {
    age: "adult",
    image: "/img-card-2.png",
    location: "São Paulo",
    name: "Atena",
    size: "medium",
  } as Animal;

  return (
    <div className="mt-4">
      <section className="flex justify-center bg-[url('/bg-pet-details.png')] py-6 mb-4">
        <div>
          <img
            src="/img-card-2.png"
            alt={testeAnimal.name}
            className="w-full h-full aspect-square object-cover"
          />
        </div>
        <div className="bg-white text-center w-sm h-md px-10 py-6">
          <h1 className="font-semibold">
            <span>{testeAnimal.name}</span>, <span>6 meses</span> -{" "}
            <span>{testeAnimal.location}</span>, <span>SP</span>
          </h1>
          <p className="font-light">
            Golden Retriever -{" "}
            <span>Porte {ANIMAL_SIZE_LABEL[testeAnimal.size]}</span> |{" "}
            <span>{ANIMAL_AGE_LABEL[testeAnimal.age]}</span>{" "}
          </p>
          <p className="font-light">Vacinado | Castrado</p>
          <p className="text-sm my-6">
            Bom dia pessoa, meu nome é Atena, tenho apenas 6 meses de vida e fui
            resgatada pela ONG Adopets. Sou carinhosa e procuro uma casa e uma
            família para compartilhar todo meu amor e carinho, será que você tio
            ou tia que esta lendo minha mensagem pode me levar para sua casa?
          </p>
          <Button label="Adotar" className="mt-0 py-3" />
        </div>
      </section>
      <AnimalsSection />
    </div>
  );
}
