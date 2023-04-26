import java.util.*;

public class Client {
  private String nome;
  private Collection TapesAlugadas = new Vector();

  public Client(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void adicionaRent(Rent Rent) {
    TapesAlugadas.add(Rent);
  }

  public String extrato() {
    final String fimDeLinha = System.getProperty("line.separator");
    double valorTotal = 0.0;
    int pontosDeAlugadorFrequente = 0;
    Iterator alugueis = TapesAlugadas.iterator();
    String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;

    while(alugueis.hasNext()) {
      double valorCorrente = 0.0;
      Rent cada = (Rent)alugueis.next();
      valorCorrente += calcula_preco(cada);

      // trata de pontos de alugador frequente
      pontosDeAlugadorFrequente++;
      // adiciona bonus para Rent de um lan�amento por pelo menos 2 dias
      if(dar_ponto_alugador(cada)){
        pontosDeAlugadorFrequente++;
      }

      // mostra valores para este Rent
      resultado += add_rent_resultado(cada,valorCorrente,fimDeLinha);
      valorTotal += valorCorrente;
    } // while

    resultado += add_rodape_resultado(valorTotal,fimDeLinha,pontosDeAlugadorFrequente);
    return resultado;
  }

  public double calcula_preco(Rent rent){
    double valor = 0;
    switch(rent.getCodigoPreco()) {
      case Tape.NORMAL:
        valor += 2;
        if(rent.getDiasAlugada() > 2) {
          valor += (rent.getDiasAlugada() - 2) * 1.5;
        }
        break;
      case Tape.LANCAMENTO:
        valor += rent.getDiasAlugada() * 3;
        break;
      case Tape.INFANTIL:
        valor += 1.5;
        if(rent.getDiasAlugada() > 3) {
          valor += (rent.getDiasAlugada() - 3) * 1.5;
        }
        break;
    }
    return valor;
  }

  public boolean dar_ponto_alugador(Rent rent){
    /*
    if(rent.getTape().getCodigoDePreco() == Tape.LANCAMENTO &&
            rent.getDiasAlugada() > 1){
      return true;
    }
    return false; */

    if((checa_lancamento(rent))&&(checa_dias_aluguel(rent,1))){
      return true;
    }
    return false;
  }

  public boolean checa_lancamento(Rent rent){
    if(rent.ehLancamento()){
      return true;
    }
    return false;
  }

  public boolean checa_dias_aluguel(Rent rent, int dias){
    /*
    if(rent.getDiasAlugada() > dias){
      return true;
    }
    return false;
     */
    return (rent.boolDiasAlugada(dias));
  }

  public String add_rent_resultado(Rent rent, double valorCorrente, String fimDeLinha){
    String resultado = "";
    resultado += "\t" + rent.getTape().getTitulo() + "\t" + valorCorrente + fimDeLinha;
    return resultado;
  }

  public String add_rodape_resultado(double valorTotal, String fimDeLinha, int pontosDeAlugadorFrequente){
    String resultado = "";
    resultado += "Valor total devido: " + valorTotal + fimDeLinha;
    resultado += "Voce acumulou " + pontosDeAlugadorFrequente +
            " pontos de alugador frequente";
    return resultado;
  }

}

