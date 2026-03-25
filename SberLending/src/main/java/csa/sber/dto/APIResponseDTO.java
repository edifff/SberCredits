package csa.sber.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class APIResponseDTO<T> {
    private boolean success;
    private T data;
}
