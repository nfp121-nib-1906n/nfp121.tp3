package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author Maria Bou Aoun
 * @version 2.0
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
       this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
      if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
       if (estVide())
            throw new PileVideException();
        this.ptr--;
        return this.zone[ptr];
    }

    public Object sommet() throws PileVideException {
         if (estVide())
            throw new PileVideException();
        return this.zone[this.ptr - 1];
    }

    public int capacite() {
        return this.zone.length;
    }

    public int taille() {
           return this.ptr;
    }

    public boolean estVide() {
      return this.taille() == 0;
    }

    public boolean estPleine() {
      return ptr == zone.length;
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (!(o instanceof PileI))
            return false;
        PileI secondPile = (PileI)o;
        if (this == secondPile)
            return true;
        if (this.taille() != secondPile.taille())
            return false;
        if (this.capacite() != secondPile.capacite())
            return false;

     taille() == 0 car elles sont égales
     
        if (secondPile.taille() == 0)
            return true;

        Pile temp = new Pile (secondPile.taille()); 
        boolean egales;

        for (int i = this.taille() - 1; i >= 0; i -= 1){
            try {
                egales = false;
                if (zone[i] == null){ 
                    if (secondPile.sommet() == null)
                        egales = true;
                }
                else if (secondPile.sommet() == null){
                    if (zone[i] == null)
                        egales = true;
                }
                else if (zone[i].equals(secondPile.sommet()))
                    egales = true;

               
                if (egales) {
                    Object tempElement = secondPile.depiler();
                    temp.empiler(tempElement);
                }
                else {
                 
                    rendreElements(secondPile, temp);
                    return egales;
                }

            } catch (PileVideException videExc){}
            catch (PilePleineException pleineExc){}
        }
       rendreEl(secondPile, temp);
    }
    public void rendreEl(PileI pile, PileI temp){
 
        int tempT = temp.taille();
        for (int i = tempT; i > 0; i -=1){
            try {
                Object tempElement = temp.depiler();
                pile.empiler(tempElement);
            } catch (PileVideException videExc){}
            catch (PilePleineException pleineExc){}
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
         if (estVide())
            return "[]";
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append((zone[i] == null)? "NULL":zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
