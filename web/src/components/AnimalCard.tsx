import { Mars, Venus } from "lucide-react";

//<Venus className="text-[#FF56EE]" />

export function AnimalCard() {
  return (
    <div className="text-center text-black bg-[#F2F2F2] max-w-min max-h-min rounded-2xl overflow-hidden hover:scale-105 transition-transform duration-500">
      <img src="/animal-card-example.png" alt="Imagem do animal" className="cursor-pointer" />
      <div className="py-3 px-7 text-[0.9rem]">
        <p className="font-extrabold text-nowrap text-[1.2rem]">
          Rubinho <Mars className="text-[#299EF3] inline" />
        </p>
        <p className="text-nowrap">
          Porte Médio <span>●</span> Filhote
        </p>
        <p>São Paulo</p>
      </div>
    </div>
  );
}
