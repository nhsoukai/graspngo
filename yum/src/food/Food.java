package food;

public class Food {
	
	private String id;
	private String type;
	private String name;
	private String price;
	private boolean selected;
	public Food(String id, String name, String type,  String price){
		this.setId(id);
		this.setType(type);
		this.setName(name);
		this.setPrice(price);
	}
	
	 public boolean isSelected() {
	        
			return selected;
	    }

	    public void setSelected(boolean selected) {
	        this.selected = selected;
	    }
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}


}
