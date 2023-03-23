import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.filechooser.*;
import javax.swing.*;
import java.security.MessageDigest;

public class Interface{
		
	public static String SHA1(String text) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] hash = digest.digest(text.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
	
	public static String MD5(String text) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(text.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
	
	public static String FileSHA1(String fileName) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            FileInputStream inputStream = new FileInputStream(fileName);
            byte[] bytes = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(bytes)) != -1) {
                digest.update(bytes, 0, bytesRead);
            }

            byte[] hash = digest.digest();
            StringBuilder hexString = new StringBuilder();

            for (byte aHash : hash) {
                String hex = Integer.toHexString(0xff & aHash);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            inputStream.close();
            return hexString.toString();
        } catch (Exception e) {
        	return "Erreur de calcul de Hash";
        }
	}
	
	public static String FileMD5(String fileName) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            FileInputStream inputStream = new FileInputStream(fileName);
            byte[] bytes = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(bytes)) != -1) {
                digest.update(bytes, 0, bytesRead);
            }

            byte[] hash = digest.digest();
            StringBuilder hexString = new StringBuilder();

            for (byte aHash : hash) {
                String hex = Integer.toHexString(0xff & aHash);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            inputStream.close();
            return hexString.toString();
        } catch (Exception e) {
        	return "Erreur de calcul de Hash";
        }
	}
	
	
	
	public static void main(String[] args) {
		JFrame Interface = new JFrame();
		Interface.setTitle("Test d'intégrité");
		Interface.setSize(600,610);
		Interface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Panel1 = new JPanel(), Panel2 = new JPanel(), Panel3 = new JPanel(), Panel4 = new JPanel(), Panel5 = new JPanel(), Panel6 = new JPanel();
		JPanel Panel1_1 = new JPanel(), Panel1_2 = new JPanel(), Panel1_1_1 = new JPanel(), Panel1_1_2 = new JPanel(), Panel1_1_3 = new JPanel(), Panel1_2_1 = new JPanel(),Panel1_2_2 = new JPanel(), Panel1_2_3 = new JPanel();
		JPanel Panel2_1 = new JPanel(), Panel2_2 = new JPanel(), Panel2_1_1 = new JPanel(), Panel2_1_2 = new JPanel(), Panel2_1_3 = new JPanel(), Panel2_2_1 = new JPanel(),Panel2_2_2 = new JPanel(), Panel2_2_3 = new JPanel();
		
		Panel1.setPreferredSize(new Dimension(600,250));
		Panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"Message"));
		
		Panel2.setPreferredSize(new Dimension(600,250));
		Panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"Message à vérifier"));
		
		Panel3.setPreferredSize(new Dimension(600,100));
		
		Panel4.setPreferredSize(new Dimension(300,50));
		Panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"Résultat"));
		
		Panel5.setPreferredSize(new Dimension(150,50));
		Panel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"Hash"));
		
		Panel6.setPreferredSize(new Dimension(100,100));
		Panel6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2),"Verification"));
		
		//Panel Hash
		String[] fonctions = {"SHA-1","MD5"};
		JComboBox<String> fonction = new JComboBox<>(fonctions);
	    Panel5.add(fonction, BorderLayout.CENTER);
		
	    // Bouttons
	    JButton Generer1_1 = new JButton("Generer"),Generer1_2 = new JButton("Generer"), Generer2_1 = new JButton("Generer"), Generer2_2 = new JButton("Generer");
	    JButton Copier1 = new JButton("Copier"), Copier2 = new JButton("Copier");
		JButton Verifie1 = new JButton("Texte"), Verifie2 = new JButton("Fichier");
		JButton Open1 = new JButton("open"), Open2 = new JButton("open");
		
		//Texte
		
		JTextField Msg1 = new JTextField(45), Msg2 = new JTextField(45);
		
		// Label
		
		JLabel Texte1 = new JLabel("Texte 1 : "), Texte2 = new JLabel("Texte 2 : "), Result = new JLabel("Entrer les deux messages");
		JLabel FileLabel1 = new JLabel("Fichier 1 : "), FileLabel2 = new JLabel("Fichier 2 : ");
		JLabel TexteHash1_1 = new JLabel("Hash 1 : "), TexteHash2_1 = new JLabel("Hash 2 : "),TexteHash1_2 = new JLabel("Hash 1 : "), TexteHash2_2 = new JLabel("Hash 2 : ");
		JLabel Hash1_1 = new JLabel("Inserer un texte"), Hash1_2 = new JLabel("Sélectionner un fichier"), Hash2_1 = new JLabel("Inserer un texte"), Hash2_2 = new JLabel("Sélectionner un fichier");
		JLabel File1Path = new JLabel("Aucun fichier n'est selectionné"), File2Path = new JLabel("Aucun fichier n'est selectionné");
		
		Panel1_1.setBorder(BorderFactory.createTitledBorder("Texte 1 "));
		Panel1_1.setPreferredSize(new Dimension(600,100));
		Panel1_1_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel1_1_1.add(Texte1);
		Panel1_1_1.add(Msg1);
		Panel1_1_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel1_1_2.add(TexteHash1_1);
		Panel1_1_2.add(Hash1_1);
		Panel1_1_3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Panel1_1_3.add(Generer1_1);
		Panel1_1.setLayout(new BorderLayout());
		Panel1_1_1.setPreferredSize(new Dimension(600,25));
		Panel1_1_2.setPreferredSize(new Dimension(600,25));
		Panel1_1_3.setPreferredSize(new Dimension(600,30));
		Panel1_1.add(Panel1_1_1, BorderLayout.NORTH);
		Panel1_1.add(Panel1_1_2, BorderLayout.CENTER);
		Panel1_1.add(Panel1_1_3, BorderLayout.SOUTH);
		
		
		Panel1_2.setBorder(BorderFactory.createTitledBorder("Fichier 1"));
		Panel1_2.setPreferredSize(new Dimension(600,125));
		Panel1_2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel1_2_1.add(FileLabel1);
		Panel1_2_1.add(Open1);
		Panel1_2_1.add(File1Path);
		Panel1_2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel1_2_2.add(TexteHash1_2);
		Panel1_2_2.add(Hash1_2);
		Panel1_2_3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Panel1_2_3.add(Generer1_2);
		Panel1_2_1.setPreferredSize(new Dimension(590,35));
		Panel1_2_2.setPreferredSize(new Dimension(590,25));
		Panel1_2_3.setPreferredSize(new Dimension(590,35));
		Panel1_2.add(Panel1_2_1, BorderLayout.NORTH);
		Panel1_2.add(Panel1_2_2, BorderLayout.CENTER);
		Panel1_2.add(Panel1_2_3, BorderLayout.SOUTH);
		
		Panel1.setLayout(new BorderLayout());
		Panel1.add(Panel1_1, BorderLayout.NORTH);
		Panel1.add(Panel1_2, BorderLayout.SOUTH);
		
		Panel2_1.setBorder(BorderFactory.createTitledBorder("Texte 2 "));
		Panel2_1.setPreferredSize(new Dimension(600,100));
		Panel2_1_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel2_1_1.add(Texte2);
		Panel2_1_1.add(Msg2);
		Panel2_1_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel2_1_2.add(TexteHash2_1);
		Panel2_1_2.add(Hash2_1);
		Panel2_1_3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Panel2_1_3.add(Copier1);
		Panel2_1_3.add(Generer2_1);
		Panel2_1.setLayout(new BorderLayout());
		Panel2_1_1.setPreferredSize(new Dimension(600,25));
		Panel2_1_2.setPreferredSize(new Dimension(600,25));
		Panel2_1_3.setPreferredSize(new Dimension(600,30));
		Panel2_1.add(Panel2_1_1, BorderLayout.NORTH);
		Panel2_1.add(Panel2_1_2, BorderLayout.CENTER);
		Panel2_1.add(Panel2_1_3, BorderLayout.SOUTH);
		
		
		Panel2_2.setBorder(BorderFactory.createTitledBorder("Fichier 2"));
		Panel2_2.setPreferredSize(new Dimension(600,125));
		Panel2_2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel2_2_1.add(FileLabel2);
		Panel2_2_1.add(Open2);
		Panel2_2_1.add(File2Path);
		Panel2_2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		Panel2_2_2.add(TexteHash2_2);
		Panel2_2_2.add(Hash2_2);
		Panel2_2_3.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Panel2_2_3.add(Copier2);
		Panel2_2_3.add(Generer2_2);
		Panel2_2_1.setPreferredSize(new Dimension(590,35));
		Panel2_2_2.setPreferredSize(new Dimension(590,25));
		Panel2_2_3.setPreferredSize(new Dimension(590,35));
		Panel2_2.add(Panel2_2_1, BorderLayout.NORTH);
		Panel2_2.add(Panel2_2_2, BorderLayout.CENTER);
		Panel2_2.add(Panel2_2_3, BorderLayout.SOUTH);
		
		Panel2.setLayout(new BorderLayout());
		Panel2.add(Panel2_1, BorderLayout.NORTH);
		Panel2.add(Panel2_2, BorderLayout.SOUTH);
		
		
		Panel4.add(Result, BorderLayout.CENTER);
		
		Panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
		Panel6.add(Verifie1);
		Panel6.add(Verifie2);
		Panel3.setLayout(new BorderLayout());
		Panel3.add(Panel4,BorderLayout.WEST);
		Panel3.add(Panel6,BorderLayout.CENTER);
		Panel3.add(Panel5,BorderLayout.EAST);
		
		//Gestion des cliques
		
		Verifie1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String message1 = Msg1.getText(), message2 = Msg2.getText();
				if (fonction.getSelectedItem().toString().equalsIgnoreCase("SHA-1")) {
					try {
						String hash1 = SHA1(message1);
						String hash2 = SHA1(message2);
						
						if (hash1.equalsIgnoreCase(hash2)) {
							Result.setText("L'intégrité est verifié");
						}
						else {
							Result.setText("l'intégrité n'est pas verifié");
						}
						
					} catch (Exception e) {
						Result.setText("Entrer les deux messages");
					}
				}
				else {
					try {
						String hash1 = MD5(message1);
						String hash2 = MD5(message2);
						
						if (hash1.equalsIgnoreCase(hash2)) {
							Result.setText("L'intégrité est verifié");
						}
						else {
							Result.setText("l'intégrité n'est pas verifié");
						}
						
					} catch (Exception e) {
						Result.setText("Entrer les deux messages");
					}
				}
			}
		});
		
		Verifie2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String path1 = File1Path.getText(), path2 = File2Path.getText();
				if (fonction.getSelectedItem().toString().equalsIgnoreCase("SHA-1")) {
					try {
						String hash1 = FileSHA1(path1);
						String hash2 = FileSHA1(path2);
						
						if (hash1.equalsIgnoreCase(hash2)) {
							Result.setText("L'intégrité est verifié");
						}
						else {
							Result.setText("l'intégrité n'est pas verifié");
						}
						
					} catch (Exception e) {
						Result.setText("Entrer les deux messages");
					}
				}
				else {
					try {
						String hash1 = FileMD5(path1);
						String hash2 = FileMD5(path2);
						
						if (hash1.equalsIgnoreCase(hash2)) {
							Result.setText("L'intégrité est verifié");
						}
						else {
							Result.setText("l'intégrité n'est pas verifié");
						}
						
					} catch (Exception e) {
						Result.setText("Entrer les deux messages");
					}
				}
			}
		});
		
		Copier1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				Msg2.setText(Msg1.getText());
			}
		});
		
		Copier2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				File2Path.setText(File1Path.getText());
			}
		});
		
		Generer1_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String message = Msg1.getText();
				if (fonction.getSelectedItem().toString().equalsIgnoreCase("SHA-1")) {
					try {
						Hash1_1.setText(SHA1(message));
					} catch (Exception e) {
					}
				}
				else {
					try {
						Hash1_1.setText(MD5(message));
					} catch (Exception e) {
					}
				}
			}
		});
		
		Generer1_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String path = File1Path.getText();
				if (fonction.getSelectedItem().toString().equalsIgnoreCase("SHA-1")) {
					try {
						Hash1_2.setText(FileSHA1(path));
					} catch (Exception e) {
					}
				}
				else {
					try {
						Hash1_2.setText(FileMD5(path));
					} catch (Exception e) {
					}
				}
			}
		});
		
		Generer2_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String message = Msg2.getText();
				if (fonction.getSelectedItem().toString().equalsIgnoreCase("SHA-1")) {
					try {
						Hash2_1.setText(SHA1(message));
					} catch (Exception e) {
					}
				}
				else {
					try {
						Hash2_1.setText(MD5(message));
					} catch (Exception e) {
					}
				}
			}
		});
		
		Generer2_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String path = File2Path.getText();
				if (fonction.getSelectedItem().toString().equalsIgnoreCase("SHA-1")) {
					try {
						Hash2_2.setText(FileSHA1(path));
					} catch (Exception e) {
					}
				}
				else {
					try {
						Hash2_2.setText(FileMD5(path));
					} catch (Exception e) {
					}
				}
			}
		});
		
		Open1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				JFileChooser J = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int r = J.showSaveDialog(null);
	            if (r == JFileChooser.APPROVE_OPTION){
	                File1Path.setText(J.getSelectedFile().getAbsolutePath());
	            }
	            else
	                File1Path.setText("Aucun fichier n'est selectionné");
			}
		});
			
		Open2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				JFileChooser J = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int r = J.showSaveDialog(null);
	            if (r == JFileChooser.APPROVE_OPTION){
	                File2Path.setText(J.getSelectedFile().getAbsolutePath());
	            }
	            else
	                File2Path.setText("Aucun fichier n'est selectionné");
			}
		});
		
		Interface.setLayout(new BorderLayout());
		Interface.add(Panel1, BorderLayout.NORTH);
		Interface.add(Panel2, BorderLayout.CENTER);
		Interface.add(Panel3, BorderLayout.SOUTH);
			
        Interface.setLocationRelativeTo(null);
        Interface.setVisible(true);
		
		
	}

}
