package com.darrenlai.burgers.models;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
    @Size(min = 1, max = 200, message="Burger name cannot be null")
    private String burgerName;
	@NotNull
    @Size(min = 1, max = 200, message="Restaurant name cannot be null")
    private String restaurantName;
	@NotNull
    @Min(value=1, message="Rating must fall within 1 and 5")
	@Max(value=5, message="Rating must fall within 1 and 5")
    private Integer rating;
	@NotNull
    @Size(min = 1, max = 200, message="Notes cannot be null")
    private String notes;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Burger() {}
	public Burger(String burgerName, String restaurantName, int rating, String notes) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.notes = notes;
	}
	public String getBurgerName() {
		return burgerName;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}