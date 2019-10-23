package test;

import java.util.Map;
import java.util.Scanner;

import com.cdkm.Produit;
import com.cdkm.SuperMarket;

class TesterSuperMarket {

	public static void main(String[] args) {

		// creation des produit avec les stocke 
		Map<String, Produit> mapProduits = SuperMarket.creationProduitEnStock();
		System.out.println("Nombre de produit en stocks disponible "+mapProduits.size());
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez choisir le produit A => Apple; O =>Orange; W =>Watermelon  ");
		String c = scan.nextLine();
		
		SuperMarket.controleDeProduitChoisit(c);
		
	}
	
}
