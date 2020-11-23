package com.hedgehogs.dclub.repository;

import com.hedgehogs.dclub.model.Product;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,String> {

	List<Product> findByPrice(String price);

	@Query("{\"bool\": {\"must\": [{\"match\": {\"price\": \"?0\"}}]}}")
	List<Product> findByPriceUsingCustomQuery(String price);

	@Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"price\": \"?0\" }}}}")
	List<Product> findByFilteredPriceQuery(String price);




}
