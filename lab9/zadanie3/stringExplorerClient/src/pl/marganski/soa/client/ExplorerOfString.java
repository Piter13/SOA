package pl.marganski.soa.client;

import pl.marganski.soa.StringExplorer;
import pl.marganski.soa.StringExplorerService;

public class ExplorerOfString {

	public static void main(String[] args) {
		StringExplorerService stringExplorerService = new StringExplorerService();
		StringExplorer stringExplorer = stringExplorerService.getStringExplorerPort();
		System.out.println(stringExplorer.exlopre("100 tousends of people at UEFA Champions League 2018 final"));
	}

}
