package gui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class JPanerRadiusBorder extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
    private int cornerRadius = 15;
    public JPanerRadiusBorder(int radius) {
        super();
        setOpaque(true);
        cornerRadius = radius;
    }

    public JPanerRadiusBorder(int radius, String title) {
        super();
        setOpaque(true);
        cornerRadius = radius;
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setBackground(backgroundColor);

        } else {
            graphics.setColor(getBackground());
        }
        
       
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint border
    }
}
