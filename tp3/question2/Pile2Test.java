
package question2;

/**
 * Classe-test Pile2Test.
 * 
 * @author Maria Bou Aoun
 * @version 2.0
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile3Test extends junit.framework.TestCase {
	  private PileI p1;
          private PileI p2;
	public Pile3Test() {
	}

	/**
	 * Met en place les engagements.
	 * 
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	protected void setUp() // throws java.lang.Exception
	{
        p1 = new question2.Pile3();
        p2 = new question2.Pile3();

	}

	/**
	 * Supprime les engagements
	 * 
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	protected void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}

	   public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }

    public void test_Pile_estPleine() throws Exception {
        PileI p = new question2.Pile3(2);
        p.empiler(48);
        assertEquals(1, p.taille());
        p.empiler(93);
        assertEquals(2, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_sommet() throws Exception {
        PileI p = new question2.Pile3(6);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(13));
        assertEquals(" sommet ?? ", new Integer(13), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(13), p.depiler());
        assertEquals(0, p.taille());
    }

  

    public void test_Pile_equals() throws Exception {

        p1.empiler(null);
        p1.empiler(81);
        p1.empiler(82);

        p2.empiler(null);
        p2.empiler(81);
        p2.empiler(82);

        assertTrue("Egalite de deux piles ? ", p1.equals(p2));
        assertTrue("Egalite de deux piles ? ", p2.equals(p1));
        assertTrue("Egalite de deux piles ? ", p1.equals(p1));

        p1.empiler(null);
        p2.empiler(null);
        assertTrue("Egalite de deux piles ? ", p1.equals(p2));

    }
    
    public void testingFour() throws Exception {
        

        p1.empiler(10);
        p1.empiler(13);
        p1.empiler(16);

        p2.empiler(10);
        p2.empiler(13);
        p2.empiler(16);

        assertEquals ("Hachages de p1 and p2 are Equals ?", true, 
            p1.hashC() == p2.hashC());
    }

}
