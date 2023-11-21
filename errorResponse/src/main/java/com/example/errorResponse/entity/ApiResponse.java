package com.example.errorResponse.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class ApiResponse<T> {

    private final Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> results;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Metadata metadata;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    public ApiResponse(List<T> results) {
        this.status = new Status(2000, "0K");
        this.results = results;
        this.metadata = new Metadata(results.size());
    }

    public ApiResponse(int code, String message, Object data) {
        this.status = new Status(code, message);
        this.data = data;
    }
    @Getter
    @AllArgsConstructor
//    @NoArgsConstructor
//    @RequiredArgsConstructor
    private static class Status{
        private final int code;
        private final String message;
    }
    @Getter
    @AllArgsConstructor
    private static class Metadata {
        private int resultCount = 0;
    }
    @Getter
    @AllArgsConstructor
    private static class results {
        private String name;
        private int score;
    }

}
