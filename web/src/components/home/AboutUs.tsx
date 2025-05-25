import { Button } from "@/components/Button";

export function AboutUs() {
  return (
    <div className="flex flex-col items-center py-9">
      <div className="bg-primary flex text-light-text text-center w-3/5 items-center justify-center py-2 rounded px-4">
        <p className="font-semibold text-[1.2rem] px-6 border-r-2">
          Quem nós somos?
        </p>
        <p className="text-left font-semibold mx-4">
          A SOS Pets é uma ong que nasceu em 2024, com intuito de ajudar animais
          afetados pelas enchentes do Rio Grande do Sul.
        </p>
        <Button label="Saiba Mais" className="mt-0 border p-3" />
      </div>
      <div className="flex text-center gap-14 mt-9 text-gray-text">
        <div>
          <p className="font-bold text-3xl">10.000+</p>
          <p className="font-semibold">Animais resgatados</p>
        </div>
        <div>
          <p className="font-bold text-3xl">300+</p>
          <p className="font-semibold">Animais em processo de adoção</p>
        </div>
      </div>
    </div>
  );
}
