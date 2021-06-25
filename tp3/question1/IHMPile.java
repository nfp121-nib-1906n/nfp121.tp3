package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private Pile p;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(6);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("empiler")){
         try {
                Object objEmp = donnee.getText();
                p.empiler(objEmp);
                contenu.setText(p.toString());
            } catch (PilePleineException pleineExc) {
                contenu.setText(p.toString() + " full ");
            }
        }else{
            try {
                Object objDep = p.depiler();
                sommet.setText(objDep.toString());
                contenu.setText(p.toString()); 
            } catch (PileVideException VideExc) {
                contenu.setText(p.toString() + " empty ");
            }
        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
