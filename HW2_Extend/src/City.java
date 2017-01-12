import java.util.ArrayList;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * DESCRIPTION: Calling all other classes in the City's main class, displaying the names, pay, and occupants of buildings.
 * @author tle19
 * Uses already-input names and information to display
 * UPDATE: Now has graphical view using clipart images.
 */
public class City extends JComponent implements MouseMotionListener, MouseListener {
	/**
	 * Allows the imported images to be placed in a specific spot on the screen for easier drag.
	 */
	// int imageX, imageY;
	int drag = 0;
	int imageK1x = 10; // Kx = coordinates for Kid on X-axis
	int imageK1y = 10; // Ky = coordinates for Kid on Y-axis
	int imageK2x = 36, imageK2y = 36;
	int imageP1x = 880, imageP1y = 20; // Px = Police on x, Py = Police on y
	int imageP2x = 860, imageP2y = 40;
	int imageT1x = 50, imageT1y = 650; // Tx = Teacher on x, Ty = Teacher on y;
	int imageT2x = 40, imageT2y = 600;
	
	/**
	 *  Manually calls the implements people and buildings 
	 */
	PersonClass[] people = { new Police("Frank",63,5558565,Police.Rank.Chief), 
			 				 new Police("Tabitha",41,5559070,Police.Rank.Sargeant), 
			 				 new Police("Geoffrey",49,5552345,Police.Rank.Captain),
			 				 new Police("Ethan",26,5559779,Police.Rank.Patrol),
			 				 new Teacher ("Tina",34,7771234,8,"Math"),
			 				 new Teacher ("Duncan",52,7774590,11,"English"),
			 				 new Teacher ("Lucas",30,7778018,12,"French"),
			 				 new Kid("Nini",9,5440805,"Gummy Bears"),
			 				 new Kid("Esther",4,5441124,"Chocolate"),
			 				 new Kid("Kristen",15,5441124,"Starburst")};
	Building[] building = {  new CityHall("City Hall","123 Front St."), 
			 				 new CityHall("Police Station","714 Front St."), 
			 				 new CityHall("Grocery Store","110 West Ave."), 
			 				 new School("Elementary School","987 Back St."),
			 				 new School("Middle School","453 East Ave."),
			 				 new School("High School","576 West Ave.")};
	
	CityHall c = (CityHall) building[1];
	School s = (School) building[3];
	String PolOfc1 = people[0].getName();
	String PolOfc2 = people[1].getName();
	String PolOfc3 = people[3].getName();
	String Teach1 = people[4].getName();
	String Teach2 = people[6].getName();
	String Kid1 = people[8].getName();
	String Kid2 = people[9].getName();
	
