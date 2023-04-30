public  class ClassificationNormal extends Classification {

  private int codigoDePreco;

  public ClassificationNormal(int codigo){
    this.codigoDePreco = codigo;
  }
  public int getCodigoPreco(){
    return codigoDePreco;
  };
  public double getValorAluguel(int DiasAlugada){
    double valorCorrente=0;
    valorCorrente += 2;
    if(DiasAlugada > 2) {
      valorCorrente += (DiasAlugada - 2) * 1.5;
    }
    return valorCorrente;
  }

  public boolean ehLancamento(){
    return false;
  }

  public int givePontosAlugador(int DiasAlugada){
    int pontosDeAlugadorFrequente=1;
    return pontosDeAlugadorFrequente;
  }


}