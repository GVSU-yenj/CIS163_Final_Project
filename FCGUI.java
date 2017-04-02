package FoodCourt;

public class FCGUI {

 public FCGUI(){
private JPanel deezButtons = new JPanel;
deezButtons.setLayout(new GridLayout(0,2));

  //Jmoney: might have to add actionListeners for my buttons.
private JButton starter = new JButton("Start da Sim!");
private JButton quitter = new JButton("Quit da Sim!");
 
 deezButtons.add(starter);
 deezButtons.add(quitter);
 }
}
