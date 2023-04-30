public class Tape {
  public static final int NORMAL = 0;
  public static final int LANCAMENTO = 1;
  public static final int INFANTIL = 2;

  private String titulo;
  private int codigoDePreco;
  private Classification classification;
  public Tape(String titulo, int codigoDePreco) {
    this.titulo = titulo;
    this.codigoDePreco = codigoDePreco;
     setCodigoDePreco(codigoDePreco);
  }

  public String getTitulo() {
    return titulo;
  }


  public int getCodigoDePreco() {
    //return codigoDePreco;
    return classification.getCodigoPreco();
  }

  public void setCodigoDePreco(int codigoDePreco) {
    switch(codigoDePreco) {
      case NORMAL:
       this.classification = new ClassificationNormal(NORMAL);
        break;
      case LANCAMENTO:
        this.classification = new ClassificationLancamento(LANCAMENTO);
        break;
      case Tape.INFANTIL:
        this.classification = new ClassificationInfantil(INFANTIL);
        break;

    } //switch
  }



  public double getValorAluguel(int DiasAlugada){
    double valorCorrente=0;
    valorCorrente = classification.getValorAluguel(DiasAlugada);
    return valorCorrente;
  }


  public int givePontosAlugador(int DiasAlugada){
    return classification.givePontosAlugador(DiasAlugada);
  }


}
