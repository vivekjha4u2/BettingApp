package com.yunt.BettingService.daman;

import com.opencsv.CSVWriter;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
public class DamanController {

//     RestTemplate restTemplate = new RestTemplate();

//    @GetMapping("/fetchDamanData")
//    public ResponseEntity<String> fetchRecords(){
//        int pageNo = 1;
//        ResponseEntity<String> response = null;
////        while(pageNo++ < 3) {
//
//            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//            map.add("typeId", 1);
//            map.add("pageNo", pageNo);
//            map.add("language", "en");
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
//            String url = "https://colorlottery.com/api/webapi/GetNoaverageEmerdList";
//            response = restTemplate.postForEntity(url, requestEntity, String.class);
////        }
//
//        return response;
//    }

    public static void main(String[] args) throws IOException {

        int pageNo = 1;
        try (CSVWriter writer = new CSVWriter(new FileWriter("past_data.csv"))) {
            while(pageNo < 100) {
                RestTemplate restTemplate = new RestTemplate();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);

                MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
                body.add("typeId", 1);
                body.add("pageNo", pageNo);
                body.add("language", "en");
                String url = "https://colorlottery.com/api/webapi/GetNoaverageEmerdList";
                HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
                ResponseEntity<DamanResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, DamanResponse.class);
                Game ch = response.getBody().getData().getGameslist().get(0);

                    List<Game> gamesList = response.getBody().getData().getGameslist();
                    for (Game game : gamesList) {
//                        String[] data = {game.getIssueNumber().substring(8), Integer.parseInt(game.getNumber()) < 5 ? "small" : "big"};
                        String[] data = { Integer.parseInt(game.getNumber()) < 5 ? "small" : "big"};
                        writer.writeNext(data);
                    }
                pageNo++;
                }

            }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
