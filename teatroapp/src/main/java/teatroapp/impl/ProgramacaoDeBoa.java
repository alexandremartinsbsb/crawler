package teatroapp.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import teatroapp.Programacao;
import teatroapp.modelo.deboa.EventoDeBoa;
import teatroapp.modelo.deboa.ServicoDeBoa;

public class ProgramacaoDeBoa implements Programacao {

	@Override
	public List<Object> buscar() {
		Document doc = null;
		List<Object> listaRetorno = new ArrayList<>();

		try {
			doc = Jsoup.connect("http://brasilia.deboa.com/assunto/teatro-brasilia").timeout(300000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements links = doc.select("div.descricao-post > h2 > a");
		for (Element link : links) {
			String linkHref = link.attr("href");

			EventoDeBoa eventoDeBoa = this.getInformacoesEvento(linkHref);

			listaRetorno.add(eventoDeBoa);
		}

		return listaRetorno;
	}

	private EventoDeBoa getInformacoesEvento(String link) {

		EventoDeBoa eventoDeBoa = new EventoDeBoa();
		Document doc = null;

		try {
			doc = Jsoup.connect(link).timeout(300000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element content = doc.select("div.dmbs-main").first();

		eventoDeBoa.setNome(content.select("h1.page-header").text());
		eventoDeBoa.setUrlImagem(content.getElementsByTag("img").first().attr("src"));

		String descricao = content.select("p").first().text();
		eventoDeBoa.setDescricao(descricao);

		String informacoes = doc.select("div.descricao-interno-post").first().html();

		List<ServicoDeBoa> listaServicos = new ArrayList<>();
		ServicoDeBoa servicoDeBoa = new ServicoDeBoa();

		int tamanhoLista = informacoes.split("<br>").length;

		for (int i = 1; i < tamanhoLista; i++) {
			String a = informacoes.split("<br>")[i].trim();

			if (servicoDeBoa.getData().isEmpty()) {
				servicoDeBoa.setData(a.substring(13));
			} else if (servicoDeBoa.getHora().isEmpty()) {
				servicoDeBoa.setHora(a.substring(13));
			} else if (servicoDeBoa.getLocal().isEmpty()) {
				servicoDeBoa.setLocal(a.substring(14));
			}
		}

		listaServicos.add(servicoDeBoa);
		eventoDeBoa.setListaServicos(listaServicos);

		Elements elementos = doc.select("ul > li");
		eventoDeBoa.setValorInteira(elementos.get(elementos.size() - 19).text().substring(0, 9).trim());
		eventoDeBoa.setValorMeia(elementos.get(elementos.size() - 18).text().substring(0, 9).trim());
		eventoDeBoa.setClassificacao(elementos.get(elementos.size() - 15).text().substring(15));

		return eventoDeBoa;
	}

}
