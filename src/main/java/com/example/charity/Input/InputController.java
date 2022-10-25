package com.example.charity.Input;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class InputController {
    @Resource
    InputService inputService;

    @GetMapping("update-quantities")
    @Operation(summary = "Update goods quantities from file")
    public void updateGoodsQuantity() throws IOException {
        inputService.updateGoodsQuantity();
    }
}
