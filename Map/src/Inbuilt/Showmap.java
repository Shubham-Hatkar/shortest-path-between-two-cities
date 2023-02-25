package Inbuilt;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Showmap extends JFrame 
{
	Showmap()
	{
		setLayout(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("map presentation.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 700);
		add(image);
		
		
		
		setSize(800,740);
		setLocation(470,0);
		setVisible(true); 
	}
	public static void main(String args[])
	{
		new Showmap();
	}
}
