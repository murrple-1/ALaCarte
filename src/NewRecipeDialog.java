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
	
	private void createRecipe() {
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

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(3, 3, 3, 3);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(layout);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(nameLabel, gridBagConstraints);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(nameField, gridBagConstraints);
		panel.add(nameField);
		
		JLabel contributorLabel = new JLabel("Contributor:");
		contributorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(contributorLabel, gridBagConstraints);
		panel.add(contributorLabel);
		
		contributorField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(contributorField, gridBagConstraints);
		panel.add(contributorField);
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(categoryLabel, gridBagConstraints);
		panel.add(categoryLabel);
		
		categoryField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(categoryField, gridBagConstraints);
		panel.add(categoryField);
		
		JLabel spicesLabel = new JLabel("Spices:");
		spicesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(spicesLabel, gridBagConstraints);
		panel.add(spicesLabel);
		
		spicesField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(spicesField, gridBagConstraints);
		panel.add(spicesField);
		
		JLabel ratingLabel = new JLabel("Rating:");
		ratingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ratingLabel, gridBagConstraints);
		panel.add(ratingLabel);
		
		ratingField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ratingField, gridBagConstraints);
		panel.add(ratingField);
		
		JLabel sourceLabel = new JLabel("Source:");
		sourceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(sourceLabel, gridBagConstraints);
		panel.add(sourceLabel);
		
		sourceField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(sourceField, gridBagConstraints);
		panel.add(sourceField);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.weightx = 2.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(descriptionLabel, gridBagConstraints);
		panel.add(descriptionLabel);
		
		descriptionField = new JTextArea();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.weightx = 2.0;
		gridBagConstraints.weighty = 5.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(descriptionField, gridBagConstraints);
		panel.add(descriptionField);
		
		JLabel ingredientsLabel = new JLabel("Ingredients:");
		ingredientsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.weightx = 2.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ingredientsLabel, gridBagConstraints);
		panel.add(ingredientsLabel);
		
		ingredientsField = new JTextArea();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 9;
		gridBagConstraints.weightx = 2.0;
		gridBagConstraints.weighty = 5.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ingredientsField, gridBagConstraints);
		panel.add(ingredientsField);
		
		JLabel directionsLabel = new JLabel("Directions:");
		directionsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 10;
		gridBagConstraints.weightx = 2.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(directionsLabel, gridBagConstraints);
		panel.add(directionsLabel);
		
		directionsField = new JTextArea();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 11;
		gridBagConstraints.weightx = 2.0;
		gridBagConstraints.weighty = 5.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(directionsField, gridBagConstraints);
		panel.add(directionsField);
		
		JButton okButton = new JButton("OK");
		ActionListener okL = new OKListener(this);
		okButton.addActionListener(okL);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 12;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(okButton, gridBagConstraints);
		panel.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		ActionListener cancelL = new CancelListener(this);
		cancelButton.addActionListener(cancelL);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 12;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(cancelButton, gridBagConstraints);
		panel.add(cancelButton);
	}
	
	public int getReturnValue() {
		return returnValue;
	}
	
	public Recipe getNewRecipe() {
		return newRecipe;
	}
	
	private static class OKListener implements ActionListener {

		private final NewRecipeDialog parent;
		
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

		private final NewRecipeDialog parent;
		
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
