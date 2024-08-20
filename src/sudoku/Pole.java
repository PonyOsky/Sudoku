package sudoku;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author dudak_ondrej
 */
public class Pole extends JButton implements MouseListener {

    /**
     * Třída Pole má vlastnosti: -int number, která v sobě ukrývá správnou
     * hodnotu pole -boolean show, který určije, jestli hodnota number bude z
     * počátku odkrytá nebo ne -implementovaná Hra
     */
    private int number;
    private boolean show;
    private int pocetChyb;

    /**
     *
     * @param n
     */
    public Pole(int n) {
        this.number = n;
        this.show = true;
        this.pocetChyb = 0;
        this.setFont(new Font("Arial", Font.PLAIN, 24));
        reWrite();
        this.addMouseListener(this);
    }

    /**
     * Booleanová metoda reWrite určuje, která bude z počátku vidět
     */
    private boolean reWrite() {
        if (number <= 9) {
            this.show = false;
        } else {
            change(number);
        }
        return true;
    }

    /**
     * Metoda change přepisuje hodnoty vynásobené 10 zpět na správné hodnoty, má
     * vstup number
     */
    private void change(int number) {
        if (number >= 10) {
            this.number = number / 10;
        }
    }

    /**
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return
     */
    public boolean isShow() {
        return show;
    }
    /**
     * @return
     */
    public int getPocetChyb() {
        return pocetChyb;
    }
    
    /**
     * @param pocetChyb
     */
    public void setPocetChyb(int pocetChyb) {
        this.pocetChyb = pocetChyb;
    }
    
    /**
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
        this.show = true;
        this.pocetChyb = 0;
        reWrite();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Metoda naslouchá tomu, co uživatel napíše, pokud je shodná s nabitou
     * hodnotou, vyhodnotí jako správnou odpověď a nastaví ji na viditelnou,
     * pokud není, vyvolá metodu priejChybu (viz Hra.java)
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int cislo;
        if (!show) {
            String odpoved = JOptionPane.showInputDialog(null, "Zadejte číslo 1-9", " ", JOptionPane.QUESTION_MESSAGE);
            try {
                cislo = Integer.parseInt(odpoved);
                if (number == cislo) {
                    this.show = true;
                    this.setText(cislo + "");
                } else {
                    this.pocetChyb++;
                    this.setText(" ");

                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Nezadal jste číslo 1 - 9", "Chyba", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}

/*
if(scanner.nextInt()==number){

}

metoda(){
if(show){
setText(number);
}
}
*/
