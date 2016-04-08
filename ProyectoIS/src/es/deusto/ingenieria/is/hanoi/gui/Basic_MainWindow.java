package es.deusto.ingenieria.is.hanoi.gui;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class Basic_MainWindow extends JFrame{
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel mainPanel;
	protected JPanel bottomPanel;
	protected JPanel panelPeg1;
	protected JPanel panelPeg2;
	protected JPanel panelPeg3;
	protected JPanel panelPeg4;
	protected JPanel panelPeg5;
	protected JButton createButton;
	protected JButton solveButton;
	protected JComboBox<String> algoCB;
	protected JComboBox<Integer> numDisksCB;
	protected JComboBox<Integer> numPegsCB;
	protected JLabel lblPeg1;
	protected JLabel lblPeg2;
	protected JLabel lblPeg3;
	protected JLabel lblPeg4;
	protected JLabel lblPeg5;
	private JLabel lblNewLabel;
	private JPanel panel;
	
	public Basic_MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Hanoi");
		setSize(new Dimension(1000, 600));
		setResizable(true);
		
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1000, 500));
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setLayout(new GridLayout(1, 5));
		
		panelPeg1 = new JPanel();
		panelPeg1.setBackground(Color.WHITE);
		mainPanel.add(panelPeg1);
		panelPeg1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 460, 200, 25);
		lblNewLabel.setIcon(new ImageIcon("/home/gorka/git/ProjectIS/ProyectoIS/img/9.png"));
		
		lblPeg1 = new JLabel("");
		lblPeg1.setBounds(0, 5, 200, 450);
		lblPeg1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPeg1.setIcon(new ImageIcon("/home/gorka/git/ProjectIS/ProyectoIS/img/peg.png"));

		panel = new JPanel();
		GridLayout gridLayout = new GridLayout(9, 1);
		panel.setLayout(gridLayout);
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED));
		panel.setBounds(0, 0, lblPeg1.getWidth(), lblPeg1.getHeight()-10);
		panel.setAlignmentY(300);
		panel.add(lblNewLabel );
				
		panelPeg1.add(panel);
		panelPeg1.add(lblPeg1);
		
		panelPeg2 = new JPanel();
		panelPeg2.setBackground(Color.WHITE);
		mainPanel.add(panelPeg2);
		
		lblPeg2 = new JLabel("");
		lblPeg2.setIcon(new ImageIcon("/home/gorka/git/ProjectIS/ProyectoIS/img/peg.png"));
		lblPeg2.setVerticalAlignment(SwingConstants.BOTTOM);
		panelPeg2.add(lblPeg2);

		panelPeg3 = new JPanel();
		panelPeg3.setBackground(Color.WHITE);
		mainPanel.add(panelPeg3);
		
		lblPeg3 = new JLabel("");
		lblPeg3.setIcon(new ImageIcon("/home/gorka/git/ProjectIS/ProyectoIS/img/peg.png"));
		lblPeg3.setVerticalAlignment(SwingConstants.BOTTOM);
		panelPeg3.add(lblPeg3);
		
		panelPeg4 = new JPanel();
		panelPeg4.setBackground(Color.WHITE);
		mainPanel.add(panelPeg4);
		
		lblPeg4 = new JLabel("");
		lblPeg4.setIcon(new ImageIcon("/home/gorka/git/ProjectIS/ProyectoIS/img/peg.png"));
		lblPeg4.setVerticalAlignment(SwingConstants.BOTTOM);
		panelPeg4.add(lblPeg4);
		
		panelPeg5 = new JPanel();
		panelPeg5.setBackground(Color.WHITE);
		mainPanel.add(panelPeg5);
		
		lblPeg5 = new JLabel("");
		lblPeg5.setIcon(new ImageIcon("/home/gorka/git/ProjectIS/ProyectoIS/img/peg.png"));
		lblPeg5.setVerticalAlignment(SwingConstants.BOTTOM);
		panelPeg5.add(lblPeg5);
		
		mainPanel.validate();
		mainPanel.repaint();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		
		
		
		//-------------------------------------------------------BOTTOM PANEL CREATION -------------------------------------------------------------------------------
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(1000, 35));
		bottomPanel.setBackground(Color.WHITE);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		solveButton = new JButton("Solve");
		bottomPanel.add(solveButton);
		
		createButton = new JButton("Create");
		bottomPanel.add(createButton);
		
		String [] algorithms = { "BreadthFS", "DepthFS"};
		algoCB = new JComboBox<String>(algorithms);
		bottomPanel.add(algoCB);
		
		Integer [] numDisks = {3,4,5,6,7,8,9};
		numDisksCB = new JComboBox<Integer>(numDisks);
		bottomPanel.add(numDisksCB);
		
		Integer [] numPegs = {3,4,5};
		numPegsCB = new JComboBox<Integer>(numPegs);
		bottomPanel.add(numPegsCB);
		
		validate();
//		bottomPanel.repaint();
		
	}
	
	public static void main(String[] args) {
		new Basic_MainWindow();
	}

}
