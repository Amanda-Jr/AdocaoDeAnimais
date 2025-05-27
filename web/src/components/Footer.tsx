import { Button } from "./Button";

export function Footer() {
  return (
    
    <footer className="">
      
      <section className="bg-secondary text-white text-center px-8 py-16 relative">
        <div className="max-w-3xl mx-auto space-y-6">
          
          <div className="flex flex-row gap-10">

            <p className="text-xl font-bold text-justify">
              Contribua da forma que puder para que esses animais tenham alimento ou uma nova casa.<br />
            </p>

            <div className="flex flex-col justify-center gap-4 items-center flex-wrap">
              <Button label="FAÇA UMA DOAÇÃO →" className="bg-white text-[#001f77] font-semibold px-4 py-2 mt-0 rounded-lg shadow hover:bg-gray-100 transition" />
              <a href="#" className="underline font-semibold">
                OU ADOTE →
              </a>
            </div>

          </div>


          <div className="flex justify-center items-center gap-2 pt-8">
            <a href="/">
              <img src="/logo-header.png" alt="AdoPets Logo" />
            </a>
          </div>
        </div>
    </section>

    <div className="text-light-text flex flex-row items-center relative px-14 py-3">
      <div className="flex gap-4 items-center font-medium">
        <a target="_blank" rel="noopener noreferrer" href="https://www.x.com">
          <img className="size-8" src="./src/icons/twitter.png" alt="Twitter" />
        </a>
        <a target="_blank" rel="noopener noreferrer" href="https://www.facebook.com">
          <img className="size-8" src="./src/icons/facebook.png" alt="Facebook" />
        </a>
        <a target="_blank" rel="noopener noreferrer" href="https://www.instagram.com">
          <img className="size-8" src="./src/icons/instagram.png" alt="Instagram" />
        </a>
        
      </div>

      <a href="#" className="text-gray-text absolute left-1/2 transform -translate-x-1/2 font-medium underline">
        TERMOS DE USO
      </a>
    </div>
      

      
    </footer>
  );
}