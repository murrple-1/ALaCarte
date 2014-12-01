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

public class FindDialog extends JDialog {
	
	private static final long serialVersionUID = 7449122359330132804L;
	
	private int returnValue = JOptionPane.CANCEL_OPTION;
	
	private RecipeBrowser recipeBrowser;
	
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
	
	public FindDialog(RecipeBrowser owner) {
		super(owner, "Find", true);
		
		recipeBrowser = owner;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 300);
		
		setUpWindow();
	}
	
	public void searchRecipes() {
		String searchString = searchField.getText();
		if(searchString != null && !searchString.isEmpty()) {
			Pattern pattern = Pattern.compile(searchString);
			searchResults = new ArrayList<Recipe>();
			for(Recipe recipe : recipeBrowser.getRecipeBook().getRecipes()) {
				boolean addTo = false;
				if(nameCheck.isSelected()) {
					addTo |= pattern.matcher(recipe.getName()).matches();
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

		GridBagConstraints constra = new GridBagConstraints();
		constra.insets = new Insets(3, 3, 3, 3);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(layout);
		
		JLabel searchLabel = new JLabel("Search:");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		constra.gridx = 0;
		constra.gridy = 0;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(searchLabel, constra);
		panel.add(searchLabel);
		
		searchField = new JTextField();
		constra.gridx = 1;
		constra.gridy = 0;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(searchField, constra);
		panel.add(searchField);
		
		JLabel searchWhereLabel = new JLabel("Search Fields:");
		searchWhereLabel.setHorizontalAlignment(SwingConstants.LEFT);
		constra.gridx = 0;
		constra.gridy = 1;
		constra.weightx = 2.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.WEST;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 2;
		constra.gridheight = 1;
		layout.setConstraints(searchWhereLabel, constra);
		panel.add(searchWhereLabel);
		
		nameCheck = new JCheckBox("Name");
		constra.gridx = 0;
		constra.gridy = 2;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(nameCheck, constra);
		panel.add(nameCheck);
		
		descriptionCheck = new JCheckBox("Description");
		constra.gridx = 1;
		constra.gridy = 2;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(descriptionCheck, constra);
		panel.add(descriptionCheck);
		
		ingredientsCheck = new JCheckBox("Ingredient");
		constra.gridx = 0;
		constra.gridy = 3;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(ingredientsCheck, constra);
		panel.add(ingredientsCheck);
		
		directionsCheck = new JCheckBox("Directions");
		constra.gridx = 1;
		constra.gridy = 3;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(directionsCheck, constra);
		panel.add(directionsCheck);
		
		contributorCheck = new JCheckBox("Contributor");
		constra.gridx = 0;
		constra.gridy = 4;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(contributorCheck, constra);
		panel.add(contributorCheck);
		
		categoryCheck = new JCheckBox("Category");
		constra.gridx = 1;
		constra.gridy = 4;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(categoryCheck, constra);
		panel.add(categoryCheck);
		
		spicesCheck = new JCheckBox("Spices");
		constra.gridx = 0;
		constra.gridy = 5;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(spicesCheck, constra);
		panel.add(spicesCheck);
		
		ratingCheck = new JCheckBox("Rating");
		constra.gridx = 1;
		constra.gridy = 5;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(ratingCheck, constra);
		panel.add(ratingCheck);
		
		sourceCheck = new JCheckBox("Source");
		constra.gridx = 0;
		constra.gridy = 6;
		constra.weightx = 1.0;
		constra.weighty = 1.0;
		constra.anchor = GridBagConstraints.CENTER;
		constra.fill = GridBagConstraints.HORIZONTAL;
		constra.gridwidth = 1;
		constra.gridheight = 1;
		layout.setConstraints(sourceCheck, constra);
		panel.add(sourceCheck);
		
		JButton okButton = new JButton("OK");
		ActionListener okL = new OKListener(this);
		okButton.addActionListener(okL);
		constra.gridx = 0;
		constra.gridy = 7;
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
		constra.gridy = 7;
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
	
	public Iterable<Recipe> getSearchResults() {
		return searchResults;
	}
	
	private static class OKListener implements ActionListener {

		private FindDialog parent;
		
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

		private FindDialog parent;
		
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
