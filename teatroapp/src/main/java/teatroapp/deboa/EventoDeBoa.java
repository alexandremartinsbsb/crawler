package teatroapp.deboa;

import java.util.ArrayList;
import java.util.List;

public class EventoDeBoa {

  private String nome = new String();
  private String urlImagem = new String();
  private String descricao = new String();
  private List<ServicoDeBoa> listaServicos = new ArrayList<>();
  private String valorInteira = new String();
  private String valorMeia = new String();
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

  public List<ServicoDeBoa> getListaServicos() {
    return listaServicos;
  }

  public void setListaServicos(List<ServicoDeBoa> listaServicos) {
    this.listaServicos = listaServicos;
  }

  public String getValorInteira() {
    return valorInteira;
  }

  public void setValorInteira(String valorInteira) {
    this.valorInteira = valorInteira;
  }

  public String getValorMeia() {
    return valorMeia;
  }

  public void setValorMeia(String valorMeia) {
    this.valorMeia = valorMeia;
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
        + ", listaServicos=" + listaServicos + ", valorInteira=" + valorInteira + ", valorMeia="
        + valorMeia + ", classificacao=" + classificacao + "]";
  }

}
