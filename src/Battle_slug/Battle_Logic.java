package Battle_slug;
/**
 *date:2016/01/02
 * @author dhanraj giri
 */
import java.awt.Color;
import static Battle_slug.Battle_Game.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Battle_Logic{
	
	public void disable(JButton p[][],int player)
	{ for(int i=0;i<12;i++)
	 {
    	for(int j=0;j<12;j++)
    	{
             if(player==1)
               {
                   Player_Oneview.setEnabled(false);
                   Player_Oneplay.setEnabled(false);
               }
               if(player==2)
               {
                   Player_Twoview.setEnabled(false);
                   Player_Twoplay.setEnabled(false);
               }
    		p[i][j].setEnabled(false);
    		xcor=-1;
    		ycor=-1;
    	}
	 }
		
	}
	
        public void enable(JButton p[][], int player)
	{ 
            for(int i=0;i<12;i++)
	 {
    	for(int j=0;j<12;j++)
    	{
               if(player==1)
               {
                   Player_Oneview.setEnabled(true);
                   Player_Oneplay.setEnabled(true);
               }
               if(player==2)
               {
                   Player_Twoview.setEnabled(true);
                   Player_Twoplay.setEnabled(true);
               }
                if(p[i][j].getBackground()==Color.gray)
                {
                    p[i][j].setEnabled(true);
                }
    		
    	}
	 }
		
	}	
        
	public void invisible()
	{
		jPlayer_One.setVisible(false);
		jp5.setVisible(true);
		jPlayer_Two.setVisible(false);
		jp6.setVisible(true);
		Player_Oneclick=10;
		gameplayer=1;
	}
	public boolean getPlayer_OneVerticalData()
	{
		int a,b;
		a=xcor;
		b=ycor;
		while(a<(xcor+5))
	  	{
			 if(a>11)
			 {
			 	return false;
			 }
			 String s=Player_One[a][b].getText();
			 if(!s.equals(""))
			 {
			  	return false;
			 }
		  	a++;  	
	  	}
	  	return true;
	}

	public boolean getPlayer_OneHorizontalData()
	{
		int a,b;
		a=xcor;
		b=ycor;
		while(b<(ycor+5))
	  	{
			if(b>11)
		  	{
		  		return false;
		  	}
		  	String s=Player_One[a][b].getText();
		  	if(!s.equals(""))
		  	{
			  	return false;
		  	} 
		  	b++;
	  	}
	  	return true;
	}

	public boolean getPlayer_TwoVerticalData()
	{
		int a,b;
		a=xcor;
		b=ycor;
		while(a<(xcor+5))
	  	{
			 if(a>11)
			 {
			 	return false;
			 }
			 String s=Player_Two[a][b].getText();
			 if(!s.equals(""))
			 {
			  	return false;
			 }
		  	a++;  	
	  	}
	  	return true;
	}

	public boolean getPlayer_TwoHorizontalData()
	{
		int a,b;
		a=xcor;
		b=ycor;
		while(b<(ycor+5))
	  	{
			if(b>11)
		  	{
		  		return false;
		  	}
		  	String s=Player_Two[a][b].getText();
		  	if(!s.equals(""))
		  	{
			  	return false;
		  	} 
		  	b++;
	  	}
	  	return true;
	}


	public int getNonZeroRandomNumber(){
	int ii = -1 + (int) (Math.random() * ((1 - (-1)) + 1));
    if(ii==0)
    	return getNonZeroRandomNumber();
    
    return ii;
}

 public void checkPoint(int player)
	{
		   if(counter==5)
		      {
		    	 JOptionPane.showMessageDialog(null, "You have placed all five slugs");
		    	 for(int i=0;i<12;i++)
		    	 {
		        	for(int j=0;j<12;j++)
		        	{
		        		if(player==1)
		        		{
		  		          Player_Onerandom.setEnabled(false);
				          Player_Onevertical.setEnabled(false);
				          Player_Onehorizontal.setEnabled(false);
				          Player_Tworandom.setEnabled(true);
				          Player_Twovertical.setEnabled(true);
				          Player_Twohorizontal.setEnabled(true);
				          counter=0;
				          Player_Two[i][j].setEnabled(true);
				          Player_One[i][j].setEnabled(false);
		        		}
		        		
		        		if(player==2)
		        		{
		        			  Player_Tworandom.setEnabled(false);
					          Player_Twovertical.setEnabled(false);
					          Player_Twohorizontal.setEnabled(false);
					          Player_Two[i][j].setEnabled(false);
                                                  Player_Oneview.setEnabled(true);
                                                  Player_Oneplay.setEnabled(true);
                                                  this.invisible();
		        		}
		        	}
		         }
		      }
	}
 
 public void getPlayer_OneRandomData()
{

	int x=xcor;
	int y=ycor;
	int d=xcor,e=ycor;
	for(int a=1;a<=5;a++)
	{
                              
			int ii=this.getNonZeroRandomNumber();
			int v =(int) (Math.random() *10);
			if(v%2==1)
			{
				if(x==0&&ii==-1){
					ycor=e;
					y=ycor;
					a--;
					continue;
				}
				if(x==11&&ii==1){
					ycor=e;
					y=ycor;
					a--;
					continue;
				}
				x=xcor+ii;
				if(x==xcor)
				{
					 ii=this.getNonZeroRandomNumber();
				}
				xcor=x;
			}
			else
			{
				if(y==0&&ii==-1){
					xcor=d;
					x=xcor;
					a--;
					continue;
				}
				if(y==11&&ii==1){
					xcor=d;
					x=d;
					a--;
					continue;
				}
				y=ycor+ii;
				if(y==ycor)
				{
					ii=this.getNonZeroRandomNumber();
				}
				ycor=y;
			}
			if(a==1)
			{
				xcor=d;
				ycor=e;
			}
                         String w=Player_One[xcor][ycor].getText();
			if(w.equals(""))
			{
				String value=Integer.toString(a);
				d=xcor;
				e=ycor;
				Player_One[xcor][ycor].setText(value);
                                randomPlayer_One++;
			}
			else
			{
                                xcor=d;
				ycor=e;
				a--;
                       }
	}
        if(randomPlayer_One==5)
        {
            randomPlayer_One=0;
            counter++;
            this.checkPoint(1);
        }
        
}
     	
 public void getPlayer_TwoRandomData(){
	int x=xcor;
	int y=ycor;
	int d=xcor,e=ycor;
	for(int a=1;a<=5;a++)
	{
			int ii=this.getNonZeroRandomNumber();
			int v =(int) (Math.random() *10);
			if(v%2==1)
			{
				if(x==0&&ii==-1){
					ycor=e;
					y=ycor;
					a--;
					continue;
				}
				if(x==11&&ii==1){
					ycor=e;
					y=ycor;
					a--;
					continue;
				}
				x=xcor+ii;
				if(x==xcor)
				{
					 ii=this.getNonZeroRandomNumber();
				}
				xcor=x;
			}
			else
			{
				if(y==0&&ii==-1){
					xcor=d;
					x=xcor;
					a--;
					continue;
				}
				if(y==11&&ii==1){
					xcor=d;
					x=d;
					a--;
					continue;
				}
				y=ycor+ii;
				if(y==ycor)
				{
					ii=this.getNonZeroRandomNumber();
				}
				ycor=y;
			}
			if(a==1)
			{
				xcor=d;
				ycor=e;
			}
			String w=Player_Two[xcor][ycor].getText();
			if(w.equals(""))
			{
				String value=Integer.toString(a);
				d=xcor;
				e=ycor;
				Player_Two[xcor][ycor].setText(value);
                                randomPlayer_Two++;                                
			}
			else
			{
				xcor=d;
				ycor=e;
				a--;
			}
	}
        if(randomPlayer_Two==5)
        {
            randomPlayer_Two=0;
            counter++;
            this.checkPoint(2);
        }
 }	
}