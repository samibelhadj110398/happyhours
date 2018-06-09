package com.reservation.model;

public class SelectListItem {
public String value;
public String text;
public boolean checked;
public double prix;



public SelectListItem(String value, String text, boolean checked, double prix) {
	super();
	this.value = value;
	this.text = text;
	this.checked = checked;
	this.prix = prix;
}

public double getPrix() {
	return prix;
}

public void setPrix(double prix) {
	this.prix = prix;
}

public boolean isChecked() {
	return checked;
}

public void setChecked(boolean checked) {
	this.checked = checked;
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public SelectListItem(String value, String text) {
	super();
	this.value = value;
	this.text = text;
}

public SelectListItem(String value, String text, boolean checked) {
	super();
	this.value = value;
	this.text = text;
	this.checked = checked;
}


}

