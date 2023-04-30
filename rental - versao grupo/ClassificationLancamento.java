public  class ClassificationLancamento extends Classification {

  private int codigoDePreco;

  public ClassificationLancamento(int codigo){
    this.codigoDePreco = codigo;
  }
  public int getCodigoPreco(){
    return codigoDePreco;
  };

  public double getValorAluguel(int DiasAlugada){
    double valorCorrente=0;
    valorCorrente += DiasAlugada * 3;
    return valorCorrente;
  }

  public int givePontosAlugador(int DiasAlugada){
    int pontosDeAlugadorFrequente=1;
    if(DiasAlugada > 1) {
      pontosDeAlugadorFrequente++;
    }
    return pontosDeAlugadorFrequente;
  }


}