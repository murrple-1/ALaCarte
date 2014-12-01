import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewRecipeDialog extends JDialog {

	private static final long serialVersionUID = -828462112352507900L;

	private int returnValue = JOptionPane.CANCEL_OPTION;
	private Recipe newRecipe = null;
	
	private JTextField nameField;
	private JTextField contributorField;
	private JTextField categoryField;
	private JTextField spicesField;
	private JTextField ratingField;
	private JTextField sourceField;
	private JTextArea descriptionField;
	private JTextArea ingredientsField;
	private JTextArea directionsField;
	
	public NewRecipeDialog(RecipeBrowser owner) {
		super(owner, "New Recipe", true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 300);
		
		setUpWindow();
	}
	
	public void createRecipe() {
		newRecipe = new Recipe();
		newRecipe.setName(nameField.getText());
		newRecipe.setDescription(descriptionField.getText());
		newRecipe.setIngredients(ingredientsField.getText());
		newRecipe.setDirections(directionsField.getText());
		newRecipe.setContributor(contributorField.getText());
		newRecipe.setCategory(categoryField.getText());
		newRecipe.setSpices(spicesField.getText());
		newRecipe.setRating(ratingField.getText());
		newRecipe.setSource(sourceField.getText());
	}
	
	private void setUpWindow() {
		GridBagLayout layout = new GridBagLayout();

		GridBagConstraints constra = new GridBagConstraints();
		constra.insets = new Insets(3, 3, 3, 3);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(layout);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		constra.gridx = 0;
		constra.gridy = 0;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(nameLabel, constra);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		constra.gridx = 1;
		constra.gridy = 0;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(nameField, constra);
		panel.add(nameField);
		
		JLabel contributorLabel = new JLabel("Contributor:");
		contributorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		constra.gridx = 0;
		constra.gridy = 1;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(contributorLabel, constra);
		panel.add(contributorLabel);
		
		contributorField = new JTextField();
		constra.gridx = 1;
		constra.gridy = 1;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(contributorField, constra);
		panel.add(contributorField);
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		constra.gridx = 0;
		constra.gridy = 2;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(categoryLabel, constra);
		panel.add(categoryLabel);
		
		categoryField = new JTextField();
		constra.gridx = 1;
		constra.gridy = 2;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(categoryField, constra);
		panel.add(categoryField);
		
		JLabel spicesLabel = new JLabel("Spices:");
		spicesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		constra.gridx = 0;
		constra.gridy = 3;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(spicesLabel, constra);
		panel.add(spicesLabel);
		
		spicesField = new JTextField();
		constra.gridx = 1;
		constra.gridy = 3;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(spicesField, constra);
		panel.add(spicesField);
		
		JLabel ratingLabel = new JLabel("Rating:");
		ratingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		constra.gridx = 0;
		constra.gridy = 4;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(ratingLabel, constra);
		panel.add(ratingLabel);
		
		ratingField = new JTextField();
		constra.gridx = 1;
		constra.gridy = 4;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(ratingField, constra);
		panel.add(ratingField);
		
		JLabel sourceLabel = new JLabel("Source:");
		sourceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		constra.gridx = 0;
		constra.gridy = 5;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(sourceLabel, constra);
		panel.add(sourceLabel);
		
		sourceField = new JTextField();
		constra.gridx = 1;
		constra.gridy = 5;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(sourceField, constra);
		panel.add(sourceField);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		constra.gridx = 0;
		constra.gridy = 6;
		constra.weightx = 2.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 2;
		constra.gridheight = 1;
		layout.setConstraints(descriptionLabel, constra);
		panel.add(descriptionLabel);
		
		descriptionField = new JTextArea();
		constra.gridx = 0;
		constra.gridy = 7;
		constra.weightx = 2.0;
		constra.weighty = 5.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.BOTH;
		constra.gridwidth = 2;
		constra.gridheight = 1;
		layout.setConstraints(descriptionField, constra);
		panel.add(descriptionField);
		
		JLabel ingredientsLabel = new JLabel("Ingredients:");
		ingredientsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		constra.gridx = 0;
		constra.gridy = 8;
		constra.weightx = 2.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 2;
		constra.gridheight = 1;
		layout.setConstraints(ingredientsLabel, constra);
		panel.add(ingredientsLabel);
		
		ingredientsField = new JTextArea();
		constra.gridx = 0;
		constra.gridy = 9;
		constra.weightx = 2.0;
		constra.weighty = 5.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.BOTH;
		constra.gridwidth = 2;
		constra.gridheight = 1;
		layout.setConstraints(ingredientsField, constra);
		panel.add(ingredientsField);
		
		JLabel directionsLabel = new JLabel("Directions:");
		directionsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		constra.gridx = 0;
		constra.gridy = 10;
		constra.weightx = 2.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.EAST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 2;
		constra.gridheight = 1;
		layout.setConstraints(directionsLabel, constra);
		panel.add(directionsLabel);
		
		directionsField = new JTextArea();
		constra.gridx = 0;
		constra.gridy = 11;
		constra.weightx = 2.0;
		constra.weighty = 5.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.BOTH;
		constra.gridwidth = 2;
		constra.gridheight = 1;
		layout.setConstraints(directionsField, constra);
		panel.add(directionsField);
		
		JButton okButton = new JButton("OK");
		ActionListener okL = new OKListener(this);
		okButton.addActionListener(okL);
		constra.gridx = 0;
		constra.gridy = 12;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.NONE;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(okButton, constra);
		panel.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		ActionListener cancelL = new CancelListener(this);
		cancelButton.addActionListener(cancelL);
		constra.gridx = 1;
		constra.gridy = 12;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.NONE;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(cancelButton, constra);
		panel.add(cancelButton);
	}
	
	public int getReturnValue() {
		return returnValue;
	}
	
	public Recipe getNewRecipe() {
		return newRecipe;
	}
	
	private static class OKListener implements ActionListener {

		private NewRecipeDialog parent;
		
		public OKListener(NewRecipeDialog parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			parent.returnValue = JOptionPane.OK_OPTION;
			parent.createRecipe();
			parent.setVisible(false);
		}
		
	}
	
	private static class CancelListener implements ActionListener {

		private NewRecipeDialog parent;
		
		public CancelListener(NewRecipeDialog parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.returnValue = JOptionPane.CANCEL_OPTION;
			parent.setVisible(false);
		}
		
	}
}
