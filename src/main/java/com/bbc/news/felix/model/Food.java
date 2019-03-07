package com.bbc.news.felix.model;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Food {
    int id;
    String name;
    boolean isLiquid;
    String units;
    int quantity;
}
