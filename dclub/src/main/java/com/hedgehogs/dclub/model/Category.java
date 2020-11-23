package com.hedgehogs.dclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

/**
 * @author natalya_ezhkova@mail.ru
 */


@NoArgsConstructor
@Data
@Document(indexName = "category")
public class Category {

	@Id
	private String id;
	private String categoria;
	private Integer catId;

	public Category(String id, String categoria, Integer catId) {
		super();
		this.id=id;
		this.categoria = categoria;
		this.catId = catId;
	}

	@Override
	public String toString() {
		return "Category{" +
			   "categoria='" + categoria + '\'' +
			   ", catId=" + catId +
			   '}';
	}
}
