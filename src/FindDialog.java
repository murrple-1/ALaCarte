import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class FindDialog extends JDialog {
	
	private static final long serialVersionUID = 7449122359330132804L;
	
	private int returnValue = JOptionPane.CANCEL_OPTION;
	
	private final RecipeBrowser recipeBrowser;
	
	private Collection<Recipe> searchResults;
	
	private JTextField searchField;
	
	private JCheckBox nameCheck;
	private JCheckBox descriptionCheck;
	private JCheckBox ingredientsCheck;
	private JCheckBox directionsCheck;
	private JCheckBox contributorCheck;
	private JCheckBox categoryCheck;
	private JCheckBox spicesCheck;
	private JCheckBox ratingCheck;
	private JCheckBox sourceCheck;
	
	FindDialog(RecipeBrowser owner) {
		super(owner, "Find", true);
		
		recipeBrowser = owner;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 300);
		
		setUpWindow();
	}
	
	private void searchRecipes() {
		String searchString = searchField.getText();
		if(searchString != null && !searchString.isEmpty()) {
			Pattern pattern = Pattern.compile(searchString);
			searchResults = new ArrayList<>();
			for(Recipe recipe : recipeBrowser.getRecipeBook().getRecipes()) {
				boolean addTo = false;
				if(nameCheck.isSelected()) {
					addTo = pattern.matcher(recipe.getName()).matches();
				}
				if(descriptionCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getDescription()).matches();
				}
				if(ingredientsCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getIngredients()).matches();
				}
				if(directionsCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getDirections()).matches();
				}
				if(contributorCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getContributor()).matches();
				}
				if(categoryCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getCategory()).matches();
				}
				if(spicesCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getSpices()).matches();
				}
				if(ratingCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getRating()).matches();
				}
				if(sourceCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getSource()).matches();
				}
				
				if(addTo) {
					searchResults.add(recipe);
				}
			}
		} else {
			searchResults = recipeBrowser.getRecipeBook().getRecipes();
		}
	}
	
	private void setUpWindow() {
		GridBagLayout layout = new GridBagLayout();

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(3, 3, 3, 3);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(layout);
		
		JLabel searchLabel = new JLabel("Search:");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(searchLabel, gridBagConstraints);
		panel.add(searchLabel);
		
		searchField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(searchField, gridBagConstraints);
		panel.add(searchField);
		
		JLabel searchWhereLabel = new JLabel("Search Fields:");
		searchWhereLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 2.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(searchWhereLabel, gridBagConstraints);
		panel.add(searchWhereLabel);
		
		nameCheck = new JCheckBox("Name");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(nameCheck, gridBagConstraints);
		panel.add(nameCheck);
		
		descriptionCheck = new JCheckBox("Description");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(descriptionCheck, gridBagConstraints);
		panel.add(descriptionCheck);
		
		ingredientsCheck = new JCheckBox("Ingredient");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ingredientsCheck, gridBagConstraints);
		panel.add(ingredientsCheck);
		
		directionsCheck = new JCheckBox("Directions");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(directionsCheck, gridBagConstraints);
		panel.add(directionsCheck);
		
		contributorCheck = new JCheckBox("Contributor");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(contributorCheck, gridBagConstraints);
		panel.add(contributorCheck);
		
		categoryCheck = new JCheckBox("Category");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(categoryCheck, gridBagConstraints);
		panel.add(categoryCheck);
		
		spicesCheck = new JCheckBox("Spices");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(spicesCheck, gridBagConstraints);
		panel.add(spicesCheck);
		
		ratingCheck = new JCheckBox("Rating");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ratingCheck, gridBagConstraints);
		panel.add(ratingCheck);
		
		sourceCheck = new JCheckBox("Source");
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(sourceCheck, gridBagConstraints);
		panel.add(sourceCheck);
		
		JButton okButton = new JButton("OK");
		ActionListener okL = new OKListener(this);
		okButton.addActionListener(okL);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
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
		gridBagConstraints.gridy = 7;
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
	
	public Iterable<Recipe> getSearchResults() {
		return searchResults;
	}
	
	private static class OKListener implements ActionListener {

		private final FindDialog parent;
		
		public OKListener(FindDialog parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.returnValue = JOptionPane.OK_OPTION;
			parent.searchRecipes();
			parent.setVisible(false);
		}
		
	}
	
	private static class CancelListener implements ActionListener {

		private final FindDialog parent;
		
		public CancelListener(FindDialog parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.returnValue = JOptionPane.CANCEL_OPTION;
			parent.setVisible(false);
		}
		
	}
}
