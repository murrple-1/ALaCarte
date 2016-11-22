import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

class RecipeBook {

	private static final String recipesTag = "recipes";
	
	private final List<Recipe> recipes = new ArrayList<>();

	public RecipeBook(Document doc) {
		Element recipesEle = (Element) doc.getElementsByTagName(recipesTag).item(0);
		NodeList recipeList = recipesEle.getElementsByTagName(Recipe.recipeTag);
		for(int i = 0; i < recipeList.getLength(); i++) {
			Element recipeEle = (Element) recipeList.item(i);
			Recipe recipe = new Recipe(recipeEle);
			recipes.add(recipe);
		}
	}
	
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public Document toXML() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.newDocument();
		
		Element recipesEle = document.createElement(recipesTag);
		document.appendChild(recipesEle);
		
		for(Recipe rec : recipes) {
			Element recipeEle = rec.toXML(document);
			recipesEle.appendChild(recipeEle);
		}
		
		return document;
	}
}
