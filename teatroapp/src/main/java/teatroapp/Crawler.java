package teatroapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import teatroapp.cenacontemporanea.ObjetoEvento;
import teatroapp.cenacontemporanea.ObjetoServico;

public class Crawler {

	public void getInformacoesEvento(String link) {

		ObjetoEvento objetoEvento = new ObjetoEvento();
		Document doc = null;

		try {
			doc = Jsoup.connect(link).timeout(300000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Element content = doc.select(".content-page").first();

		objetoEvento.setNome(content.select("h1").text());
		objetoEvento.setUrlImagem(content.getElementsByTag("img").first().attr("src"));
		objetoEvento.setDescricao(content.select("p.font_8").text());

		String content2 = doc.select("aside.sidebar-programacao > div.box-servico > div.area-infos > div.servico")
				.first().html();

		List<ObjetoServico> listaObjetosServico = new ArrayList<>();
		ObjetoServico objetoServico = new ObjetoServico();

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
				objetoServico = new ObjetoServico();
			}
		}

		objetoEvento.setListaServicos(listaObjetosServico);
		objetoEvento.setDuracao(content2.split("<br>")[tamanhoLista - 2]);
		objetoEvento.setClassificacao(content2.split("<br>")[tamanhoLista - 1]);

		System.out.println(objetoEvento);
	}

}
