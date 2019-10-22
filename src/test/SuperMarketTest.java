package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cdkm.Produit;
import com.cdkm.SuperMarket;
import com.cdkm.SuperMarket.produitDispo;

public class SuperMarketTest {
	
	
	@Before
	public void setUp() {
		System.out.println("@Before - setUp");
	}
	
	
	@Test
	public void TestVerifierStock() {
		
		Map<String, Produit> map = SuperMarket.creationProduitEnStock();
		assertNotNull(map.get(produitDispo.apple.name()));
		assertNotNull(map.get(produitDispo.orange.name()));
		assertNotNull(map.get(produitDispo.watermelon.name()));
		
		assertEquals(0.20, map.get(produitDispo.apple.name()).getPrix(), 0.0);
		assertEquals(0.50, map.get(produitDispo.orange.name()).getPrix(), 0.0);
		assertEquals(0.80, map.get(produitDispo.watermelon.name()).getPrix(), 0.0);
	}
	
	@Test
	public void TestRemplirStock() {
		
		Map<String, Produit> map = SuperMarket.creationProduitEnStock();
		map.put(produitDispo.apple.name(), new Produit(produitDispo.apple.name(), 0.20, 4));
		map.put(produitDispo.apple.name(), new Produit(produitDispo.apple.name(), 0.20, 4));
		map.put(produitDispo.apple.name(), new Produit(produitDispo.apple.name(), 0.20, 4));
		
		assertNotNull(map.get(produitDispo.apple.name()));
		assertNotNull(map.get(produitDispo.orange.name()));
		assertNotNull(map.get(produitDispo.watermelon.name()));
		
	}
	
	
	@Test
	public void TestcontroleDeProduitChoisit() {
		String c;
		c ="A";
		SuperMarket.controleDeProduitChoisit("E");
		assertFalse(c, (c.equalsIgnoreCase("E")));
		assertNotNull(c);
		assertTrue(c, c.length()==1);
		
		c ="O";
		SuperMarket.controleDeProduitChoisit("F");
		assertFalse(c, (c.equalsIgnoreCase("F")));
		assertNotNull(c);
		assertTrue(c, c.length()==1);
		
		c ="W";
		SuperMarket.controleDeProduitChoisit("G");
		assertFalse(c, (c.equalsIgnoreCase("G")));
		assertNotNull(c);
		assertTrue(c, c.length()==1);
		
	}
	
}
