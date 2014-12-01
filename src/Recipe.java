
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Recipe {
	public static final String recipeTag = "recipe";
	public static final String recipeNameTag = "name";
	public static final String contributorTag = "contributor";
	public static final String sourceTag = "source";
	public static final String categoryTag = "category";
	public static final String descriptionTag = "description";
	public static final String spicesTag = "spices";
	public static final String ratingTag = "rating";
	public static final String ingredientsTag = "ingredients";
	public static final String directionsTag = "directions";

	private String name;
	private String description;
	private String ingredients;
	private String directions;
	private String contributor;
	private String category;
	private String spices;
	private String rating;
	private String source;

	public Recipe() {
		
	}
	
	public Recipe(Element element) {
		setName(element.getElementsByTagName(recipeNameTag).item(0).getTextContent());
		setDescription(element.getElementsByTagName(descriptionTag).item(0).getTextContent());
		setIngredients(element.getElementsByTagName(ingredientsTag).item(0).getTextContent());
		setDirections(element.getElementsByTagName(directionsTag).item(0).getTextContent());
		setContributor(element.getElementsByTagName(contributorTag).item(0).getTextContent());
		setCategory(element.getElementsByTagName(categoryTag).item(0).getTextContent());
		setSpices(element.getElementsByTagName(spicesTag).item(0).getTextContent());
		setRating(element.getElementsByTagName(ratingTag).item(0).getTextContent());
		setSource(element.getElementsByTagName(sourceTag).item(0).getTextContent());
	}
	
	public String toString() {
		return getName();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSpices() {
		return spices;
	}

	public void setSpices(String spices) {
		this.spices = spices;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public Element toXML(Document doc) {
		Element recipeEle = doc.createElement(recipeTag);
		
		Element recipeNameEle = doc.createElement(recipeNameTag);
		recipeNameEle.appendChild(doc.createTextNode(name));
		recipeEle.appendChild(recipeNameEle);
		
		Element contributorEle = doc.createElement(contributorTag);
		contributorEle.appendChild(doc.createTextNode(contributor));
		recipeEle.appendChild(contributorEle);
		
		Element categoryEle = doc.createElement(categoryTag);
		categoryEle.appendChild(doc.createTextNode(category));
		recipeEle.appendChild(categoryEle);
		
		Element descriptionEle = doc.createElement(descriptionTag);
		descriptionEle.appendChild(doc.createTextNode(description));
		recipeEle.appendChild(descriptionEle);
		
		Element spicesEle = doc.createElement(spicesTag);
		spicesEle.appendChild(doc.createTextNode(spices));
		recipeEle.appendChild(spicesEle);
		
		Element sourceEle = doc.createElement(sourceTag);
		sourceEle.appendChild(doc.createTextNode(source));
		recipeEle.appendChild(sourceEle);
		
		Element ratingEle = doc.createElement(ratingTag);
		ratingEle.appendChild(doc.createTextNode(rating));
		recipeEle.appendChild(ratingEle);
		
		Element ingredientsEle = doc.createElement(ingredientsTag);
		ingredientsEle.appendChild(doc.createTextNode(ingredients));
		recipeEle.appendChild(ingredientsEle);
		
		Element directionEle = doc.createElement(directionsTag);
		directionEle.appendChild(doc.createTextNode(directions));
		recipeEle.appendChild(directionEle);
		
		return recipeEle;
	}
}
