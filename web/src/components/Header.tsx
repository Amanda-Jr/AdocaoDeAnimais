export function Header() {
  return (
    <header className="bg-secondary text-light-text flex flex-row justify-between relative px-14 py-3">
      <a href="/">
        <img src="/logo-header.png" alt="AdoPets Logo" />
      </a>
      <nav className="flex text-light-text gap-4 items-center font-medium">
        <a href="#" className="hover:text-white">
          Home
        </a>
        <a href="#" className="hover:text-white">
          Contato
        </a>
        <a href="#" className="hover:text-white">
          Doação
        </a>
        <a href="#" className="hover:text-white">
          Sobre
        </a>
        <a href="#" className="hover:text-white">
          Adotar
        </a>
        <a className="fill-blue-500 ml-5" href="/cadastro">
          <img className="size-8" src="./src/icons/conta.png" alt="Instagram" />
        </a>
      </nav>
    </header>
  );
}
