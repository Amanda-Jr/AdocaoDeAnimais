import { AdoptionList } from "@/components/AdoptionList";
import { AboutUs } from "@/components/home/AboutUs";
import { HowYouCanHelp } from "@/components/home/HowYouCanHelp";
import { MainSection } from "@/components/home/MainSection";

export default function Home() {
  return (
    <main>
      <MainSection />
      <section className="flex flex-col h-full">
        <AboutUs />
        <HowYouCanHelp />
      </section>
      <section className="bg-[url('/background-adoption.png')] py-20 bg-cover bg-top flex flex-col items-center just gap-5">
        <h2 className="font-extrabold text-3xl text-white">Adote</h2>
        <AdoptionList />
      </section>
    </main>
  );
}
