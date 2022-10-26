package com.example.charity.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {

    @MockBean
    OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    UUID userId = UUID.randomUUID();
    OrderRequest orderRequest = new OrderRequest()
            .setUserId(userId)
            .setAmountToPay(BigDecimal.valueOf(5.00))
            .setSoldProducts(List.of());

    String content = """
            {userId: "%s", amountToPay: "5.00", soldProducts: "[]"}
            """.formatted(userId);
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();


    @Test
    void createOrder() throws Exception {
        params.add("userId", userId.toString());
        params.add("amountToPay", "5.00");
        params.add("soldProducts", List.of().toString());
        mockMvc.perform(put("/orders").params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(orderService).createOrder(orderRequest);
    }
}