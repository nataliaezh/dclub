package com.hedgehogs.dclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

/**
 * @author natalya_ezhkova@mail.ru
 */
@NoArgsConstructor
@Data
@Document(indexName = "product")
public class Product {
	@Id
	private String id;
	private Integer category_id;
	private String name;
	private String description;
	@Field(type = Keyword)
	private Integer price;
	private String picture;

	public Product(String id, Integer category_id, String name, String description, Integer price, String picture) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Product{" +
			   "category_id=" + category_id +
			   ", name='" + name + '\'' +
			   ", description='" + description + '\'' +
			   ", price=" + price +
			   ", picture='" + picture + '\'' +
			   '}';
	}
}
