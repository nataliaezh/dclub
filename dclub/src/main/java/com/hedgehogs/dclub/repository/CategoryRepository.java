package com.hedgehogs.dclub.repository;

import com.hedgehogs.dclub.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category,String> {

}
