package sudoku;

import javax.swing.JOptionPane;

/**
 *
 * @author dudak_ondrej
 */
public class Hra {
    /** Třída Hra má vlastnost policka, která vytváří hrací pole z Pole.java.
     * Vlastnost mistakes určuje počet chyb, ze začátku jsou chyby nastavené na intové hodnotě 0.
     * Vlastnost answers je intové pole, které obsahuje správnou odopvěď. Pokud je číslo vynásobené desítkou např. 10, 50 apod, znamená to, že toto číslo bude zobrazené na začátku viz Pole.java.
     */
    private Pole[][] policka;
    int[] answers = {4,9,1,7,3,60,2,80,50,
                     30,60,5,2,8,40,1,9,70,
                     8,7,20,5,1,9,4,60,3,
                     50,8,40,9,70,30,6,1,2,
                     7,1,30,6,2,8,90,5,4,
                     9,2,6,10,40,5,30,7,80,
                     6,30,8,4,5,1,70,2,9,
                     10,4,7,80,9,2,5,30,60,
                     20,50,9,30,6,7,8,4,1};
    private boolean konec;
    private HraciPole hraciPole;
    
    /**
     * V konstruktoru Hry jsou dva parametry:
     * -první vytváčí herní pole s názvem policka, vytvořené z Pole.java
     * -druhý je metoda init
     * @param hraciPole
     */
    public Hra(HraciPole hraciPole){
        this.hraciPole = hraciPole;
        this.policka = new Pole[9][9];
        init();
    }
    /**
     * Voidová metoda init si vytvoří index, který je nastaven na nulu.
     * Poté pomocí dvou for cyklů vyplní pole policka hodnotami z answers, aby mohlo sudoku dále pracovat.
     */
    public void init() {
        int index = 0;
        for(int r = 0; r < 9; r++){
            for(int s = 0; s < 9; s++){
                policka[r][s]= new Pole(answers[index]);
                index++;
            }
        }
    }
    
    public void init2() {
        int index = 0;
        for(int r = 0; r < 9; r++){
            for(int s = 0; s < 9; s++){
                policka[r][s].setNumber(answers[index]);
                policka[r][s].setPocetChyb(0);
                if(!policka[r][s].isShow()){
                    policka[r][s].setText("");
                }
                index++;
            }
        }
        
        hraciPole.getChyby().setText("Chyby 0 / 3");
        konec = false;
    }
    /**
     * @return 
     */
    public int vyhra(){
        int pV=0;
        for(int r = 0; r < 9; r++){
            for(int s = 0; s < 9; s++){
                if(policka[r][s].isShow()){
                    pV++;
                }
            }
        }
        return pV;
    }
    
    public void vyhralJsem(){
        if(vyhra() == 81){
            konec = true;
            JOptionPane.showMessageDialog(null, "Vyhrál jsi!");
            init2();
        }
    }
    
    public void prohra(){
        if (vratPocetChyb() == 3) {
            konec = true;
            JOptionPane.showMessageDialog(null, "Prohrál jsi!");
            init2();
        }
    }
    /**
     * 
     * @return 
     */
    public int vratPocetChyb()
    {
        int pCh = 0;
 
           for(int r = 0; r < 9; r++){
            for(int s = 0; s < 9; s++){
               pCh += policka[r][s].getPocetChyb();
            }
       
    }  
          return pCh;      
    }     
    
    /**
     * 
     * @param radky
     * @param sloupce
     * @return 
     */
    public Pole getPolicko(int radky, int sloupce){
        return this.policka[radky][sloupce];
    }
    /**
     * @return 
     */
    public boolean getKonec() {
        return this.konec;
    }
}