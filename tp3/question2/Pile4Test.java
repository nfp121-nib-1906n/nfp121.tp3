package question2;

/**
 * Classe-test Pile4Test.
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
public class Pile4Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	/**
	 * Constructeur de la classe-test Pile4Test
	 */
	public Pile4Test() {
	}

	/**
	 * Met en place les engagements.
	 * 
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	protected void setUp() // throws java.lang.Exception
	{
		// Initialisez ici vos engagements

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
public void testingFour() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }



    public void test_Pile_equals() throws Exception {

        p1.empiler(50);
        p1.empiler(52);
        p1.empiler(54);

        p2.empiler(50);
        p2.empiler(52);
        p2.empiler(54);  
	    
        assertTrue("égalité de deux piles ? ", p1.equals(p2));
        assertTrue("égalité de deux piles ? ", p2.equals(p1));
        assertTrue("égalité de deux piles ? ", p1.equals(p1));

        p1.empiler(58);
        p2.empiler(58);
        assertTrue("égalité de deux piles ? ", p1.equals(p2));

        p1.empiler(null);
        p2.empiler(60);
        assertFalse("égalité de deux piles ? ", p1.equals(p2));
    }

    public void testingFour() throws Exception {


        p1.empiler(41);
        p1.empiler(42);
        p1.empiler(43);

        p2.empiler(41);
        p2.empiler(42);
        p2.empiler(43);

        assertEquals ("Hachages de p1 and p2 are equals ?", true, 
            p1.hashC() == p2.hashC());
    }

}
