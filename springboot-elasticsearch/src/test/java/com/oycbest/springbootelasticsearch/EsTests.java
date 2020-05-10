package com.oycbest.springbootelasticsearch;

import com.oycbest.springbootelasticsearch.es.ESBlog;
import com.oycbest.springbootelasticsearch.service.ESBlogSearchService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @Author: oyc
 * @Date: 2020-04-30 9:40
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTests {

	@Autowired
	private ESBlogSearchService ESBlogSearchService;

	@Test
	public void save() {
		ESBlogSearchService.save(new ESBlog(UUID.randomUUID().toString(),"name1","1","1","1","1"));
	}
	@Test
	public void getById(){
		ESBlogSearchService.getById("98c717e2-0e17-4887-86f6-e9cd347f97f7");
	}
	/*@Test
	public void getByName(){
		ESBlogSearchService.getByName("name1");
	}*/
	@Test
	public void delete(){
		ESBlogSearchService.delete("98c717e2-0e17-4887-86f6-e9cd347f97f7");
	}

}
