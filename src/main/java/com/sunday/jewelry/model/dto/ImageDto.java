package com.sunday.jewelry.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ImageDto {
    private Long id;
    private String url;
    private String name;
    private byte[] picture;
    private Boolean isMain = false;
    private UUID itemId;
}
