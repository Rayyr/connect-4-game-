package four_game;

 
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class game implements ActionListener {

	private JFrame frame;
	private JLabel label[],wellcome_lab,turn,winner;
	private JTextField player1,player2;
    private Image img;
    private String p1,p2;
    private JButton btn,btnnum[],end;
    private Icon btnicon_clkme,redball1,blueball2;
    
     
	
	game( ){
		 p1="";
		 p2="";
		  
		
		frame=new JFrame("connect four game");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(750,200);
		img= Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\eclipse-workspace\\4game\\bin\\four_game\\img.png");
		this.frame.setIconImage(img);
		this.frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.frame.setResizable(false);
		this.frame.getContentPane().setBackground(Color.lightGray);
		this.frame.setLocation(430,250);
             
		  
		label=new JLabel[3];
		label[0]=new JLabel("                               wellcome to connect four game");
		label[1]=new JLabel("please enter the name of the first player :       ");
		label[2]=new JLabel("please enter the name of the seconed player : ");
		
		
		
		
		player1=new JTextField(20);
		player2=new JTextField(20);
		player1.setFont(new Font("Serif", Font.PLAIN, 17));
		player2.setFont(new Font("Serif", Font.PLAIN, 17));
		
	    
		
		label[0].setFont(new Font("Serif", Font.PLAIN, 25));
		label[1].setFont(new Font("Serif", Font.PLAIN, 25));
		label[2].setFont(new Font("Serif", Font.PLAIN, 25));
		
		
		
		this.frame.add(label[0]);
		this.frame.add(label[1]);
		this.frame.add(player1);
		this.frame.add(label[2]);
		this.frame.add(player2);
		
		
		
		wellcome_lab=new JLabel("Start Playing");
		wellcome_lab.setFont(new Font("Serif", Font.PLAIN, 25));
		wellcome_lab.setBounds(295,30,700,60); 
		
		

	    btnicon_clkme=new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\4game\\bin\\four_game\\clkme.png");
		btn=new JButton(btnicon_clkme);
	    btn.setBounds(290,80,btnicon_clkme.getIconWidth(),btnicon_clkme.getIconHeight());
	    
	
	    
	    redball1=new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\4game\\bin\\four_game\\redball.png");
	    blueball2=new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\4game\\bin\\four_game\\blueball.png");
	    
	    
	    
		player1.addActionListener(this);
		player2.addActionListener(this);
		btn.addActionListener(this);
	 
	
		this.frame.setVisible(true);
		
				
	}
	
	
	
    public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource()==this.player1) {
				this.p1=e.getActionCommand();
				
			 
			}
			
			
			
			
			else if(e.getSource()==this.player2)
			{ 
				this.p2=e.getActionCommand();
				//System.out.print(p2);
				 

			}
			
			
			
			else if(e.getSource()==this.btn)//btn
			{
				 initialize_game();
			}
			
			
			else if(e.getSource()==this.end) {
				
				 
				 System.exit(0); 
				
				 
				 
			}
			
			
			else { // the game 42 buttons
				
				for(int j=0;j<42;j++) {
					 
					 if (btnnum[j].equals(e.getSource())) {
				    	/* first we must know the pressed button 
					    * we will give red ball for the 1st player 
						* we will give blue ball for the 2nd player */
						
						 
						
						if(this.turn.getText().equals(this.p1+" turn")) {
							// the turn for the 1st player so red ball 
							//System.out.print(j+" ");
							btnnum[j].setText(null);
							btnnum[j].setIcon(this.redball1);
							
							// to avoid the grey background of the disable mode , 
							// i select the disabeld icon the red ball
						    btnnum[j].setDisabledIcon(redball1);
							btnnum[j].setEnabled(false);
							
							
							// check if the 1st player won
							if(win(j)) {
								
								endgame(this.p1);
						 
							}
							
							else this.turn.setText(this.p2+" turn");
						}
						
						
						else if(this.turn.getText().equals(this.p2+" turn")) {
							// the turn for the 2nd player so red ball 
							
							btnnum[j].setText(null);
							btnnum[j].setIcon(this.blueball2);
							btnnum[j].setDisabledIcon(blueball2);
							btnnum[j].setEnabled(false);
							 
							
							// check if the 2nd player won 
							if(win(j)) {
								
								  endgame(this.p2);
							 
							}
							
							
							else this.turn.setText(this.p1+" turn");
						}
					}
				}
			}
			
			if(check())
			{
				    frame.getContentPane().removeAll();
				    frame.repaint(); 
					frame.revalidate(); 
				    frame.setLayout(null);
				   
				    
				    frame.add(wellcome_lab);
					frame.add(btn);
					this.frame.setVisible(true);
				    
			}
			return; 
			
		}
	
	public boolean check() {
		
		if(!(player1.getText().equals(""))&&!(player2.getText().equals(""))) 
		{
			this.player1.setText(null);
		    this.player1.setText(null);
			return true;
			
		}
		
		 
		
		return false;
	}
	
	
	public void initialize_game() {
		  
	 	   
		    frame.getContentPane().removeAll();
		    frame.repaint();
			frame.revalidate(); 
		    frame.setLayout(new BorderLayout());
		    frame.setSize(700,600);
		    

		    
		    turn=new JLabel(this.p1+" turn",SwingConstants.CENTER);
		    turn.setFont(new Font("Serif", Font.PLAIN,40)); 
		    
		 
		    frame.add(turn);
		    frame.add(turn ,java.awt.BorderLayout.NORTH) ;
		   
		    
		    
		    JPanel j=new JPanel();
		    j.setLayout(new java.awt.GridLayout(6,7));
		    btnnum=new JButton[42];
		    Integer i=42;
		    
		    
		    for(int x=0;x<42;x++) {
		    	
		        btnnum[x]= new JButton(i.toString());
		        btnnum[x].setFocusable(false);
		        btnnum[x].addActionListener(this);
		        j.add( btnnum[x]);
		    	i--;
		    	
		    }
		     
		   
		    //frame.add(j) as same as this 
		    frame.add(j,BorderLayout.CENTER);
		    	
		    this.frame.setVisible(true);
		
	}
  
   
    public boolean verticalwin(int i) {

	    // Vertically won
		boolean flag=true;
		int counter=1;
		int arr[]=new int[4];
		int c=0;
		
		for( int j=i,k=j+7;j<42 && k<42 && counter!=4 ;j=k,k+=7) {
			
			  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) {  
				  
				  flag=true;
				  counter++;
				  arr[c++]=j;
				  continue;
				  
			 }
			  
			  else {
				  
				  flag=false;
				  break;
				  
			  }
			  
		}
		
		if((flag==true)&&(counter==4)) {
			arr[3]=arr[2]+7;
			
			for(int r=0;r<4;r++) {
				
				if(this.turn.getText().equals(this.p1+" turn"))
			     this.btnnum[arr[r]].setBackground(Color.pink);
				else 
					this.btnnum[arr[r]].setBackground(Color.blue);
			}
			
			return true;
		}
		
		
		for(int r=0;r<4;r++) 
			arr[r]=0;
	     c=0;
			 
		
		for( int j=i,k=j-7;j<42 && k<42 && k>=0 && counter!=4 ;j=k,k-=7) {
			
			  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) { 
				  flag=true;
				  counter++;
				  arr[c++]= j;
				  continue;
				  
				  }
			  
			  
			  else {
				  flag=false;
				  break;
			  }
			
		}
		
	   
		 if((flag==true)&& (counter==4)) {
			 
			 arr[3]=arr[2]-7;
			 for(int r=0;r<4;r++) {
					
					if(this.turn.getText().equals(this.p1+" turn"))
				         this.btnnum[arr[r]].setBackground(Color.pink);
					else 
						this.btnnum[arr[r]].setBackground(Color.blue);
			 }
		  return true;
		  
		 }
		 
		 for(int r=0;r<4;r++) 
				arr[r]=0;
		     c=0;
		 
		 return false;
		 
    }
 
 
 
    public boolean horizantalwin(int i) {
	 
	    // Horizontally won
			boolean flag=true;
			int counter=1;
			int arr[]=new int[4];
			int c=0;
			
			for( int j=i,k=j+1;j<42 && k<42 && counter!=4 ;j=k,k++) {
				
				  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) {  
					  
					  flag=true;
					  counter++;
					  arr[c++]=j;
					  continue;
					  
				 }
				  
				  else {
					  
					  flag=false;
					  break;
					  
				  }
				  
			}
			
			if((flag==true)&&(counter==4)) {
				 arr[3]=arr[2]+1;
				 
				 for(int r=0;r<4;r++) {	 
						
						if(this.turn.getText().equals(this.p1+" turn"))
					        this.btnnum[arr[r]].setBackground(Color.pink);
						else 
							this.btnnum[arr[r]].setBackground(Color.blue);
			}
				
				return true;
		 
			}
			
			 
			 for(int r=0;r<4;r++) 
			    arr[c]=0;

			 c=0;
			 		 
			 
			for( int j=i,k=j-1; j<42 && k<42 && k>=0 && counter!=4 ;j=k,k--) {
				
				  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) { 
					  
					  flag=true;
					  counter++;
					  arr[c++]=j;
					  continue;
					  
				}
				  
				  
				  else {
					  flag=false;
					  break;
				  }
				
			}
			
		   
			 if((flag==true)&& (counter==4)) { 
				 arr[3]=arr[2]-1;;
				 for(int r=0;r<4;r++) {
					 
						
						if(this.turn.getText().equals(this.p1+" turn"))
					       this.btnnum[arr[r]].setBackground(Color.pink);
						else 
							this.btnnum[arr[r]].setBackground(Color.blue);
				 }
				 
			  return true;
			}
			 
			 for(int r=0;r<4;r++) 
					arr[r]=0;
			     c=0;
			 
			 return false;
			 
	 
 }
 
 
    public boolean diagonalwin(int i) {
	 
	    // diagonally won
			boolean flag=true;
			int counter=1;
			int arr[]=new int[4];
			int c=0;
			
			for( int j=i,k=j+8;j<42 && k<42 && counter!=4 ;j=k,k+=8) {
				
				  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) {  
					  
					  flag=true;
					  counter++;
					  arr[c++]=j;
					  continue;
					  
				 }
				  
				  else {
					  
					  flag=false;
					  break;
					  
				  }
				  
			}
			
			 if((flag==true)&& (counter==4)) {
				 arr[3]=arr[2]+8;
				 
				 for(int r=0;r<4;r++) 	{ 
						
						if(this.turn.getText().equals(this.p1+" turn"))
					       this.btnnum[arr[r]].setBackground(Color.pink);
						else 
							this.btnnum[arr[r]].setBackground(Color.blue);
				 }
					 
				  return true;
			 }
			 
			  
			 for(int r=0;r<4;r++) 
				 arr[r]=0;
				
			 c=0;
			
			for( int j=i,k=j-8; j<42 && k<42 && k>=0 && counter!=4 ;j=k,k-=8) {
				
				  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) { 
					  flag=true;
					  counter++;
					  arr[c++]=j;
					  continue;
					  
					  }
				  
				  
				  else {
					  flag=false;
					  break;
				  }
				
			}
			
		   
			 if((flag==true)&& (counter==4)) {
				 arr[3]=arr[2]-8;
				 
				 for(int r=0;r<4;r++) {	 
						
						if(this.turn.getText().equals(this.p1+" turn"))
					     this.btnnum[arr[r]].setBackground(Color.pink);
						else 
							this.btnnum[arr[r]].setBackground(Color.blue);
			 }
				 
			  return true;
			 }		
			 
			 counter=1;
			 
			 
			 for(int r=0;r<4;r++) 
				 arr[r]=0;
			 
			 c=0;
			 
				for( int j=i,k=j+6; j<42 && k<42 && k>=0 && counter!=4 ;j=k,k+=6) {
					
					  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) { 
						  flag=true;
						  counter++;
						  arr[c++]=j;
						  continue;
						  
						  }
					  
					  
					  else {
						  flag=false;
						  break;
					  }
					
				}
				
				
				 if((flag==true)&& (counter==4)) {
					 arr[3]=arr[2]+6;
					 for(int r=0;r<4;r++) {
							
							if(this.turn.getText().equals(this.p1+" turn"))
						       this.btnnum[arr[r]].setBackground(Color.pink);
							else 
								this.btnnum[arr[r]].setBackground(Color.blue);
					 }
						 
					  return true;
				 }
				 
			 
					 for(int r=0;r<4;r++) 
						 arr[r]=0;
					
					 c=0;
				 
				 
				for( int j=i,k=j-6; j<42 && k<42 && k>=0 && counter!=4 ;j=k,k-=6) {
					
					  if(btnnum[j].getIcon().equals(btnnum[k].getIcon())) { 
						  flag=true;
						  counter++;
						  arr[c++]=j;
						  continue;
						  
						  }
					  
					  
					  else {
						  flag=false;
						  break;
					  }
					
				}
			 
				 if((flag==true)&&(counter==4)) {
					  
						 arr[3]=arr[2]-6;
						 
						 for(int r=0;r<4;r++) { 	 
								
								if(this.turn.getText().equals(this.p1+" turn"))
							     this.btnnum[arr[r]].setBackground(Color.pink);
								else 
									this.btnnum[arr[r]].setBackground(Color.blue);
						 
				 }
						 
					 
					  return true;
				 }
				 
				 
					 for(int r=0;r<4;r++) 
						 arr[r]=0;
						
					 c=0;
					 
				 
				 
			 return false;
 }
  
	
 
    public boolean win(int i) {
		
		// may be the player win vertically or horizantlly or diagonally with 4 balls
		
		
          if(verticalwin(i)==true)
        	  return true;
          
          if(horizantalwin(i)==true)
              return true;
           
          if(diagonalwin(i)==true)
          return true;
          
          
          
          return false;
          
          
		
		
	}
	
 
    public void endgame(java.lang.String winner_player) {
	 
     // to remove the string - turn - from the turn label so we use this function 
	    
    	JPanel theend;
    	theend=new JPanel();
    	theend.setLayout(new java.awt.FlowLayout());
    	frame.remove(turn);
    	frame.revalidate();
    	 
       
    	// there is no need to disable the buttons because we have changed the text of turn string 
	    end=new JButton("Congratslation "+this.turn.getText().split(" ")[0]+" , End game");
	    end.setFont(new Font("Serif", Font.PLAIN,30)); 
	    end .setFocusable(false);
	    end.addActionListener(this);
	    //when it is removed , it will be removed from the frame , but it will be still fund in the obj members 
	    turn.setText(" ");
	    
	    theend.add(end);
	    frame.add(theend,BorderLayout.NORTH);
	    frame.setVisible(true);
	 
	 
 }
 
 
  
 

 
	
	
	
}
