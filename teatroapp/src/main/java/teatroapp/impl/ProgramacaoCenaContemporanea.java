package teatroapp.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import teatroapp.Programacao;
import teatroapp.modelo.cenacontemporanea.EventoCenaContemporanea;
import teatroapp.modelo.cenacontemporanea.ServicoCenaContemporanea;

public class ProgramacaoCenaContemporanea implements Programacao {

	@Override
	public List<Object> buscar() {
		Document doc = null;
		List<Object> listaRetorno = new ArrayList<>();

		try {
			doc = Jsoup.connect("http://www.cenacontemporanea.com.br/programacao-espetaculos-2017/").timeout(300000)
					.get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element content = doc.select(".content-page").first();
		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
			String linkHref = link.attr("href");

			EventoCenaContemporanea objetoEvento = this.getInformacoesEvento(linkHref);

			listaRetorno.add(objetoEvento);
		}

		return listaRetorno;
	}

	private EventoCenaContemporanea getInformacoesEvento(String link) {

		EventoCenaContemporanea objetoEvento = new EventoCenaContemporanea();
		Document doc = null;

		try {
			doc = Jsoup.connect(link).timeout(300000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element content = doc.select(".content-page").first();

		objetoEvento.setNome(content.select("h1").text());
		objetoEvento.setUrlImagem(content.getElementsByTag("img").first().attr("src"));

		String descricao = content.select("p.font_8").text();

		if (descricao.isEmpty()) {
			descricao = content.select("p > em").text();
		}

		if (descricao.isEmpty()) {
			descricao = content.select("p").text();
		}

		objetoEvento.setDescricao(descricao);

		String content2 = doc.select("aside.sidebar-programacao > div.box-servico > div.area-infos > div.servico")
				.first().html();

		List<ServicoCenaContemporanea> listaObjetosServico = new ArrayList<>();
		ServicoCenaContemporanea objetoServico = new ServicoCenaContemporanea();

		int tamanhoLista = content2.split("<br>").length;

		for (int i = 0; i < tamanhoLista - 2; i++) {
			if (objetoServico.getDataHora().isEmpty()) {
				objetoServico.setDataHora(content2.split("<br>")[i].trim());
			} else if (objetoServico.getLocal().isEmpty()) {
				objetoServico.setLocal(content2.split("<br>")[i].trim());
			} else if (objetoServico.getValor().isEmpty()) {
				objetoServico.setValor((content2.split("<br>")[i].trim()));
			} else {
				listaObjetosServico.add(objetoServico);
				objetoServico = new ServicoCenaContemporanea();
			}
		}

		objetoEvento.setListaServicos(listaObjetosServico);
		objetoEvento.setDuracao(content2.split("<br>")[tamanhoLista - 2]);
		objetoEvento.setClassificacao(content2.split("<br>")[tamanhoLista - 1]);

		return objetoEvento;
	}

}
