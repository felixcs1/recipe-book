package com.bbc.news.felix;

import lombok.Data;
import lombok.Builder;

@Builder
public @Data class Tool {

    int id;
    String name;
}
