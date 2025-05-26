export function HowYouCanHelp() {
  return (
    <div className="flex flex-col items-center px-44 text-gray-text">
      <h2 className="font-extrabold text-3xl mb-2">Como você pode ajudar?</h2>
      <div className="flex justify-center items-start mt-10 gap-8">
        <div className="flex flex-1 flex-col">
          <img
            src="/img-card-1.png"
            alt="Doação de alimentos e Medicamentos"
            className="rounded-lg hover:scale-105 transition-transform duration-300"
          />
          <p className="text-[1.1rem] font-semibold py-2">
            Doação de alimentos e Medicamentos
          </p>
          <p>
            Sua doação de alimentos e medicamentos é essencial para o bem-estar
            dos animais. Contribua via PIX: chavepix@sosanimalrs.org ou entregue
            os itens diretamente em uma de nossas unidades. Toda ajuda faz a
            diferença!
          </p>
          <a href="" className="text-[#299EF3] font-bold text-sm mt-2">
            Doações {">"}
          </a>
          <a href="" className="text-[#299EF3] font-bold text-sm">
            Ler mais {">"}
          </a>
        </div>
        <div className="flex flex-1 flex-col">
          <img
            src="/img-card-2.png"
            alt="Lar temporário"
            className="rounded-lg hover:scale-105 transition-transform duration-300"
          />
          <p className="text-[1.1rem] font-semibold py-2">Lar temporário</p>
          <p>
            Ofereça um lar temporário para animais resgatados. Você proporciona
            um ambiente seguro e amoroso enquanto eles aguardam por uma adoção
            definitiva.
          </p>
          <a href="" className="text-[#299EF3] font-bold text-sm mt-2">
            Ler mais {">"}
          </a>
        </div>
        <div className="flex flex-1 flex-col">
          <img
            src="/img-card-3.png"
            alt="Adoção"
            className="rounded-lg hover:scale-105 transition-transform duration-300"
          />
          <p className="text-[1.1rem] font-semibold py-2">Adoção</p>
          <p>
            Adote um dos nossos peludos e ganhe um amigo fiel. Adotar é dar uma
            nova chance a um animal que só deseja carinho e um lar amoroso.
          </p>
          <a href="" className="text-[#299EF3] font-bold text-sm mt-2">
            Adote {">"}
          </a>
          <a href="" className="text-[#299EF3] font-bold text-sm">
            Ler mais {">"}
          </a>
        </div>
      </div>
    </div>
  );
}
