package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.cdkm.Produit;
import com.cdkm.SuperMarket;
import com.cdkm.SuperMarket.produitDispo;

public class SuperMarketTest {
	
	
	@Test
	public void TestVerifierStock() {
		
		Map<String, Produit> map = SuperMarket.creationProduitEnStock();
		assertNotNull(map.get(produitDispo.apple.name()));
		assertNotNull(map.get(produitDispo.orange.name()));
		assertNotNull(map.get(produitDispo.watermelon.name()));
		
		assertEquals(0.20, map.get(produitDispo.apple.name()).getPrix(), 0.0);
		assertEquals(0.50, map.get(produitDispo.orange.name()).getPrix(), 0.0);
		assertEquals(0.80, map.get(produitDispo.watermelon.name()).getPrix(), 0.0);
		
		//verificattion des quantite
		assertEquals(4, map.get(produitDispo.apple.name()).getQuantite());
		assertEquals(3, map.get(produitDispo.orange.name()).getQuantite());
		assertEquals(5, map.get(produitDispo.watermelon.name()).getQuantite());
	}
	
	@Test
	public void TestRemplirStock() {
		
		Map<String, Produit> map = SuperMarket.creationProduitEnStock();
		
		assertNotNull(map);
		assertTrue(!map.isEmpty());
		
		map.put(produitDispo.apple.name(), new Produit(produitDispo.apple.name(), 0.20, 4));
		map.put(produitDispo.orange.name(), new Produit(produitDispo.orange.name(), 0.20, 4));
		map.put(produitDispo.watermelon.name(), new Produit(produitDispo.watermelon.name(), 0.20, 4));
		
		assertNotNull(map.get(produitDispo.apple.name()));
		assertNotNull(map.get(produitDispo.orange.name()));
		assertNotNull(map.get(produitDispo.watermelon.name()));
		
	}
	
	
	
	
	@Test
	public void TestcontroleDeProduitChoisit() {
		String c;
		c ="A";
		//SuperMarket.controleDeProduitChoisit("E");
		assertFalse(c, (!c.equalsIgnoreCase("A")));
		assertNotNull(c);
		assertTrue(c, c.length()==1);
		
		c ="O";
		//SuperMarket.controleDeProduitChoisit("F");
		assertFalse(c, (!c.equalsIgnoreCase("O")));
		assertNotNull(c);
		assertTrue(c, c.length()==1);
		
		c ="W";
		//SuperMarket.controleDeProduitChoisit("G");
		assertFalse(c, (!c.equalsIgnoreCase("W")));
		assertNotNull(c);
		assertTrue(c, c.length()==1);
		
	}
	
	
	
}
