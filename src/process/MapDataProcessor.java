package process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class MapDataProcessor {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

      
        List<Location> locations = objectMapper.readValue(new File("D:\\Users\\Darshan Gadakh\\eclipse-workspace\\MapDataProcessor\\src\\resources\\location.json"),
                new TypeReference<List<Location>>() {});
        List<Metadata> metadataList = objectMapper.readValue(new File("D:\\Users\\Darshan Gadakh\\eclipse-workspace\\MapDataProcessor\\src\\resources\\metadata.json"),
                new TypeReference<List<Metadata>>() {});

        Map<String, Metadata> metadataMap = metadataList.stream()
                .collect(Collectors.toMap(m -> m.id, m -> m));

        List<MergedData> mergedDataList = new ArrayList<>();
        for (Location location : locations) {
            Metadata meta = metadataMap.get(location.id);
            mergedDataList.add(new MergedData(location, meta));
        }

        Map<String, Long> countByType = mergedDataList.stream()
                .filter(data -> data.type != null)
                .collect(Collectors.groupingBy(data -> data.type, Collectors.counting()));

        Map<String, Double> avgRatingByType = mergedDataList.stream()
                .filter(data -> data.type != null && data.rating != null)
                .collect(Collectors.groupingBy(
                        data -> data.type,
                        Collectors.averagingDouble(data -> data.rating)
                ));

        MergedData mostReviewed = mergedDataList.stream()
                .filter(data -> data.reviews != null)
                .max(Comparator.comparingInt(data -> data.reviews))
                .orElse(null);

//        System.out.println("Count of locations per type: " + countByType);
//        System.out.println("Average rating per type: " + avgRatingByType);
//        System.out.println("Most reviewed location: " + mostReviewed.id + " with " + mostReviewed.reviews + " reviews.");
        
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT); 

        System.out.println("Count of locations per type:");
        System.out.println(jsonMapper.writeValueAsString(countByType));
        System.out.println("===============================================");
        System.out.println("Average rating per type:");
        System.out.println(jsonMapper.writeValueAsString(avgRatingByType));
        System.out.println("===============================================");
        System.out.println("Most reviewed location:");
        System.out.println(jsonMapper.writeValueAsString(Map.of(
            "id", mostReviewed.id,
            "reviews", mostReviewed.reviews
        )));
    }
}
