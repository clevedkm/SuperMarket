package com.cdkm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SuperMarket {
	
	static final DecimalFormat dec = new DecimalFormat("#0.00");
	
	public enum produitDispo{
		apple,
		orange,
		watermelon
	}
	
	
	static Map<String, Produit> mapProduit;

	public static Map<String, Produit> creationProduitEnStock() {
		mapProduit = new HashMap<String, Produit>();
		
		mapProduit.put(produitDispo.apple.name(), new Produit("Apple", 0.20, 4));
		mapProduit.put(produitDispo.orange.name(), new Produit("Orange", 0.50, 3));
		mapProduit.put(produitDispo.watermelon.name(), new Produit("Watermelon", 0.80, 5));
		
		return mapProduit;
	}
	

	/**
	 * controle de saisie pour le choix de de caracter qui correspond au produit
	 * @param c
	 */

	public static void controleDeProduitChoisit(String c) {
		if(!c.isEmpty() && c.length()==1) {
			char valeur = c.toUpperCase().charAt(0);
			switch (valeur) {
			
			case 'A':
				verifierQuantiteDansStockApple();
				break;
			
			case 'O':
				verifierQuantiteDansStockOrange();
				break;
			
			case 'W':
				verifierQuantiteDansStockWatermelon();
				break;
			default:
				System.out.println("Choix de produit erroné A => Apple; O =>Orange; W =>Watermelon  ");
			}
		}else {
			System.out.println("Choix de produit erroné A => Apple; O =>Orange; W =>Watermelon ");
		}	
	}


	public static void verifierQuantiteDansStockWatermelon() {
		
			Produit produit = mapProduit.get(produitDispo.watermelon.name());
			while(produit.getQuantite()> 0) {
				try {
				System.out.println("Saisir la quantite de watermelon que vous souhaitez");
				Scanner scan = new Scanner(System.in);
				int qte = scan.nextInt();
				
				if(qte >= 1 && qte <= produit.getQuantite()) {
					if(qte == 1) {
						produit.setQuantite(produit.getQuantite() - (qte));
						System.out.println("prix d'achat est : " + produit.getPrix()+"£");
					}
					if(qte >= 2) {	
						int nombre = qte / 2;
						produit.setQuantite(produit.getQuantite() - (qte +nombre));
						System.out.println("prix d'achat est : " + produit.getPrix()*qte+"£");
					}
					System.out.println("il reste en stock :" + produit.getQuantite());
				}else {
					System.out.println("La quantite doit être inferieur au stock restant : "+produit.getQuantite());
				}
			}catch(Exception e) {
				System.out.println("Merci de saisir un nombre ");
				}
			}	
	}


	public static void verifierQuantiteDansStockOrange() {
		Produit produit = mapProduit.get(produitDispo.orange.name());
		while(produit.getQuantite()> 0) {
			try {
			System.out.println("saisir la quantite souhaitée, quantite disponible en stock :"+produit.getQuantite());
			Scanner scan = new Scanner(System.in);
			int qte = scan.nextInt();
			if(qte >= 1 && qte <= produit.getQuantite()) {				
				produit.setQuantite(produit.getQuantite() - qte);
				double prixVente = (produit.getPrix()*qte); 
				System.out.println("prix d'achat est : " + prixVente+"£");
			}else {
				System.out.println("la valeur saisit est superieur au stock disponible de  : " +produit.getQuantite());
			}
		}catch(Exception e) {
			System.out.println("Merci de saisir un nombre ");
			}
		}
	}


	private static void verifierQuantiteDansStockApple() {
		
			Produit produit = mapProduit.get(produitDispo.apple.name());
				
				while(produit.getQuantite() > 0) {
					
					try {
						
					if(produit.getQuantite() ==1) {
						System.out.println("La promotion sur les apples est fini, quantite restante :"+produit.getQuantite());
						System.out.println("Saisir la quantite de apple que vous souhaitez, Nombre en stock :"+produit.getQuantite());
						Scanner scan = new Scanner(System.in);
						int qte = scan.nextInt();
						if(qte==1) {							
							double prixVente = produit.getQuantite()* (produit.getPrix()*0.5); 
							System.out.println("prix d'achat est : " + prixVente+"£");
							produit.setQuantite(produit.getQuantite() - qte);
							System.out.println("il reste en stock :" + produit.getQuantite());
						}else {
							System.out.println("la valeur saisit est different de  : " +produit.getQuantite());
						}
					}else {						
						System.out.println("Saisir la quantite de apple que vous souhaitez, Nombre en stock :"+produit.getQuantite());
						Scanner scan = new Scanner(System.in);
						int qte = scan.nextInt();
						
						if(qte > produit.getQuantite()/2) {
							System.out.println("La quantite saisi doit être inferieur ou égale à :" + produit.getQuantite()/2);
							scan = new Scanner(System.in);
							qte = scan.nextInt();
						}
						
						if((qte*2) <= produit.getQuantite()){
							produit.setQuantite(produit.getQuantite() - (qte*2));
							System.out.println("prix d'achat est : " + dec.format(qte * (produit.getPrix()))+"£");
							System.out.println("il reste en stock :" + produit.getQuantite());
						}else {
							System.out.println("Sur la quatite restante la promo n'est valable sur :" + ((qte*2) - produit.getQuantite()));
						}
					}
				}catch(Exception e) {
					System.out.println("Merci de saisir un nombre ");
				}
			}
	}


}
