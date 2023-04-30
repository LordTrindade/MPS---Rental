public  class ClassificationInfantil extends Classification {

  private int codigoDePreco;

  public ClassificationInfantil(int codigo){
    this.codigoDePreco = codigo;
  }
  public int getCodigoPreco(){
    return codigoDePreco;
  };

  public double getValorAluguel(int DiasAlugada){
    double valorCorrente=0;
    valorCorrente += 1.5;
    if(DiasAlugada > 3) {
      valorCorrente += (DiasAlugada - 3) * 1.5;
    }
    return valorCorrente;
  }
  public int givePontosAlugador(int DiasAlugada){
    int pontosDeAlugadorFrequente=1;
    return pontosDeAlugadorFrequente;
  }

}