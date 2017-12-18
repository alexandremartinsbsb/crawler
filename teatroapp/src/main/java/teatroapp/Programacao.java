package teatroapp;

import java.util.List;

import teatroapp.cenacontemporanea.CrawlerCenaContemporanea;
import teatroapp.deboa.CrawlerDeBoa;

public class Programacao {

  public List<Object> buscar(Fonte fonte) {

    if (fonte.equals(Fonte.CENACONTEMPORANEA)) {
      return this.buscaCenaContemporanea();
    } else if (fonte.equals(Fonte.DEBOA)) {
      return this.buscaDeBoa();
    } else {
      return null;
    }
  }

  private List<Object> buscaCenaContemporanea() {
    CrawlerCenaContemporanea crawler = new CrawlerCenaContemporanea();
    return crawler.buscar();
  }

  private List<Object> buscaDeBoa() {
    CrawlerDeBoa crawlerDeBoa = new CrawlerDeBoa();
    return crawlerDeBoa.buscar();
  }

}
