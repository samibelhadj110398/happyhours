package com.reservation.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.reservation.model.Image;

@Entity
public class Hotel_Categorie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	 @OneToMany
	    private List<Image> image ;

    
    @ManyToOne
	 private Hotel hotel;
    @ManyToOne
	 private TypeChambre CategorieHotel;
    @OneToMany
    private List<Pension> pension ;
    
    
    @Column
	 private Integer nombre;

	public Hotel_Categorie(Long id, Hotel hotel, TypeChambre categorieHotel, Integer nombre) {
		super();
		this.id = id;
		
		this.nombre = nombre;
	}

	public Hotel_Categorie() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public TypeChambre getCategorieHotel() {
		return CategorieHotel;
	}

	public void setCategorieHotel(TypeChambre categorieHotel) {
		CategorieHotel = categorieHotel;
	}

	public List<Pension> getPension() {
		return pension;
	}

	public void setPension(List<Pension> pension) {
		this.pension = pension;
	}

	public Hotel_Categorie(Long id, Hotel hotel, com.reservation.model.hotel.TypeChambre categorieHotel,
			List<Pension> pension, Integer nombre) {
		super();
		this.id = id;
		this.hotel = hotel;
		CategorieHotel = categorieHotel;
		this.pension = pension;
		this.nombre = nombre;
	}

	

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

	public Hotel_Categorie(Long id, List<Image> image,
			Hotel hotel, com.reservation.model.hotel.TypeChambre categorieHotel, List<Pension> pension, Integer nombre) {
		super();
		this.id = id;
		this.image = image;
		this.hotel = hotel;
		CategorieHotel = categorieHotel;
		this.pension = pension;
		this.nombre = nombre;
	}
	
    
}
