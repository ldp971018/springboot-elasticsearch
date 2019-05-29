package com.ldp.elasticsearch;

import com.ldp.elasticsearch.bean.User;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot12ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    //提交数据
    @Test
    public void contextLoads() throws IOException {
        User user = new User(2, "付建民", "991122", 20);
        Index index = new Index.Builder(user).index("person").type("user").build();
        jestClient.execute(index);
    }

    //检索数据
    @Test
    public void search() throws IOException {
        String jsonSearch="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"username\" : \"刘东平\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(jsonSearch).addIndex("person").addType("user").build();
        SearchResult result = jestClient.execute(search);
        System.out.println(result.getJsonObject().toString());

    }

}
