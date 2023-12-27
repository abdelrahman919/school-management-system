package com.abdelrahman.schoolmanagementsystem.config;

import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import com.abdelrahman.schoolmanagementsystem.repository.ExamRepo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ExamScoreMapDeserializer extends JsonDeserializer<Map<Exam, Integer>> {

    private final ExamRepo examRepo;

    @Override
    public Map<Exam, Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Map<Exam, Integer> examScoreMap = new HashMap<>();
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            try {
                String examIdAsString = jsonParser.getCurrentName();
                jsonParser.nextToken();
                Integer score = jsonParser.getIntValue();

                Long examId = Long.parseLong(examIdAsString); // Convert to Long explicitly

                Exam exam = examRepo.findById(examId).orElseThrow(EntityNotFoundException::new);
                examScoreMap.put(exam, score);
            } catch (NumberFormatException e) {
                // Handle the NumberFormatException if needed
                e.printStackTrace();
            }
        }
        return examScoreMap;
    }
}



