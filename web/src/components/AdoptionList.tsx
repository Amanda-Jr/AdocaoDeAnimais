import { useForm } from "react-hook-form";
import type { SubmitHandler } from "react-hook-form";
import axios from "axios";
import { useEffect, useState } from "react";

import { AnimalCard } from "./AnimalCard";
import { Button } from "./Button";
import {Link} from "react-router-dom";

type AdoptionFilterProps = {
  animal?: "dogs" | "cats" | "all";
  size?: "small" | "medium" | "large";
  age?: "puppy" | "adult";
  location?: string;
};

type Animal = {
  id: number;
  animal: "dogs" | "cats";
  size: "small" | "medium" | "large";
  age: "puppy" | "adult";
  location: string;
  name: string;
  image: string;
};

export function AdoptionList() {
    const { register, handleSubmit } = useForm<AdoptionFilterProps>({
        defaultValues: {
            animal: "all",
            size: undefined,
            age: undefined,
            location: ""
        }
    });
    const [animais, setAnimais] = useState<Animal[]>([]);

  useEffect(() => {
    axios
        .get("http://localhost:8081/api/sistema/listar")
        .then((response) => {
          setAnimais(response.data);
        })
        .catch((error) => {
          console.error("Erro ao buscar animais: ", error);
        });
  }, []);

    const handleFormSubmit: SubmitHandler<AdoptionFilterProps> = (data) => {
        console.log("Dados do formulário:", data);
        axios
            .get("http://localhost:8081/api/sistema/filtro", { params: data })
            .then((response) => {
                setAnimais(response.data);
            })
            .catch((error) => {
                console.error("Erro ao buscar animais filtrados: ", error);
            });
    };


    return (
      <div className="text-white flex flex-col items-center gap-10">
        <form
            onSubmit={handleSubmit(handleFormSubmit)}
            className="w-fit rounded-lg overflow-hidden"
        >
          <div className="flex gap-1">
            <input
                type="radio"
                value="dogs"
                id="dogs"
                className="hidden peer/dogs"
                {...register("animal")}
            />
            <label
                htmlFor="dogs"
                className="rounded-lg bg-secondary px-5 py-1 rounded-b-none peer-checked/dogs:bg-tertiary cursor-pointer hover:bg-tertiary"
            >
              Cachorro
            </label>

            <input
                type="radio"
                value="cats"
                id="cats"
                className="hidden peer/cats"
                {...register("animal")}
            />
            <label
                htmlFor="cats"
                className="rounded-lg bg-secondary px-5 py-1 rounded-b-none peer-checked/cats:bg-tertiary cursor-pointer hover:bg-tertiary"
            >
              Gato
            </label>

            <input
                type="radio"
                value="all"
                id="all"
                className="hidden peer/all"
                defaultChecked
                {...register("animal")}
            />
            <label
                htmlFor="all"
                className="rounded-lg bg-secondary px-5 py-1 rounded-b-none peer-checked/all:bg-tertiary cursor-pointer hover:bg-tertiary"
            >
              Todos
            </label>
          </div>

          <div className="bg-tertiary px-5 py-3 flex gap-4 rounded-lg rounded-tl-none">
            <select
                defaultValue=""
                className="bg-tertiary focus:outline-secondary hover:cursor-pointer hover:transform hover:scale-105 transition-all duration-200"
                {...register("size")}
            >
              <option value="small">Pequeno</option>
              <option value="medium">Médio</option>
              <option value="large">Grande</option>
              <option value="" defaultChecked>
                Porte
              </option>
            </select>

            <select
                defaultValue=""
                className="bg-tertiary focus:outline-secondary hover:cursor-pointer hover:scale-105 transition-all duration-200"
                {...register("age")}
            >
              <option value="puppy">Filhote</option>
              <option value="adult">Adulto</option>
              <option value="" defaultChecked>
                Idade
              </option>
            </select>

            <select
                defaultValue=""
                className="bg-tertiary focus:outline-secondary hover:cursor-pointer hover:scale-105 transition-all duration-200"
                {...register("location")}
            >
              <option value="São Paulo">São Paulo</option>
              <option value="" defaultChecked>
                Localização
              </option>
            </select>

            <Button
                type="submit"
                label="Pesquisar"
                className="bg-secondary hover:bg-secondary block w-fit h-fit py-1 rounded-sm px-3 mt-0 hover:transform hover:scale-105 transition-all duration-200"
            />
          </div>
        </form>
        <div className="flex gap-6 flex-wrap justify-center max-w-4/5">
          {animais.length ? (
              animais.map((animal) => (
                  <Link to={`/pet/${animal.id}/details`} key={animal.id}>
                    <AnimalCard {...animal} />
                  </Link>
              ))
          ) : (
              <p>Nenhum animal encontrado</p>
          )}
        </div>
      </div>
  );
}