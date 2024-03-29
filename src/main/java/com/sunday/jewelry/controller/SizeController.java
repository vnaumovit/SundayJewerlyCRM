package com.sunday.jewelry.controller;

import com.sunday.jewelry.mapper.SizeMapper;
import com.sunday.jewelry.model.Size;
import com.sunday.jewelry.model.dto.SizeDto;
import com.sunday.jewelry.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sizes")
public class SizeController {

    private final SizeMapper sizeMapper;
    private final SizeRepository sizeRepository;

    @GetMapping("/getByItemId/{itemId}")
    @Transactional
    public ResponseEntity<List<SizeDto>> getSizesByItemId(@PathVariable UUID itemId) {
        List<Size> sizes = sizeRepository.findByItemId(itemId);
        List<SizeDto> sizeDtos = sizeMapper.toDtos(sizes);
        return new ResponseEntity<>(sizeDtos, HttpStatus.OK);
    }
}
