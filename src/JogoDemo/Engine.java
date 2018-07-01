package JogoDemo;

import java.util.Scanner;

import ClassesBasicas.Mochila;
import ClassesBasicas.Sala;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Engine {
	private JanelaPrincipal janP;
	private Sala salaInicial;
	private Mochila mochila;
	private Sala salaCorrente;
	private boolean fim;

	public Engine(JanelaPrincipal jp) {
		janP = jp;
		criaLabirinto();
		mochila = new Mochila();
		salaInicial.entra(mochila);
		salaCorrente = salaInicial;
		fim = false;
	}

	private void criaLabirinto() {
		Sala hallEntrada = new HallEntrada();
		Sala salaCofre = new SalaCofre();
		Sala salaPedras = new SalaPedras();

		hallEntrada.getPortas().put(salaCofre.getNome(), salaCofre);

		salaCofre.getPortas().put(hallEntrada.getNome(), hallEntrada);
		salaCofre.getPortas().put(salaPedras.getNome(), salaPedras);

		salaPedras.getPortas().put(salaCofre.getNome(), salaCofre);
		salaInicial = hallEntrada;
	}

	public void joga(String acao) {
		if (fim) {
			fimDeJogo();
			return;
		}
		
		String[] tokens = acao.split(" ");
		switch (tokens[0]) {
		case "pega":
			if (salaCorrente.pega(tokens[1])) {
				janP.exibeTexto("Ok! " + tokens[1] + " na mochila!"+"\n");
			} else {
				janP.exibeTexto("Objeto " + tokens[1] + " não encontrado."+"\n");
			}
			break;
		case "inventario":
			janP.exibeTexto("Conteudo da mochila: " + mochila.inventario()+"\n");
			break;
		case "usa":
			try {
				if (salaCorrente.usa(tokens[1])) {
					janP.exibeTexto("Feito !!");
				} else {
					janP.exibeTexto("Não é possível usar " + tokens[1] + " nesta sala");
				}
			} catch (FimDeJogoException e) {
				fim = true;
				fimDeJogo();
			}
			janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
			janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
			break;
		case "sai":
			Sala novaSala = salaCorrente.sai(tokens[1]);
			if (novaSala == null) {
				janP.exibeTexto("Sala desconhecida ...\n");
			} else {
				novaSala.entra(mochila);
				salaCorrente = novaSala;
				janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
				janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
			}
			break;
		case "start":
			janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
			janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
			break;
		default:
			janP.exibeTexto("Comando desconhecido: " + tokens[0]+"\n");
			break;
		}
	}
	
	private void fimDeJogo() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Fim de jogo !!");
		alert.setHeaderText("Parabéns !!");
		alert.setContentText("Você conseguiu abrir o cofre !!\nFIM DE JOGO");
		alert.showAndWait();		
	}
}
