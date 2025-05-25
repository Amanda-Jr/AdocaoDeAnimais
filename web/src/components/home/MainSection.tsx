export function MainSection() {
  return (
    <div className="flex bg-[url(/cover-home.png)] bg-cover text-light-text justify-end items-center flex-1 h-full">
      <div className="flex-1 overflow-hidden">
        <img
          src="/dog-home.png"
          alt="cachorro"
          className="bg-left bg-cover hover:scale-105 transition-transform duration-500"
        />
      </div>
      <div className="px-2 flex flex-1 items-center h-full">
        <div className="max-w-xs flex flex-col gap-5 justify-center pb-30">
          <p className="font-semibold text-2xl">Com a sua ajuda</p>
          <h1 className="font-bold text-5xl">
            Nós podemos Salvar os animais que vivem na rua
          </h1>
          <p className="mt-1">
            Abandono de cães nas ruas é um problema real. Escolha adotar e dar a
            esses animais uma segunda chance. Faça a diferença, salve vidas.
          </p>
        </div>
      </div>
    </div>
  );
}
