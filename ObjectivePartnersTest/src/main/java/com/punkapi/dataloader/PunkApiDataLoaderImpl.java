package com.punkapi.dataloader;

import com.punkapi.repository.JpaBeerRepository;
import com.punkapi.repository.model.Beer;
import com.punkapi.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by Puja on 11/04/20.
 */
@Repository
public class PunkApiDataLoaderImpl implements  IPunkApiDataLoader {

    RestTemplate restTemplate=new RestTemplate();

    @Autowired
    JpaBeerRepository beerRepository;

    @PostConstruct
    @Override
    public void loadData() {

        if(beerRepository.count()!=0)
            return;
        int start=1;
        int total=Integer.MAX_VALUE;


        while(start<=total)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            String URL= Constant.URL+ start + "&per_page=80";

            ResponseEntity<Beer[]> response = restTemplate.exchange(URL, HttpMethod.GET, entity, Beer[].class);
            if(response.getBody().length==0)
                break;
            start++;
           // System.out.println(response.getBody());
            for (Beer beers : response.getBody())
                beerRepository.save(beers);
        }

      }
}
