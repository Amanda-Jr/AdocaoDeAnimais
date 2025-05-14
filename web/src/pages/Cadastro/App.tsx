export default function Cadastro() {
  
  return (
    <div className="cadastro">
      <form  className="formulario">
        <h1>Cadastrar</h1>
        <p>Criar nova conta</p>
        <div className="input-field">
          <input type="username" placeholder="Digite o nome de usuario"/>
        </div>
        <div className="input-field">
          <input type="email" placeholder="E-mail"/>
        </div>
        <div className="input-field">
          <input type="tel" id="phone" placeholder="Telefone" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"/>
        </div>
        <div className="input-field">
          <input type="password" placeholder="Senha"/>
        </div>
        <button>Cadastrar</button>
        <p>Ja tem uma conta? <a href="#">Entrar</a> </p>
        
      </form>
      
    </div>
  )
}
