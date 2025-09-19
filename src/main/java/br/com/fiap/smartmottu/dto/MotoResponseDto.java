package br.com.fiap.smartmottu.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MotoResponseDto {

    private Long idMoto;
    private String nmChassi;
    private String placa;
    private String unidade;
    private String status;
    private String modelo;

    //fazer o Specification nessa classe
}
