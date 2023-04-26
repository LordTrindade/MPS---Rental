public class Rent {
  private Tape Tape;
  private int diasAlugada;

  public Rent(Tape Tape, int diasAlugada) {
    this.Tape = Tape;
    this.diasAlugada = diasAlugada;
  }

  public Tape getTape() {
    return Tape;
  }

  public int getDiasAlugada() {
    return diasAlugada;
  }

  public boolean boolDiasAlugada(int dias){
    if (getDiasAlugada()>dias){
      return true;
    }
    return false;
  }
  //funcao q retorna true se a quantidade de dias alugadas for maior doq um inteiro arbitrario

  public boolean ehLancamento(){
    return Tape.ehLancamento();
  }

  public int getCodigoPreco(){
    return Tape.getCodigoDePreco();
  }

}

