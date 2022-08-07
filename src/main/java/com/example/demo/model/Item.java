package com.example.demo.model;

public class Item {
	String Image;
    String Title;
    String Price;
    int Tag;

    public int getTag() {
		return Tag;
	}

	public void setTag(int tag) {
		Tag = tag;
	}

	public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}