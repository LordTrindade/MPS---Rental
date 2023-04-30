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



  public String extrato(){
    final String fimDeLinha = System.getProperty("line.separator");
    double valorTotal = 0.0;
    int pontosDeAlugadorFrequente = 0;
    Iterator alugueis = TapesAlugadas.iterator();
    String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
    while(alugueis.hasNext()) {
      double valorCorrente = 0.0;
      Rent cada = (Rent)alugueis.next();
      valorCorrente = calculaExtrato(cada);
      resultado += "\t" + cada.getTape().getTitulo() + "\t" + valorCorrente + fimDeLinha;
    }
    valorTotal = calculaExtratoTotal();
    pontosDeAlugadorFrequente = givePontosAlugadorTotal();
    resultado += "Valor total devido: " + valorTotal + fimDeLinha;
    resultado += "Voce acumulou " + pontosDeAlugadorFrequente +
            " pontos de alugador frequente";
    return resultado;
  }


  public String extratoHTML(){
    final String fimDeLinha = System.getProperty("line.separator");
    double valorTotal = 0.0;
    int pontosDeAlugadorFrequente = 0;
    Iterator alugueis = TapesAlugadas.iterator();
    String resultado = "<h1>"+"Registro de Alugueis de " + getNome() + "</h1>"+fimDeLinha;
    while(alugueis.hasNext()) {
      double valorCorrente = 0.0;
      Rent cada = (Rent)alugueis.next();
      valorCorrente = calculaExtrato(cada);
      resultado += "<p>" + "\t" +cada.getTape().getTitulo() + "\t" + valorCorrente +"</p>" + fimDeLinha;
    }
    valorTotal = calculaExtratoTotal();
    pontosDeAlugadorFrequente = givePontosAlugadorTotal();
    resultado += "<p>"+"Valor total devido: " + valorTotal+"</p>" + fimDeLinha;
    resultado +="<p>"+ "Voce acumulou " + pontosDeAlugadorFrequente +
            " pontos de alugador frequente"+"</p>";
    return resultado;
  }


  public double calculaExtrato(Rent cada){

    return (cada.getValorAluguel());
  }

  public double calculaExtratoTotal(){
    double valorCorrente = 0;
    Iterator alugueis = TapesAlugadas.iterator();
    while(alugueis.hasNext()) {
      Rent cada = (Rent)alugueis.next();
      valorCorrente+= calculaExtrato(cada);
    }
    return valorCorrente;
  }

  public int givePontosAlugador(Rent cada){
    return cada.givePontosAlugador();
  }

  public int givePontosAlugadorTotal(){
    int pontosDeAlugadorFrequente=  0;
    Iterator alugueis = TapesAlugadas.iterator();
    while(alugueis.hasNext()) {
      Rent cada = (Rent)alugueis.next();
      pontosDeAlugadorFrequente+= givePontosAlugador(cada);
    }

    return pontosDeAlugadorFrequente;
  }

}