	Image kid, kid1, city, school, cityHall, police, police1, teacher, teacher1;
	public City(Image k, Image k1, Image elementary, Image cityhall, Image p, Image p1, Image town, Image t, Image t1){
		kid = k;
		kid1 = k1;
		school = elementary;
		cityHall = cityhall;
		city = town;
		police = p;
		police1 = p1;
		teacher = t;
		teacher1 = t1;
				/**
				 * Calls the MouseMotionListener and MouseListener to implement the variables to click, drop, drag
				 */
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e){}
	public void mouseEnter(MouseEvent e) {}
	public void mouseClick(MouseEvent e) {}
			/**
			 * Use mousePressed to implement which character is  being clicked and pressed, allowing it to be dragged to another location.
			 */
	public void mousePressed(MouseEvent e) {
			if (e.getX()>= imageK1x && e.getX()<= imageK1x+80 && e.getY() >= imageK1y && e.getY() <= imageK1y+80)
				drag = 1;
			else if (e.getX()>= imageK2x && e.getX()<= imageK2x+80 && e.getY() >= imageK2y && e.getY() <= imageK2y+80)
				drag = 2;
			else if (e.getX()>= imageT1x && e.getX()<= imageT1x+80 && e.getY() >= imageT1y && e.getY() <= imageT1y+80)
				drag = 3;
			else if (e.getX()>= imageT2x && e.getX()<= imageT2x+80 && e.getY() >= imageT2y && e.getY() <= imageT2y+80)
				drag = 4;
			else if (e.getX()>= imageP1x && e.getX()<= imageP1x+80 && e.getY() >= imageP1y && e.getY() <= imageP1y+80)
				drag = 5;
			else if (e.getX()>= imageP2x && e.getX()<= imageP2x+80 && e.getY() >= imageP2y && e.getY() <= imageP2y+80)
				drag = 6;
	}
			/**
			 *  If character gets released within vicinity of building, display the information of building.
			 *  Uses the coordinate area of the building to show the occupants as well as name and address. 
			 */
	public void mouseReleased(MouseEvent e) {
		drag = 0;
		if(e.getX() > 298 && e.getX() < 684 && e.getY() > 60 && e.getY() < 400) {
			System.out.printf("%s,%s \n",building[0].name,building[0].address,"\n");
			c.showOcc();
		}
		else if(e.getX() > 35 && e.getX() < 360 && e.getY() > 300 && e.getY() < 590) {
			System.out.printf("%s,%s \n",building[3].name,building[3].address,"/n");
			s.showOcc();
		}
		else if(e.getX() > imageT1x && e.getX() < imageT1x+80) {
			System.out.printf("%s,%d,%d\n",people[4].getName(),people[4].getAge(),people[4].getPhone());
		}
		else if(e.getX() > imageP1x && e.getX() < imageP1x+80) {
			Police p1 = (Police) people[0];
			System.out.printf("%s,%d,%d,%s\n",people[0].getName(),people[0].getAge(),people[0].getPhone(),p1.getRole());
		}
		else if(e.getX() > imageP2x && e.getX() < imageP2x+80) {
			Police p2 = (Police) people[1];
			System.out.printf("%s,%d,%d,%s\n",people[1].getName(),people[1].getAge(),people[1].getPhone(),p2.getRole());
		}
		else if(e.getX() > imageK1x && e.getX() < imageK1x+80) {
			System.out.printf("%s,%d,%d\n",people[8].getName(),people[8].getAge(),people[8].getPhone());
		}
	}
			/**
			 * If one of the characters is clicked, see which character is clicked and drag that character.
			 */
	public void mouseDragged(MouseEvent e)
	{	
		if(drag == 0) {
			if (e.getX()>= imageK1x && e.getX()<= imageK1x+80 && e.getY() >= imageK1y && e.getY() <= imageK1y+80)
				drag = 1;
			else if (e.getX()>= imageK2x && e.getX()<= imageK2x+80 && e.getY() >= imageK2y && e.getY() <= imageK2y+80)
				drag = 2;
			else if (e.getX()>= imageT1x && e.getX()<= imageT1x+80 && e.getY() >= imageT1y && e.getY() <= imageT1y+80)
				drag = 3;
			else if (e.getX()>= imageT2x && e.getX()<= imageT2x+80 && e.getY() >= imageT2y && e.getY() <= imageT2y+80)
				drag = 4;
			else if (e.getX()>= imageP1x && e.getX()<= imageP1x+80 && e.getY() >= imageP1y && e.getY() <= imageP1y+80)
				drag = 5;
			else if (e.getX()>= imageP2x && e.getX()<= imageP2x+80 && e.getY() >= imageP2y && e.getY() <= imageP2y+80)
				drag = 6;
		}
				/**
				 * If the character is dragged into the vicinity of a building and add the name of character in building.
				 */
		if (drag == 1) {
			imageK1x = e.getX();
			imageK1y = e.getY();	
				if(imageK1x > 35 && imageK1x < 360 && imageK1y > 300 && imageK1y < 590) {
					s.addOcc(Kid1);
				}
				else if (imageK1x > 35 || imageK1x < 360 || imageK1y > 300 || imageK1y < 590) {
					s.removeOcc(Kid1);
				}
		}
		if (drag == 2) {
			imageK2x = e.getX();
			imageK2y = e.getY();	
				if(imageK2x > 40 && imageK2x < 360 && imageK2y > 300 && imageK2y < 600) {
					s.addOcc(Kid2);
				}
				else if (imageK2x > 35 || imageK2x < 360 || imageK2y > 300 || imageK2y < 590) {
					s.removeOcc(Kid2);
				}
		}
		if (drag == 3) {
			imageT1x = e.getX();
			imageT1y = e.getY();
				if(imageT1x > 35 && imageT1x < 360 && imageT1y > 300 && imageT1y < 590) {
					s.addOcc(Teach1);
				}
				else if (imageT1x > 35 || imageT1x < 360 || imageT1y > 300 || imageT1y < 590) {
					s.removeOcc(Teach1);
				}
		}
		if (drag == 4) {
			imageT2x = e.getX();
			imageT2y = e.getY();
				if(imageT2x > 35 && imageT2x < 360 && imageT2y > 300 && imageT2y < 590) {
					s.addOcc(Teach2);
				}
				else if (imageT2x > 35 || imageT2x < 360 || imageT2y > 300 || imageT2y < 590) {
					s.removeOcc(Teach2);
				}
		}
		if (drag == 5) {
			imageP1x = e.getX();
			imageP1y = e.getY();
				if(imageP1x > 298 && imageP1x < 684 && imageP1y > 60 && imageP1y < 400) {
					c.addOcc(PolOfc1);
				}
				else if (imageP1x > 298 || imageP1x < 684 || imageP1y > 60 || imageP1y < 400) {
					c.removeOcc(PolOfc1);
				}
		}
		if (drag == 6) {
			imageP2x = e.getX();
			imageP2y = e.getY();
				if(imageP1x > 298 && imageP1x < 684 && imageP1y > 60 && imageP1y < 400) {
					c.addOcc(PolOfc2);
				}
				else if (imageP1x > 298 || imageP1x < 684 || imageP1y > 60 || imageP1y < 400) {
					c.removeOcc(PolOfc2);
				}
		}
		repaint();
	}
			/**
			 * Draws the images of characters and buildings in the console.
			 */
	public void paint(Graphics g){
		Graphics2D g2=(Graphics2D)g;
		// int x = imageX;
		// int y =imageY;
		g2.drawImage(city,0,0,this);
		g2.drawImage(kid, imageK1x, imageK1y, this);
		g2.drawImage(kid1, imageK2x, imageK2y, this);
		g2.drawImage(teacher, imageT1x, imageT1y, this);
		g2.drawImage(teacher1, imageT2x, imageT2y, this);
		g2.drawImage(police, imageP1x, imageP1y, this);
		g2.drawImage(police1, imageP2x, imageP2y, this);
		g2.drawImage(school,35,300,this);
		g2.drawImage(cityHall, 298, 60, this);
	}
	static int imageWidth = 80, imageHeight = 80; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String city = "/Resource/city.png";
		String kid = "/Resource/kid.png";
		String kid1 = "/Resource/kid1.png";
		String teacher = "/Resource/teacher.png";
		String teacher1 = "/Resource/teacher1.png";
		String school = "/Resource/School.png";
		String cityHall = "/Resource/hall.png";
		String polofc = "/Resource/policepng.png";
		String polofc1 = "/Resource/police.png";
				/**
				 * Imports the png files in and set the size and implement into the city.
				 */
		Image poloff = Toolkit.getDefaultToolkit().getImage(City.class.getResource(polofc));
		poloff = poloff.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
		URL u = City.class.getResource(polofc1);
		Image poloff1 = Toolkit.getDefaultToolkit().getImage(u);
		poloff1 = poloff1.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		Image gteach = Toolkit.getDefaultToolkit().getImage(City.class.getResource(teacher));
		gteach = gteach.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
		Image bteach = Toolkit.getDefaultToolkit().getImage(City.class.getResource(teacher1));
		bteach = bteach.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
		Image gkid = Toolkit.getDefaultToolkit().getImage(City.class.getResource(kid));
	    gkid = gkid.getScaledInstance(imageWidth,imageHeight,Image.SCALE_SMOOTH);
	    Image gkid1 = Toolkit.getDefaultToolkit().getImage(City.class.getResource(kid1));
	    gkid1 = gkid1.getScaledInstance(imageWidth,imageHeight,Image.SCALE_SMOOTH);
	    
