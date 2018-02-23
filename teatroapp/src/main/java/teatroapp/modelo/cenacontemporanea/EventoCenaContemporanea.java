package teatroapp.modelo.cenacontemporanea;

import java.util.ArrayList;
import java.util.List;

public class EventoCenaContemporanea {

  private String nome = new String();
  private String urlImagem = new String();
  private String descricao = new String();
  private List<ServicoCenaContemporanea> listaServicos = new ArrayList<>();
  private String duracao = new String();
  private String classificacao = new String();

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getUrlImagem() {
    return urlImagem;
  }

  public void setUrlImagem(String urlImagem) {
    this.urlImagem = urlImagem;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<ServicoCenaContemporanea> getListaServicos() {
    return listaServicos;
  }

  public void setListaServicos(List<ServicoCenaContemporanea> listaServicos) {
    this.listaServicos = listaServicos;
  }

  public String getDuracao() {
    return duracao;
  }

  public void setDuracao(String duracao) {
    this.duracao = duracao;
  }

  public String getClassificacao() {
    return classificacao;
  }

  public void setClassificacao(String classificacao) {
    this.classificacao = classificacao;
  }

  @Override
  public String toString() {
    return "ObjetoEvento [nome=" + nome + ", urlImagem=" + urlImagem + ", descricao=" + descricao
        + ", listaServicos=" + listaServicos + ", duracao=" + duracao + ", classificacao="
        + classificacao + "]";
  }

}
