package com.veilas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageDto {
    int pageNumber;
    int pageSize;
}
