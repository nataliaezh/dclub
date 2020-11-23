package com.hedgehogs.dclub.service;

import com.hedgehogs.dclub.model.Category;
import com.hedgehogs.dclub.model.Product;
import com.hedgehogs.dclub.repository.CategoryRepository;
import com.hedgehogs.dclub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Service
public class DClubService {

	public DClubService() throws IOException, ParserConfigurationException { }

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@PostConstruct
	public void init() throws IOException, ParserConfigurationException, SAXException {
		NodeList nl = null;
		Document doc = null;
		URL url = new URL("http://frontend.tanuki.ru/feeds/raiden-delivery-club/");
		URLConnection uc = url.openConnection();
		InputStream is = uc.getInputStream();//создали поток
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.parse(is);//непосредственно парсинг
		String categoria = "";
		int catId = 0;
		Element element = (Element) doc.getElementsByTagName("categories").item(0);
		NodeList categoryNodeList = doc.getElementsByTagName("category");
		List<Category> categories = new ArrayList<>();
		for (int i = 0; i < categoryNodeList.getLength(); i++) {
			Element elementCaterory = (Element) categoryNodeList.item(i);
			categoria = element.getElementsByTagName("category").item(i).getChildNodes().item(0).getNodeValue();
			catId = Integer.parseInt(elementCaterory.getAttribute("id"));
			Category category = new Category();

				category.setCategoria(categoria);
				category.setCatId(catId);
				System.out.println("category == " + category);
				categoryRepository.save(category);
			}

		NodeList nl2 = doc.getElementsByTagName("product");
		int category_id = 0;
		String name = "";
		String description = "";
		int price = 0;
		String picture = "";

		for (int i = 0; i < nl2.getLength(); i++) {
			Element element2 = (Element) nl2.item(i);

			category_id = Integer.parseInt(element2.getElementsByTagName("category_id").item(0).getChildNodes().item(0).getNodeValue());
			name = element2.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
			description = element2.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
			price = Integer.parseInt(element2.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue());
			picture = element2.getElementsByTagName("picture").item(0).getChildNodes().item(0).getNodeValue();

			Product product = new Product();
				product.setCategory_id(category_id);
				product.setName(name);
				product.setDescription(description);
				product.setPrice(price);
				product.setPicture(picture);
				System.out.println("product == " + product);
				productRepository.save(product);
			}
		}
	}

