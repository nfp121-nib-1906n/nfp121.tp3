package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author Maria Bou Aoun
 * @version 2.0
 */
public class Pile3 implements PileI {

	private Vector<Object> v;

	public Pile3() {
		this(0);
	}

	public Pile3(int taille) {
		  if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        
        this.v = new Vector<Object>(taille);
	}

	public void empiler(Object o) throws PilePleineException {
		  if (estPleine())
            throw new PilePleineException();
        this.v.addElement(o);
	}

	public Object depiler() throws PileVideException {
		 if (estVide())
            throw new PileVideException();
        return this.v.remove(this.taille() -1);
		
	}

	public Object sommet() throws PileVideException {
		if (estVide())
            throw new PileVideException();
        return this.v.lastElement();
	}

	public int taille() {
		   return this.v.size();
	}

	public int capacite() {
		   return this.v.capacity();
	}

	public boolean estVide() {
		 return this.v.isEmpty();
	}

	public boolean estPleine() {
		  return this.taille() == this.capacite();
	}

	public String toString() {
		        if (estVide())
            return "[]";
        StringBuffer sb = new StringBuffer("[");
        int vectorTaille = this.taille();
        for (int i = vectorTaille - 1; i >= 0; i--) {
            sb.append(this.v.get(i));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
	}

	public boolean equals(Object o) {
		// à compléter
		return false;
	}

	// fonction fournie
	public int hashCode() {
		return toString().hashCode();
	}

}
