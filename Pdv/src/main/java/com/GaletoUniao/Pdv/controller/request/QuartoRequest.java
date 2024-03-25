package com.GaletoUniao.Pdv.controller.request;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuartoRequest {
    @NonNull
    private String tipoQuarto;
    @NonNull
    private double valorPernoite;
}
