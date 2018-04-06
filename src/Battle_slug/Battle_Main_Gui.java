package Battle_slug;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *date:2016/01/02
 * @author dhanraj giri
 */
public class Battle_Main_Gui extends JFrame implements ActionListener {
     
    public static String name[]= new String[2];
    private JPanel jp;
    private JLabel jl,slug;
    private JButton start;
    public Battle_Main_Gui()
    {
          jp=new JPanel(null);
          jl=new JLabel("Click start to Play");
          slug=new JLabel("Battle slug");
          Font q=new Font ("Arial",1,90);
          jl.setBounds(150, -50, 1000, 400);
          jl.setFont(q);
          slug.setBounds(280,30,1150,500);
          slug.setFont(q);
          start=new JButton("start");
          start.setBounds(450, 370, 250, 80);
          start.setBackground(Color.green);
          start.addActionListener(this);
          jp.setBackground(Color.yellow);
          jp.setVisible(true);
          jp.add(jl);
          jp.add(slug);
          jp.add(start);
          Container cont=getContentPane();
          jp.setBounds(80,80,1150,500);
          cont.setLayout(null);
          cont.setSize(1366,768);
          cont.add(jp);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          this.setSize(1366,768);
	  this.setVisible(true);
    }
      public void actionPerformed(ActionEvent action) {
      name[0]=JOptionPane.showInputDialog(null,"Enter First Player name.","",3);  
      while (((name[0]==null)||(name[0].equals(""))))
      {    
        name[0]=JOptionPane.showInputDialog(null,"Player Name must be enter before starting game.","",0);
      }
      name[1]=JOptionPane.showInputDialog(null,"Enter Second Player name.","",3);  
      while ((( name[1]==null)||( name[1].equals(""))))
      {    
        name[1]=JOptionPane.showInputDialog(null,"Player Name must be enter before starting game.","",0);
        
      }
      
        int option = JOptionPane.showConfirmDialog(null,"Do you want to the Start Game","BattleSlug",JOptionPane.YES_NO_OPTION,2);
        if (option==1)
        {
          System.exit(1);
        } else{
          this.dispose();
          new Battle_Game();    
      }
    }
       public static void main(String []args)
  {
    new Battle_Main_Gui();
  }
}
