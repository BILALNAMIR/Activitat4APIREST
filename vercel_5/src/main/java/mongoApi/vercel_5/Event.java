package mongoApi.vercel_5;

import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Event {

	   	private ObjectId id;
	    private String title;
	    private String category;
	    private int price;
	    private Date eventDate;
	    private String location;
	    private boolean available;

	    public Event() {
	    	
	    }
	    public Event(String title, String category, int price, Date eventDate, String location, boolean available) {
	        this.title = title;
	        this.category = category;
	        this.price = price;
	        this.eventDate = eventDate;
	        this.location = location;
	        this.available = available;
	    }

	    public ObjectId getId()
	    { 
	    	return id; 
	    }
	    public void setId(ObjectId id) { 
	    	this.id = id; 
	    	}

	    public String getTitle() {
	    	return title; 
	    	}
	    public void setTitle(String title) {
	    	this.title = title; 
	    	}

	    public String getCategory() { 
	    	return category; 
	    	}
	    public void setCategory(String category) { 
	    	this.category = category;

	    }

	    public int getPrice() { 
	    	return price; 
	    	}
	    public void setPrice(int price) {
	    	this.price = price;
	    	}

	    public Date getEventDate() {
	    	return eventDate; 
	    	}
	    public void setEventDate(Date eventDate) {
	    	this.eventDate = eventDate;
	    	}

	    public String getLocation() {
	    	return location;
	    	}
	    public void setLocation(String location) {
	    	this.location = location; 
	    	}

	    public boolean isAvailable() { 
	    	return available; }
	    public void setAvailable(boolean available) { 
	    	this.available = available; 
	    	}

	    
	    public Document toDocument() {
	        Document doc = new Document();
	        doc.append("title", title);
	        doc.append("category", category);
	        doc.append("price", price);
	        doc.append("eventDate", eventDate);
	        doc.append("location", location);
	        doc.append("available", available);
	        return doc;
	    }
}
