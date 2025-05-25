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
    </main>
  );
}
