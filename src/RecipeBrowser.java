
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class RecipeBrowser extends JFrame {

	private static final long serialVersionUID = -1791494236335454381L;
	
	private File recipeBookFile;
	private RecipeBook recipeBook;
	private JList<Recipe> recipeList;
	private DefaultListModel<Recipe> recipeListModel;
	private JTextField spicesField;
	private JTextField ratingField;
	private JTextField contributorField;
	private JTextField categoryField;
	private JTextField sourceField;
	private JRadioButton descriptionRadio;
	private JRadioButton ingredientsRadio;
	private JRadioButton directionsRadio;
	private JTextArea informationArea;

	public RecipeBrowser() {
		super("Recipe Browser");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(600, 600);

		setUpWindow();
	}

	public static void main(String args[]) {
    	RecipeBrowser frame = new RecipeBrowser();
        frame.setVisible(true);
    }
	
	private void openFile(File file) {
		if(file != null) {
			try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
				recipeBook = new RecipeBook(doc);
				recipeBookFile = file;
				loadRecipeBook();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Error parsing XML of file: " + file.getPath(), "Parse Error", JOptionPane.ERROR_MESSAGE);
				recipeBook = null;
				recipeBookFile = null;
			}
		}
	}
	
	private void saveFile(File file) {
		if(file != null && recipeBook != null) {
			try {
				Document doc = recipeBook.toXML();
	            Source source = new DOMSource(doc);
	            Result result = new StreamResult(file);
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.transform(source, result);
				recipeBookFile = file;
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Error parsing XML of file: " + file.getPath(), "Parse Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void loadRecipeBook() {
		recipeListModel.clear();
		if(recipeBook != null) {
			for(Recipe recipe : recipeBook.getRecipes()) {
				recipeListModel.addElement(recipe);
			}
		}
	}
	
	public RecipeBook getRecipeBook() {
		return recipeBook;
	}
	
	private void setUpWindow() {
		GridBagLayout layout = new GridBagLayout();

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(3, 3, 3, 3);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem openMenuItem = new JMenuItem("Open XML...");
		ActionListener openL = new OpenXMLListener(this);
		openMenuItem.addActionListener(openL);
		fileMenu.add(openMenuItem);
		
		JMenuItem newMenuItem = new JMenuItem("New Recipe...");
		ActionListener newL = new NewRecipeListener(this);
		newMenuItem.addActionListener(newL);
		fileMenu.add(newMenuItem);
		
		JMenuItem saveAsMenuItem = new JMenuItem("Save XML As...");
		ActionListener saveAsL = new SaveXMLAsListener(this);
		saveAsMenuItem.addActionListener(saveAsL);
		fileMenu.add(saveAsMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save XML");
		ActionListener saveL = new SaveXMLListener(this);
		saveMenuItem.addActionListener(saveL);
		fileMenu.add(saveMenuItem);
		
		JMenuItem findMenuItem = new JMenuItem("Find...");
		ActionListener findL = new FindListener(this);
		findMenuItem.addActionListener(findL);
		fileMenu.add(findMenuItem);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(layout);

		JLabel recipeListLabel = new JLabel("Recipe List:");
		recipeListLabel.setHorizontalAlignment(SwingConstants.LEFT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(recipeListLabel, gridBagConstraints);
		panel.add(recipeListLabel);

		recipeList = new JList<>();
		recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		recipeListModel = new DefaultListModel<>();
		recipeList.setModel(recipeListModel);
		ListSelectionListener recipeListL = new RecipeSelectionListener(this);
		recipeList.addListSelectionListener(recipeListL);
		JScrollPane scrollPane = new JScrollPane(recipeList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.1;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(scrollPane, gridBagConstraints);
		panel.add(scrollPane);

		JLabel spiceFieldLabel = new JLabel("Spices:");
		spiceFieldLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(spiceFieldLabel, gridBagConstraints);
		panel.add(spiceFieldLabel);

		spicesField = new JTextField("");
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(spicesField, gridBagConstraints);
		panel.add(spicesField);

		JLabel ratingFieldLabel = new JLabel("Rating:");
		ratingFieldLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ratingFieldLabel, gridBagConstraints);
		panel.add(ratingFieldLabel);

		ratingField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ratingField, gridBagConstraints);
		panel.add(ratingField);
		
		JLabel contributorFieldLabel = new JLabel("Contributor:");
		contributorFieldLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(contributorFieldLabel, gridBagConstraints);
		panel.add(contributorFieldLabel);
		
		contributorField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(contributorField, gridBagConstraints);
		panel.add(contributorField);
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(categoryLabel, gridBagConstraints);
		panel.add(categoryLabel);
		
		categoryField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(categoryField, gridBagConstraints);
		panel.add(categoryField);
		
		JLabel sourceLabel = new JLabel("Source:");
		sourceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(sourceLabel, gridBagConstraints);
		panel.add(sourceLabel);
		
		sourceField = new JTextField();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(sourceField, gridBagConstraints);
		panel.add(sourceField);

		descriptionRadio = new JRadioButton("Description");
		descriptionRadio.setSelected(true);
		ChangeListener descriptionChangeListener = new DescriptionChangeListener(this);
		descriptionRadio.addChangeListener(descriptionChangeListener);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(descriptionRadio, gridBagConstraints);
		panel.add(descriptionRadio);
		
		ingredientsRadio = new JRadioButton("Ingredients");
		ChangeListener ingredientChangeListener = new IngredientsChangeListener(this);
		ingredientsRadio.addChangeListener(ingredientChangeListener);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(ingredientsRadio, gridBagConstraints);
		panel.add(ingredientsRadio);
		
		directionsRadio = new JRadioButton("Directions");
		ChangeListener directionsChangeListener = new DirectionsChangeListener(this);
		directionsRadio.addChangeListener(directionsChangeListener);
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.weightx = 0.33;
		gridBagConstraints.weighty = 0.05;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(directionsRadio, gridBagConstraints);
		panel.add(directionsRadio);
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(descriptionRadio);
		bGroup.add(ingredientsRadio);
		bGroup.add(directionsRadio);
		
		informationArea = new JTextArea();
		informationArea.setLineWrap(true);
		informationArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(informationArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 8;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.5;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.gridheight = 1;
		layout.setConstraints(scrollPane, gridBagConstraints);
		panel.add(scrollPane);
	}
	
	private static class RecipeSelectionListener implements ListSelectionListener {

		private final RecipeBrowser parent;
		
		public RecipeSelectionListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				Recipe recipe = parent.recipeList.getSelectedValue();
				if(recipe != null) {
					parent.spicesField.setText(recipe.getSpices());
					parent.spicesField.setCaretPosition(0);
					parent.ratingField.setText(recipe.getRating());
					parent.ratingField.setCaretPosition(0);
					parent.contributorField.setText(recipe.getContributor());
					parent.contributorField.setCaretPosition(0);
					parent.categoryField.setText(recipe.getCategory());
					parent.categoryField.setCaretPosition(0);
					parent.sourceField.setText(recipe.getSource());
					parent.sourceField.setCaretPosition(0);
					if(parent.descriptionRadio.isSelected()) {
						parent.informationArea.setText(recipe.getDescription());
					} else if(parent.ingredientsRadio.isSelected()) {
						parent.informationArea.setText(recipe.getIngredients());
					} else if(parent.directionsRadio.isSelected()) {
						parent.informationArea.setText(recipe.getDirections());
					} else {
						parent.informationArea.setText("");
					}
					parent.informationArea.setCaretPosition(0);
				} else {
					parent.spicesField.setText("");
					parent.ratingField.setText("");
					parent.contributorField.setText("");
					parent.categoryField.setText("");
					parent.sourceField.setText("");
					parent.informationArea.setText("");
				}
			}
			
		}
		
	}
	
	private static class OpenXMLListener implements ActionListener {

		private final RecipeBrowser parent;
		
		public OpenXMLListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setMultiSelectionEnabled(false);
			int retVal = fileChooser.showOpenDialog(parent);
			if(retVal == JFileChooser.APPROVE_OPTION) {
				parent.recipeBookFile = fileChooser.getSelectedFile();
				parent.openFile(parent.recipeBookFile);
			}
		}
		
	}
	
	private static class NewRecipeListener implements ActionListener {

		private final RecipeBrowser parent;
		
		public NewRecipeListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(parent.getRecipeBook() != null) {
				NewRecipeDialog dialog = new NewRecipeDialog(parent);
				dialog.setVisible(true);
				if(dialog.getReturnValue() == JOptionPane.OK_OPTION) {
					Recipe newRecipe = dialog.getNewRecipe();
					parent.recipeBook.getRecipes().add(newRecipe);
					parent.recipeListModel.addElement(newRecipe);
				}
				dialog.dispose();
			} else {
				JOptionPane.showMessageDialog(parent, "Cannot create new recipe until recipe book has been loaded", "Cannot Create New Recipe", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	private static class SaveXMLAsListener implements ActionListener {

		private final RecipeBrowser parent;
		
		public SaveXMLAsListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(parent.getRecipeBook() != null) {
				JFileChooser fileChooser = new JFileChooser();
				int retVal = fileChooser.showSaveDialog(parent);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					parent.saveFile(file);
				}
			} else {
				JOptionPane.showMessageDialog(parent, "Cannot save until recipe book has been loaded", "Cannot Save", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	private static class SaveXMLListener implements ActionListener {

		private final RecipeBrowser parent;
		
		public SaveXMLListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(parent.getRecipeBook() != null) {
				if(parent.recipeBookFile == null) {
					JFileChooser fileChooser = new JFileChooser();
					int retVal = fileChooser.showSaveDialog(parent);
					if(retVal == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						parent.saveFile(file);
					}
				} else {
					parent.saveFile(parent.recipeBookFile);
				}
			} else {
				JOptionPane.showMessageDialog(parent, "Cannot save until recipe book has been loaded", "Cannot Save", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	private static class FindListener implements ActionListener {

		private final RecipeBrowser parent;
		
		public FindListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(parent.getRecipeBook() != null) {
				FindDialog dialog = new FindDialog(parent);
				dialog.setVisible(true);
				if(dialog.getReturnValue() == JOptionPane.OK_OPTION) {
					parent.recipeListModel.clear();
					for(Recipe recipe : dialog.getSearchResults()) {
						parent.recipeListModel.addElement(recipe);
					}
				}
				dialog.dispose();
			} else {
				JOptionPane.showMessageDialog(parent, "Cannot search until a recipe book has been loaded", "Cannot Search", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	private static class DescriptionChangeListener implements ChangeListener {

		private final RecipeBrowser parent;
		
		public DescriptionChangeListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(parent.descriptionRadio.isSelected()) {
				Recipe recipe = parent.recipeList.getSelectedValue();
				if(recipe != null) {
					parent.informationArea.setText(recipe.getDescription());
					parent.informationArea.setCaretPosition(0);
				}
			}
		}
		
	}
	
	private static class IngredientsChangeListener implements ChangeListener {

		private final RecipeBrowser parent;
		
		public IngredientsChangeListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(parent.ingredientsRadio.isSelected()) {
				Recipe recipe = parent.recipeList.getSelectedValue();
				if(recipe != null) {
					parent.informationArea.setText(recipe.getIngredients());
					parent.informationArea.setCaretPosition(0);
				}
			}
		}
		
	}
	
	private static class DirectionsChangeListener implements ChangeListener {

		private final RecipeBrowser parent;
		
		public DirectionsChangeListener(RecipeBrowser parent) {
			this.parent = parent;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(parent.directionsRadio.isSelected()) {
				Recipe recipe = parent.recipeList.getSelectedValue();
				if(recipe != null) {
					parent.informationArea.setText(recipe.getDirections());
					parent.informationArea.setCaretPosition(0);
				}
			}
		}
		
	}
}
