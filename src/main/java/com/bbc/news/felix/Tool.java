package com.bbc.news.felix;

import lombok.Data;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Tool {
    int id;
    String name;
}
