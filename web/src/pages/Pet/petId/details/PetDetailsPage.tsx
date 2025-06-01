import type { Animal } from "@/@types/Animal";
import { AnimalsSection } from "@/components/AnimalsSection";
import { Button } from "@/components/Button";
import { Link, useParams } from "react-router";
import { useEffect, useState } from "react";

enum ANIMAL_AGE_LABEL {
  adult = "Adulto",
  puppy = "Filhote",
}

enum ANIMAL_SIZE_LABEL {
  small = "Pequeno",
  medium = "Médio",
  large = "Grande",
}

function calcularIdade(dataNascimento: string): string {
  const nascimento = new Date(dataNascimento);
  const hoje = new Date();

  let anos = hoje.getFullYear() - nascimento.getFullYear();
  let meses = hoje.getMonth() - nascimento.getMonth();

  if (meses < 0) {
    anos--;
    meses += 12;
  }

  if (hoje.getDate() < nascimento.getDate()) {
    meses--;
    if (meses < 0) {
      anos--;
      meses += 12;
    }
  }

  let resultado = "";
  if (anos > 0) {
    resultado += `${anos} ano${anos > 1 ? "s" : ""}`;
  }
  if (meses > 0) {
    if (resultado) {
      resultado += " e ";
    }
    resultado += `${meses} mes${meses > 1 ? "es" : ""}`;
  }

  return resultado || "0 mes";
}

export function PetDetailsPage() {
  const { petId } = useParams<{ petId: string }>();

  const [animal, setAnimal] = useState<Animal | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string>("");

  useEffect(() => {
    if (petId) {
      fetch(`http://localhost:8081/api/sistema/animal/${petId}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Erro ao buscar animal");
          }
          return response.json();
        })
        .then((data: Animal) => {
          setAnimal(data);
          setLoading(false);
        })
        .catch((err) => {
          console.error(err);
          setError("Erro ao carregar dados do animal.");
          setLoading(false);
        });
    }
  }, [petId]);

  if (loading) {
    return <div>Carregando...</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  if (!animal) {
    return <div>Animal não encontrado</div>;
  }

  return (
    <div className="mt-4">
      <section className="flex justify-center bg-[url('/bg-pet-details.png')] bg-cover py-6 mb-4">
        <div>
          <img
            src={animal.image}
            alt={animal.name}
            className="max-w-md aspect-square object-cover"
          />
        </div>
        <div className="bg-white text-center w-fit h-md px-10 py-6 flex flex-col justify-center text-[1.1rem]">
          <h1 className="font-semibold text-[1.2rem]">
            <span>{animal.name}</span>,{" "}
            <span>
              {animal.dataNascimento
                ? calcularIdade(animal.dataNascimento)
                : animal.age}
            </span>{" "}
            - <span>{animal.location}</span>, <span>SP</span>
          </h1>
          <p className="font-light">
            <span>Porte {ANIMAL_SIZE_LABEL[animal.size]}</span> |{" "}
            <span>{ANIMAL_AGE_LABEL[animal.age]}</span>{" "}
          </p>
          <p className="font-light">
            {animal.vacinado ? "Vacinado" : "Não Vacinado"} |{" "}
            {animal.castrado ? "Castrado" : "Não Castrado"}
          </p>
          <p className="text-[1.1rem] my-6">{animal.resumo}</p>
          <Link to={`/pet/${petId}/adoption`}>
            <Button label="Adotar" className="mt-0 py-3" />
          </Link>
        </div>
      </section>
      <AnimalsSection />
    </div>
  );
}
