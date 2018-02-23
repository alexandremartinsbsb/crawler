package teatroapp.modelo.cenacontemporanea;

public class ServicoCenaContemporanea {

  private String dataHora = new String();
  private String local = new String();
  private String valor = new String();

  public String getDataHora() {
    return dataHora;
  }

  public void setDataHora(String dataHora) {
    this.dataHora = dataHora;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "ObjetoServico [dataHora=" + dataHora + ", local=" + local + ", valor=" + valor + "]";
  }

}
