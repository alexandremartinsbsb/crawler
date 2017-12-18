package teatroapp;

public enum Fonte {

  CENACONTEMPORANEA("Cena Contemporanea"), DEBOA("De Boa.com");

  private String descricao;

  Fonte(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return this.descricao;
  }

}
