
package proyectounidad2;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class vent extends JPanel implements ActionListener , KeyListener, MouseListener, MouseWheelListener {
	// ventana
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    public JMenuBar arc;
    public JMenu uno;
    public JMenuItem u,u1,u2,u3,u4,u5,u6,u7,u8;
    public JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int op;
    
    private punto2 [] figura;
	private punto2[] p;
    public vent (String titulo, punto2[] figura) {
    	// inicializar la ventana
        ventana = new JFrame("Pacman");
        // definir tamaño a ventana
        ventana.setSize(1200, 1080);
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
        uno = new JMenu("Acciones");
        u = new JMenuItem("Escalar");
        u1 = new JMenuItem("Trasladar");
        u2 = new JMenuItem("Rotacion");
        u3 = new JMenuItem("Rotacion inversa");
        u4 = new JMenuItem("Reflexion X");
        u5 = new JMenuItem("Reflexion Y");
        u6 = new JMenuItem("Reflexion XY");
        u7 = new JMenuItem("Deformacion");
        u8 = new JMenuItem("Redibujar");
        add(arc);
        arc.add(uno);
        uno.add(u);
        uno.add(u1);
        uno.add(u2);
        uno.add(u3);
        uno.add(u4);
        uno.add(u5);
        uno.add(u6);
        uno.add(u7);
        uno.add(u8);
        u.addActionListener(this);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        u6.addActionListener(this);
        u7.addActionListener(this);
        u8.addActionListener(this);
        b= new JButton("Escalar");
        b1= new JButton("Traslacion");
        b2=new JButton("Rotacion");
        b3= new JButton("Rotacion inversa");
        b4= new JButton("Reflexion X");
        b5= new JButton("Reflexion Y");
        b6= new JButton("Reflexion XY");
        b7=new JButton("Deformacion");
        b8= new JButton("Redibujar");
        b9=new JButton("Ayuda");
        arc.add(b);
        arc.add(b1);
        arc.add(b2);
        arc.add(b3);
        arc.add(b4);
        arc.add(b5);
        arc.add(b6);
        arc.add(b7);
        arc.add(b8);
        arc.add(b9);
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
      
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setFocusable(true);
        ventana.addKeyListener(this);
        ventana.setLocationRelativeTo(null);
	        
        contenedor = ventana.getContentPane();
        contenedor.setSize(1200, 1080);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura = figura;
        p=figura;
        addMouseListener(this);
        addMouseWheelListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	
    	super.paintComponent(g);
    	g.setColor(Color.blue);
    	this.dibujar(g);  	
    }
    
    public void actionPerformed(ActionEvent e){
    	
        if(e.getSource()==u){
            Double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de traslación en X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor de traslación en Y"));
            this.escalar(x,y);
            repaint();
        }
        if(e.getSource()==u1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingresar el valor de traslación en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingresar el valor de traslación en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u2){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor del ángulo"));
            this.Rotacion(angulo);
            repaint();
        }
        if(e.getSource()==u3){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingresar el valor del ángulo"));
            this.rotacionneg(angulo);
            repaint();
        }
        if(e.getSource()==u4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==u5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==u6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==u7){
            double x,y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor para la deformacion de X"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor para la deformacion de Y"));
            this.deformacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u8){
            this.redibujar();
            repaint();
        }
        if(e.getSource()==b){
            this.escalar(.8,.8);
            ventana.repaint();
        }
        if(e.getSource()==b1){
            this.traslacion(15,15);
            ventana.repaint();
        }
        if(e.getSource()==b2){
            this.Rotacion(10);
            repaint();
        }
        if(e.getSource()==b3){
            this.rotacionneg(10);
            repaint();
        }
        if(e.getSource()==b4){
            this.reflexionx();
            repaint();
        }
        if(e.getSource()==b5){
            this.reflexiony();
            repaint();
        }
        if(e.getSource()==b6){
            this.reflexionxy();
            repaint();
        }
        if(e.getSource()==b7){
            this.deformacion(.5,.5);	
            ventana.repaint();
        }
        if(e.getSource()==b8){
            this.redibujar();
            repaint();
        }if(e.getSource()==b9){
            JOptionPane.showMessageDialog(null, "Funciones del teclado \n Presionar \n1.-Escalar"
            		+ "\n2.-Trasladar"
            		+ "\n3.-Rotar derecha"
            		+ "\n4.-Rotar izquierda"
            		+ "\n5.-Reflexion X"
            		+ "\n6.-Reflexion Y"
            		+ "\n7.-Reflexion XY"
            		+ "\n8.-Deformacion"
            		+ "\n Flecha arriba.-Se mueve arriba 5 píxeles"
            		+ "\n Flecha abajo.-Se mueve abajo 5 píxeles"
            		+ "\n Flecha izquierda.-Se mueve izquierda 5 píxeles"
            		+ "\n Flecha derecha.-Se mueve derecha 5 píxeles");
           
        }
    }
    public void escalar(double fx, double fy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto2 punto : figura) {
        //punto x:((x – tx) * fx) + tx
        //punto y:((y – ty) * fy) + ty
            punto.setX((int)(((punto.getX() - tx)* fx) + tx));
            punto.setY((int)(((punto.getY() - ty)* fy) + ty));
        }
    }
    public void traslacion(int xf, int yf){
        for (punto2 punto : figura) {
        //punto x:((x - xf) 
        //punto y: ((y - yf)
            punto.setX((int)(punto.getX() + xf));
            punto.setY((int)(punto.getY() + yf));
        }
    }
    public void Rotacion (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto2 punto : figura) {
        //punto x:(x - tx) * cos – (b – ty) * sin + tx
        //punto y: (x - ty) * sin + (b – ty) * cos + ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
    public void rotacionneg(double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto2 punto : figura) {
        //punto x:((a-tx)cos + (b-ty)(sen)) +tx
        //punto y: (-(a-tx)(sen) + (b-ty)(cos))+ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))+(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)(-(punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
    public void reflexionx(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(punto2 punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) (punto.getY()-ty)+ty);
        }
    }public void reflexiony(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(punto2 punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) (punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void reflexionxy(){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for(punto2 punto :figura){
            //punto x:-(a – tx) + tx
            //punto y: (b – ty) + ty
            punto.setX((int) -(punto.getX()-tx)+tx);
            punto.setY((int) -(punto.getY()-ty)+ty);
        }
    }
    public void deformacion(double dx, double dy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (punto2 punto : figura) {
        //punto x:((x - tx) + (b - ty) * dx) + tx
        //punto y: ((y - ty) * dy + (b – ty )) + ty
            punto.setX((int)(((punto.getX() - tx)+ (punto.getY()-ty)*dx + tx)));
            punto.setY((int)(((punto.getY() - ty)* dy + (punto.getY()-ty) + ty)));
        }
    }
    public void setFigura(punto2 figura[]){
        this.figura=figura;
    }
   
    
    //dibujar la figura original 
	private void dibujar(Graphics g) {
		for(int i=0; i<figura.length -1;i++) {
			g.drawLine(this.figura[i].getX(),
					this.figura[i].getY(),
					this.figura[i +1].getX(),
					this.figura[i +1].getY());
		}
	}
	
	 @Override
	    public void keyTyped(KeyEvent e) {
	    }
	 
	 @Override
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_1){
	            this.escalar(.5,.5);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_2){
	            this.traslacion(10, 1);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_3){
	            this.Rotacion(5.0);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_4){
	            this.rotacionneg(5.0);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_5){
	            this.reflexionx();
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_6){
	            this.reflexiony();
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_7){
	            this.reflexionxy();
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_8){
	            this.deformacion(.1, .1);
	            repaint();
	        }
	        if(e.getKeyCode()==KeyEvent.VK_9){
	            this.redibujar();
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_UP){
	            this.traslacion(0, -5);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_DOWN){
	            this.traslacion(0, 5);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_LEFT ){
	            this.traslacion(-5, 0);
	            repaint();
	        }
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
	            this.traslacion(5, 0);
	            repaint();
	        }
	        
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
	        
	        
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
	        if(e.getButton()==1){
	            this.traslacion(10,10);
	            ventana.repaint();
	        }
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	      if(e.getButton()==3){
	            this.traslacion(-5,-5);
	            repaint();
	        }
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	    }

	    @Override
	    public void mouseWheelMoved(MouseWheelEvent e) {
	        double scroll = .1;
	        scroll = (e.getWheelRotation() > 0) ? 1 + scroll : 1 - scroll;
	        this.escalar( scroll, scroll);
	        repaint();
	    }
	    public void redibujar(){
	        punto2 fig[] = {
	        		new punto2(650, 200),
	            new punto2(400, 200),
	            new punto2(400, 250),
	            new punto2(350, 250),
	            new punto2(350, 300),
                    new punto2(300, 300),
                    new punto2(300, 350),
                    new punto2(250, 350),
                    new punto2(250, 550),
                    new punto2(300, 550),
                    new punto2(300, 600),
                    new punto2(350, 600),
                    new punto2(350, 650),
                    new punto2(400, 650),
                    new punto2(400, 700),
                    new punto2(650, 700),
                    new punto2(650, 650),
                    new punto2(720, 650),
                    new punto2(720, 600),
                    new punto2(770, 600),
                    new punto2(770, 550),
                    new punto2(700, 550),
                    new punto2(700, 520),
                    new punto2(600, 520),
                    new punto2(600, 490),
                    new punto2(520, 490),
                    new punto2(520, 440),   
                    new punto2(600, 440),
                    new punto2(600, 410),
                    new punto2(700, 410),
                    new punto2(700, 380),
                    new punto2(770, 380),
                    new punto2(770, 330),
                    new punto2(720, 330),
                    new punto2(720, 280),
                    new punto2(650, 280),
                    new punto2(650, 200),
	        };
	        setFigura(fig);
	        repaint();
	    }
	

}