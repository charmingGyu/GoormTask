package com.example.errorResponse.entity;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class ApiResponse<T> {

    private final Status status;

    private List<T> results;

    private Metadata metadata;

    public ApiResponse(List<T> results) {
        this.status = new Status(2000, "0K");
        this.results = results;
        this.metadata = new Metadata(results.size());
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
