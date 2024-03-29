package com.sunday.jewelry.model.dto.sale;

import com.sunday.jewelry.model.enums.SalesChannel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SaleDto {

    private Long id;

    private String nameCustomer;

    private String description;

    private String phoneCustomer;

    private SalesChannel salesChannel;

    private List<SaleItemDto> saleItem;

    private Integer totalCost;

    private LocalDateTime dateTimePurchase;
}
