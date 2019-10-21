package com.cdkm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SuperMarket {

	private static List<Produit> creationProduitEnStock() {
		List<Produit> listProduits = new ArrayList<Produit>();
		listProduits.add(new Produit("Apple", 0.20, 4));
		listProduits.add(new Produit("Orange", 0.50, 3));
		listProduits.add(new Produit("Watermelon", 0.80, 5));
		
		return listProduits;
	}
	
	
	public static void main(String[] args) {

		// creation des produit avec les stocke 
		List<Produit> listProduits = creationProduitEnStock();
		System.out.println("Nombre de produit en stocks disponible "+listProduits.size());
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Veuillez choisir le produit A => Apple; O =>Orange; W =>Watermelon  ");
		String c = scan.nextLine();
		
		controleDeProduitChoisit(c);		
		
	}


	private static void controleDeProduitChoisit(String c) {
		if(!c.isEmpty()) {
			char valeur = c.toUpperCase().charAt(0);
			Scanner scan;
			int qte;
			
			switch (valeur) {
			
			case 'A':
				System.out.println("Saisir la quantite de apple que vous souhaitez");
				scan = new Scanner(System.in);
				qte = scan.nextInt();
				verifierQuantiteDansStockApple(qte);
				break;
			
			case 'O':
				System.out.println("Saisir la quantite d'orange que vous souhaitez");
				scan = new Scanner(System.in);
				qte = scan.nextInt();
				verifierQuantiteDansStockOrange(qte);
				break;
			
			case 'W':
				System.out.println("Saisir la quantite de watermelon que vous souhaitez");
				scan = new Scanner(System.in);
				qte = scan.nextInt();
				verifierQuantiteDansStockWatermelon(qte);
				break;
			default:
				System.out.println("Choix de produit erroné A => Apple; O =>Orange; W =>Watermelon  ");
			}
		}
			
		
	}


	private static void verifierQuantiteDansStockWatermelon(int qte) {
		// TODO Auto-generated method stub
		
	}


	private static void verifierQuantiteDansStockOrange(int qte) {
		// TODO Auto-generated method stub
		
		
	}


	private static void verifierQuantiteDansStockApple(int qte) {
		
		
	}


}
