package com.bbc.news.felix;
import lombok.Data;
import lombok.Builder;

@Builder
public @Data class Food {

    int id;
    String name;
    boolean isLiquid;
    String units;
    int quantity;
}
