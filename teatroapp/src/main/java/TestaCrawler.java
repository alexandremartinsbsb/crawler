import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import teatroapp.Crawler;
import teatroapp.infra.Conexao;

public class TestaCrawler {

	public static void main(String[] args) {
		
		Conexao conexao = new Conexao();
		conexao.conectar();

		/*Document doc = null;
		Crawler crawler = new Crawler();

		try {
			doc = Jsoup.connect("http://www.cenacontemporanea.com.br/programacao-espetaculos-2017/").timeout(300000)
					.get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Element content = doc.select(".content-page").first();
		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
			String linkHref = link.attr("href");

			crawler.getInformacoesEvento(linkHref);

			System.out.println("////////////////////");
		}*/
	}

}
