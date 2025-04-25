package com.musicstrore.themusicstroreapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private String amount;
    private String code;
    private String symbol;
}