	    Image town = Toolkit.getDefaultToolkit().getImage(City.class.getResource(city));
	    Image elementary = Toolkit.getDefaultToolkit().getImage(City.class.getResource(school));
	    Image cityhall = Toolkit.getDefaultToolkit().getImage(City.class.getResource(cityHall));
	    elementary = elementary.getScaledInstance(325,290,Image.SCALE_DEFAULT);
	    cityhall = cityhall.getScaledInstance(400,343,Image.SCALE_DEFAULT);
	    
	    		/**
	    		 *  Sets the background image as the default and implements all the variable on top of the default.
	    		 */
	    JFrame frame = new JFrame("DragImage");  
	      frame.add(new City(gkid, gkid1, elementary, cityhall, poloff, poloff1, town, gteach, bteach));
	      frame.setSize(1065,843);
	      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      frame.setVisible(true);
		
		/**
		 * DESCRIPTION: Takes the input length of occupants to display the values already assigned in PersonClass.
		 */
	    /*
		System.out.printf("People in City: \n");
		for(int i=0; i < people.length; i++) {
			System.out.printf("%s, %d, %d \n", people[i].getName(), people[i].getAge(), people[i].getPhone());
		}
		System.out.printf("\nBuildings in City: \n");
		for(int i=0; i < building.length; i++) {
			System.out.printf("%s, %s \n", building[i].name, building[i].address);
		}
		String PolOfc1 = people[0].getName();
		String PolOfc2 = people[1].getName();
		String PolOfc3 = people[3].getName();
		CityHall c = (CityHall) building[0];
		c.addOcc(PolOfc1);
		c.addOcc(PolOfc2);
		c.addOcc(PolOfc3);
		c.showOcc();
		
		String Teach1 = people[4].getName();
		String Teach2 = people[6].getName();
		String Kid1 = people[8].getName();
		String Kid2 = people[9].getName();
		
		School s = (School) building[3];
		s.addOcc(Teach1);
		s.addOcc(Teach2);
		s.addOcc(Kid1);
		s.addOcc(Kid2);
		s.showOcc();
		
		Teacher t1 = (Teacher) people[5];
		t1.pay();
		System.out.printf("\n%s's monthly paycheck values at: %d \n", t1.name, t1.pay());
		Police p1 = (Police) people[2];
		p1.pay();
		System.out.printf("%s's monthly paycheck values at: %d \n", p1.name, p1.pay());
		*/
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}

}
