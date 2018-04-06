package Battle_slug;

/**
 *date:2016/01/02
 * @author dhanraj
 */
import static Battle_slug.Battle_Main_Gui.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Battle_Game extends JFrame implements ActionListener{

	protected static JPanel jPlayer_One,jPlayer_Two,jp3,jp4,jp5,jp6;
	protected static JButton Player_Onerandom,Player_Onehorizontal,Player_Onevertical,Player_Oneview,Player_Oneplay;
	protected static JButton Player_Tworandom,Player_Twohorizontal,Player_Twovertical,Player_Twoview,Player_Twoplay;
	private JLabel namePlayer_One, attackPlayer_One, hitPlayer_One, missPlayer_One, lastPlayer_One, namePlayer_Two, attackPlayer_Two, hitPlayer_Two, missPlayer_Two, lastPlayer_Two;
        private Player_One_Button Player_OneAction;
        Battle_Logic f;
        private Player_Two_Button Player_TwoAction;
	static JButton Player_One[][], Player_Two[][], p5[][], p6[][];
	static int xcor,ycor,player,gameplayer;
	static int randomPlayer_One=0,counter=0, Player_Oneattack=0, Player_Onehit=0, Player_Onemiss=0;
        static int randomPlayer_Two=0,Player_Twoattack=0, Player_Twohit=0, Player_Twomiss=0;
        static int Player_Oneclick=0, Player_Twoclick=0;
    
	public Battle_Game()
	{
                f=new Battle_Logic();
		jPlayer_One=new JPanel(new GridLayout(12,12));
		jPlayer_One.setBackground(Color.black);
		jPlayer_Two=new JPanel(new GridLayout(12,12));
		jPlayer_Two.setBackground(Color.black);
		jp3=new JPanel(null);
		jp3.setBackground(Color.green);
		jp4=new JPanel(null);
		jp4.setBackground(Color.green);
		jp5=new JPanel(new GridLayout(12,12));
		jp5.setBackground(Color.black);
		jp6=new JPanel(new GridLayout(12,12));
		jp6.setBackground(Color.black);
		Player_OneAction= new Player_One_Button();
		Player_TwoAction=new Player_Two_Button();
		Player_One=new JButton[12][12];
		Player_Two=new JButton[12][12];
		p5=new JButton[12][12];
		p6=new JButton[12][12];
	
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<12;j++)
			{
				p5[i][j]=new JButton();
				p5[i][j].setActionCommand(i+","+j);
				p5[i][j].setBackground(Color.gray);
                                p5[i][j].setForeground(Color.white);
				jp5.add(p5[i][j]);
				p5[i][j].addActionListener(this);
				Font a=new Font ("Arial",1,10);
				p5[i][j].setFont(a);
			}
		}

		for(int i=0;i<12;i++)
		{
			for(int j=0;j<12;j++)
			{
				Player_One[i][j]=new JButton();
				Player_One[i][j].setActionCommand(i+","+j);
				Player_One[i][j].setBackground(Color.gray);
                                Player_One[i][j].setForeground(Color.white);
				jPlayer_One.add(Player_One[i][j]);
				Player_One[i][j].addActionListener(this);
				Font a=new Font ("Arial",1,10);
				Player_One[i][j].setFont(a);
			}
		}
		
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<12;j++)
			{
				p6[i][j]=new JButton();
				p6[i][j].setActionCommand(i+","+j);
                                p6[i][j].setBackground(Color.gray);
				p6[i][j].setForeground(Color.white);
				jp6.add(p6[i][j]);
				p6[i][j].addActionListener(this);
				Font a=new Font ("Arial",1,10);
				p6[i][j].setFont(a);
				p6[i][j].setEnabled(false);
			}
		}
	
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<12;j++)
			{
				Player_Two[i][j]=new JButton();
				Player_Two[i][j].setActionCommand(i+","+j);
                                Player_Two[i][j].setBackground(Color.gray);
				Player_Two[i][j].setForeground(Color.white);
				jPlayer_Two.add(Player_Two[i][j]);
				Player_Two[i][j].addActionListener(this);
				Font a=new Font ("Arial",1,10);
				Player_Two[i][j].setFont(a);
				Player_Two[i][j].setEnabled(false);
			}
		}

	Player_Onehorizontal=new JButton("Horizontal");
	Player_Onehorizontal.setBackground(Color.black);
	Player_Onehorizontal.setForeground(Color.white);
	Player_Onehorizontal.setBounds(20,20,130,30);
	Player_Onehorizontal.addActionListener(Player_OneAction);
	
        Player_Oneview=new JButton("View My Slug");
        Player_Oneview.setBackground(Color.black);
	Player_Oneview.setForeground(Color.white);
        Player_Oneview.setBounds(250,40,130,30);
        Player_Oneview.setEnabled(false);
	Player_Oneview.addActionListener(Player_OneAction);
        
        Player_Oneplay=new JButton("Play");
        Player_Oneplay.setBackground(Color.black);
	Player_Oneplay.setForeground(Color.white);
        Player_Oneplay.setBounds(250,80,130,30);
        Player_Oneplay.setEnabled(false);
	Player_Oneplay.addActionListener(Player_OneAction);
        
	Player_Onevertical=new JButton("Vertical");
	Player_Onevertical.setBackground(Color.black);
	Player_Onevertical.setForeground(Color.white);
	Player_Onevertical.setBounds(20,60,130,30);
	Player_Onevertical.addActionListener(Player_OneAction);
	
        Player_Onerandom=new JButton("Random");
	Player_Onerandom.setBackground(Color.black);
	Player_Onerandom.setForeground(Color.white);
	Player_Onerandom.setBounds(20,100,130,30);
	Player_Onerandom.addActionListener(Player_OneAction);
        
	Font q=new Font ("Arial",1,20);
	
        namePlayer_One=new JLabel("Player 1: - "+name[0]);
        namePlayer_One.setBounds(50, 0,800,30);
        namePlayer_One.setFont(q);
                
	attackPlayer_One=new JLabel("Total Attacks "+Player_Oneattack);
        attackPlayer_One.setBounds(20,150,550,30);
	attackPlayer_One.setBackground(Color.blue);
        attackPlayer_One.setFont(q);
    
	hitPlayer_One=new JLabel("Total Hits "+Player_Onehit);
	hitPlayer_One.setBounds(20, 190, 200, 30);
	hitPlayer_One.setBackground(Color.blue);
        hitPlayer_One.setFont(q);
    
	missPlayer_One=new JLabel("Total Miss "+Player_Onemiss);
	missPlayer_One.setBounds(20, 230, 200, 30);

        missPlayer_One.setBackground(Color.blue);
        missPlayer_One.setFont(q);
        
        lastPlayer_One=new JLabel("Your Last Attack ");
	lastPlayer_One.setBounds(20, 270, 250, 30);
	lastPlayer_One.setBackground(Color.blue);
        lastPlayer_One.setFont(q);

	jp3.add(Player_Onevertical);
        jp3.add(Player_Oneview);
        jp3.add(Player_Oneplay);
	jp3.add(Player_Onehorizontal);
	jp3.add(Player_Onerandom);	
	jp3.add(attackPlayer_One);
	jp3.add(hitPlayer_One);
	jp3.add(missPlayer_One);
        jp3.add(lastPlayer_One);
		
	Player_Twohorizontal=new JButton("Horizontal");
	Player_Twohorizontal.setBackground(Color.black);
	Player_Twohorizontal.setForeground(Color.white);
	Player_Twohorizontal.addActionListener(Player_TwoAction);
        Player_Twohorizontal.setBounds(20,20,130,30);
	Player_Twohorizontal.setEnabled(false);
        
        Player_Twoview=new JButton("View My Slug");
        Player_Twoview.setBackground(Color.black);
	Player_Twoview.setForeground(Color.white);
        Player_Twoview.setBounds(250,20,130,30);
        Player_Twoview.setEnabled(false);
	Player_Twoview.addActionListener(Player_TwoAction);
        
        Player_Twoplay=new JButton("Play");
        Player_Twoplay.setBackground(Color.black);
	Player_Twoplay.setForeground(Color.white);
        Player_Twoplay.setBounds(250,80,130,30);
        Player_Twoplay.setEnabled(false);
	Player_Twoplay.addActionListener(Player_TwoAction);
	
	Player_Twovertical=new JButton("Vertical");
	Player_Twovertical.setBackground(Color.black);
	Player_Twovertical.setForeground(Color.white);
	Player_Twovertical.addActionListener(Player_TwoAction);
        Player_Twovertical.setBounds(20,60,130,30);
	Player_Twovertical.setEnabled(false);

	Player_Tworandom=new JButton("Random");
	Player_Tworandom.setBackground(Color.black);
	Player_Tworandom.setForeground(Color.white);
	Player_Tworandom.addActionListener(Player_TwoAction);
        Player_Tworandom.setBounds(20,100,130,30);
	Player_Tworandom.setEnabled(false);
        
        attackPlayer_Two=new JLabel("Total Attacks "+Player_Twoattack);
        attackPlayer_Two.setBounds(20,150,550,30);
	attackPlayer_Two.setBackground(Color.blue);
        attackPlayer_Two.setFont(q);
    
	hitPlayer_Two=new JLabel("Total Hits "+Player_Twohit);
	hitPlayer_Two.setBounds(20, 190, 200, 30);
	hitPlayer_Two.setBackground(Color.blue);
        hitPlayer_Two.setFont(q);
        
        missPlayer_Two=new JLabel("Total Miss "+Player_Twomiss);
	missPlayer_Two.setBounds(20, 230, 200, 30);
	missPlayer_Two.setBackground(Color.blue);
        missPlayer_Two.setFont(q);
        
        lastPlayer_Two=new JLabel("Your Last Attack ");
	lastPlayer_Two.setBounds(20, 270, 250, 30);
	lastPlayer_Two.setBackground(Color.blue);
        lastPlayer_Two.setFont(q);
	
        namePlayer_Two=new JLabel("Player 2: - "+name[1]);
        namePlayer_Two.setBounds(50, 350,800,30);
        namePlayer_Two.setFont(q);
        
	setVisible(true);

	jp4.add(Player_Twovertical);
	jp4.add(Player_Twohorizontal);
        jp4.add(Player_Twoview);
        jp4.add(Player_Twoplay);
	jp4.add(Player_Tworandom);	
        jp4.add(attackPlayer_Two);
        jp4.add(hitPlayer_Two);
        jp4.add(missPlayer_Two);      
        jp4.add(lastPlayer_Two);
	
    Container cont=getContentPane();
    cont.setLayout(null);
    cont.setSize(1000,710);
    
    jPlayer_One.setBounds(0, 30, 495, 320);
    jPlayer_Two.setBounds(0, 385, 495, 320);
    jp3.setBounds(490, 30, 495, 320);
    jp4.setBounds(490, 385, 495, 320);
    jp5.setVisible(false);
    jp5.setBounds(0, 30, 495, 320);
    jp6.setVisible(false);
    jp6.setBounds(0, 385, 495, 320);
    
	cont.add(jPlayer_One);
	cont.add(jPlayer_Two);
	cont.add(jp3);
	cont.add(jp4);
	cont.add(jp5);
	cont.add(jp6);
        cont.add(namePlayer_One);
        cont.add(namePlayer_Two);
	this.setSize(1000, 750);
        this.setTitle("BattleSlug");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
}

    
    private class Player_One_Button implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      JButton Player_Onepressed = (JButton) e.getSource();
      
      if(Player_Onepressed==Player_Onehorizontal){
          Player_Oneclick=1;
      }
      if(Player_Onepressed==Player_Onevertical){
          Player_Oneclick=2;
      }
      if(Player_Onepressed==Player_Onerandom){
          Player_Oneclick=3;
      }
      if(Player_Onepressed==Player_Oneview)
      {
          Player_Oneplay.setEnabled(true);
          Player_Oneview.setEnabled(false);
          jPlayer_One.setVisible(true);
      }
      if(Player_Onepressed==Player_Oneplay)
      {
          Player_Oneview.setEnabled(true);
          Player_Oneplay.setEnabled(false);
          jPlayer_One.setVisible(false);
          jp5.setVisible(true);
      }
    }        
}
    
    private class Player_Two_Button implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          JButton Player_Twopressed = (JButton) e.getSource();
          Player_Oneclick=8;
          if(Player_Twopressed==Player_Twohorizontal){
              Player_Twoclick=1;
          }
          if(Player_Twopressed==Player_Twovertical){
              Player_Twoclick=2;
          }
          if(Player_Twopressed==Player_Tworandom){
              Player_Twoclick=3;
          }     
      if(Player_Twopressed==Player_Twoview)
      {
          Player_Twoplay.setEnabled(true);
          Player_Twoview.setEnabled(false);
          jPlayer_Two.setVisible(true);
      }
        if(Player_Twopressed==Player_Twoplay)
      {
          Player_Twoview.setEnabled(true);
          Player_Twoplay.setEnabled(false);
          jPlayer_Two.setVisible(false);
          jp6.setVisible(true);
          Player_Oneclick=10;
      }
        }        
    }
    
	public void actionPerformed(ActionEvent evt)
	{ 
        String tmp = evt.getActionCommand();
        String coordinates[] = tmp.split(",");
        xcor= Integer.parseInt(coordinates[0]);
        ycor= Integer.parseInt(coordinates[1]);
   if(Player_Oneclick==0){
	   JOptionPane.showMessageDialog(rootPane, "Please select at least one slug");
       return;
   }
   
   if(Player_Oneclick==1)
   {   
	  boolean c=f.getPlayer_OneHorizontalData();
	  if(c==true)
	  {
	     for(int z=1;z<6;z++)
	     {
	    	 String value;
			 value=Integer.toString(z);
			 Player_One[xcor][(ycor++)].setText(value);
				
		  }
	      counter++;
	      f.checkPoint(1);
	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null, "Please select another area");
	  }
       Player_Oneclick=0;
   }
   
   if(Player_Oneclick==2)
   {   
	  boolean c=f.getPlayer_OneVerticalData();
 	  if(c==true)
 	  {
 		  for(int z=1;z<6;z++)
 		  {
 			  String value;
 			  value=Integer.toString(z);
 			  Player_One[(xcor++)][ycor].setText(value);
 			  
 		  }
 		 counter++;
 		f.checkPoint(1);
 	  }
	  else
	  {
		  JOptionPane.showMessageDialog(null, "Please select another area");
	  }
       Player_Oneclick=0;
   }
   
   if(Player_Oneclick==3)
   {   
	  f.getPlayer_OneRandomData();
          Player_Oneclick=0;
   }  
   if(Player_Oneclick==10)
   {
    if(gameplayer==1)
	   {
		   String value=Player_Two[xcor][ycor].getText();
		   if(!value.equals(""))
		   {
                           p5[xcor][ycor].setEnabled(false);
			   p5[xcor][ycor].setBackground(Color.green);
                           Player_Onehit++;
                           hitPlayer_One.setText("Total Hit "+Player_Onehit);
                           lastPlayer_One.setText("Last Attack -- Hit");
		   }
		   else
		   {
                       p5[xcor][ycor].setEnabled(false);    
                       p5[xcor][ycor].setBackground(Color.red);
                            Player_Onemiss++;
                           missPlayer_One.setText("Total Miss "+Player_Onemiss);
                           lastPlayer_One.setText("Last Attack -- Miss");
			   gameplayer=2;
			   f.disable(p5,1);
			   f.enable(p6,2);
		   }
		   Player_Oneattack++;
                   attackPlayer_One.setText("Total Attacks "+Player_Oneattack);
		  
	   }
	   if(gameplayer==2)
	   {
		  if(xcor>=0&&ycor>=0)
		  {
		   String value=Player_One[xcor][ycor].getText();
		   if(!value.equals(""))
		   {
			 p6[xcor][ycor].setEnabled(false);
                       p6[xcor][ycor].setBackground(Color.green);
                         Player_Twohit++;
                           hitPlayer_Two.setText("Total Hits " +Player_Twohit);
                           lastPlayer_Two.setText("Last Attack -- Hit");
                           
		   }
		   else
		   {
                           p6[xcor][ycor].setEnabled(false);
			   p6[xcor][ycor].setBackground(Color.red);
			   Player_Twomiss++;
                           missPlayer_Two.setText("Total Miss "+Player_Twomiss);
                           lastPlayer_Two.setText("Last Attack -- Miss");
			   gameplayer=1;
			   f.disable(p6,2);
			   f.enable(p5,1);
		   }
                   Player_Twoattack++;
		   attackPlayer_Two.setText("Total Attacks "+Player_Twoattack);
		  }
	   }
           if(Player_Onehit==25)
           {
               JOptionPane.showMessageDialog(null, "Congratulation : "+name[0]+" You have won the game");
               this.dispose();
           }
           if(Player_Twohit==25)
           {
               JOptionPane.showMessageDialog(null, "Congratulation : "+name[1]+" You have won the game");
               this.dispose();
           }
   }

   if(Player_Oneclick==8)
   {
	   if(Player_Twoclick==0){
	       JOptionPane.showMessageDialog(rootPane, "Please select at least one slug");
	       return;
	   }
	   
	   if(Player_Twoclick==1)
	   {   
		  boolean c=f.getPlayer_TwoHorizontalData();
		  if(c==true)
		  {
		     for(int z=1;z<6;z++)
		     {
		    	 String value;
				 value=Integer.toString(z);
			     Player_Two[xcor][(ycor++)].setText(value);
			  }
		      counter++;
		      f.checkPoint(2);
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null, "oops! overlap Please select another area for slug");
		  }
	       Player_Twoclick=0;
	   }
	   
	   if(Player_Twoclick==2)
	   {   
		  boolean c=f.getPlayer_TwoVerticalData();
	 	  if(c==true)
	 	  {
	 		  for(int z=1;z<6;z++)
	 		  {
	 			  String value;
	 			  value=Integer.toString(z);
	 			  Player_Two[(xcor++)][ycor].setText(value);
	 		  }
	 		 counter++;
	 		f.checkPoint(2);
	 	  }
		  else
		  {
			  JOptionPane.showMessageDialog(null, "oops! overlap Please select another area for slug");
		  }
	       Player_Twoclick=0;
	   }
	   
	   if(Player_Twoclick==3)
	   {   
                f.getPlayer_TwoRandomData();
              
	      Player_Twoclick=0;
	   }
   }
}
		
}
