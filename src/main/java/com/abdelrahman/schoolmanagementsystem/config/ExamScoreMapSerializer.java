package com.abdelrahman.schoolmanagementsystem.config;

import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Map;

public class ExamScoreMapSerializer extends JsonSerializer<Map<Exam, Integer>> {

    @Override
    public void serialize(Map<Exam, Integer> examScoreMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        for (Map.Entry<Exam, Integer> entry : examScoreMap.entrySet()) {
            Exam exam = entry.getKey();
            Integer score = entry.getValue();

            jsonGenerator.writeFieldName(exam.getId().toString());
            jsonGenerator.writeNumber(score);
        }

        jsonGenerator.writeEndObject();
    }
}
