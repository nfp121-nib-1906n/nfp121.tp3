package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
      if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
     if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
          throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
         if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
         return stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
     return this.taille() == this.capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
         Pile2 temp = new Pile2 (this.capacite());
        Object elStk = new Object();
        
        while (!estVide()){
            try {
                elStk = this.depiler();
                temp.empiler(elStk);
            } catch (PileVideException videExc){}
              catch (PilePleineException pleineExc){}
              
            s += (elStk == null)? "NULL":elStk;
            if (!estVide())
                s += ", ";
        }
        
        rendreElements(this, temp);
        return s + "]";
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

    
        if (secondPile.taille() == 0)
            return true;

        Pile2 premierTemp = new Pile2 (this.taille());
        Pile2 secondTemp = new Pile2 (secondPile.taille());
        boolean egales;
        
         while (!pile.estVide()) {
            try {
                egales = false;

            
                if (this.sommet() == null){ 
                    if (secondPile.sommet() == null)
                        egales = true;
                }
                else if (secondPile.sommet() == null){
                    if (this.sommet() == null)
                        egales = true;
                }
                else if (this.sommet().equals(secondPile.sommet()))
                    egales = true;

                if (egales) {
                    Object premierTempElement = this.depiler();
                    Object secondTempElement = secondPile.depiler();
                    premierTemp.empiler(premierTempElement);
                    secondTemp.empiler(secondTempElement);
                }
                else {
                  
                    rendreElements(this, premierTemp);
                    rendreElements(secondPile, secondTemp);
                    return egales;
                }

            } catch (PileVideException videExc){}
            catch (PilePleineException pleineExc){}
        }

      
        rendreElements(this, premierTemp);
        rendreElements(secondPile, secondTemp);
        return true;
    }
    
    public void rendreElements(PileI pileInit, PileI temp){
        while (!temp.estVide()){
            try {
                Object tempElement = temp.depiler();
                pileInit.empiler(tempElement);
            } catch (PileVideException videExc){}
            catch (PilePleineException pleineExc){}
        }
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

   
    public int taille() {
            return this.stk.size();
    }

 
    public int capacite() {
        return this.capacite;
    }

} // Pile2.java
