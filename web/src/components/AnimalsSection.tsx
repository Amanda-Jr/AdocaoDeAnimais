import { AdoptionList } from "./AdoptionList";

export function AnimalsSection() {
  return (
    <section className="bg-[url('/background-adoption.png')] py-20 bg-cover bg-top flex flex-col items-center just gap-5">
      <h2 className="font-extrabold text-3xl text-white">Adote</h2>
      <AdoptionList />
    </section>
  );
}
