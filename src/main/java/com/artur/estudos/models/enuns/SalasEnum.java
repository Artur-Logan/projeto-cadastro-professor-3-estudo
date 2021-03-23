package com.artur.estudos.models.enuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SalasEnum {
    SALA_01(1),
    SALA_02(2),
    SALA_03(3),
    SALA_04(4),
    SALA_05(5),
    SALA_06(6),
    SALA_07(7),
    SALA_08(8),
    SALA_09(9),
    SALA_10(10);

    private final Integer codigoSala;
}
