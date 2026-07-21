package com.fpts.fitint.controller;

import com.fpts.fitint.dto.Payment.PaymentRequest;
import com.fpts.fitint.entity.payment.Payment;
import com.fpts.fitint.mapper.PaymentMapper;
import com.fpts.fitint.service.Payment.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@Tag(name = "Payment", description = "API xử lý nộp tiền")
public class PaymentController {
    private final PaymentMapper paymentMapper;
    private final PaymentService paymentService;
    public PaymentController(PaymentMapper paymentMapper, PaymentService paymentService) {
        this.paymentMapper = paymentMapper;
        this.paymentService = paymentService;
    }

//    @Operation(summary = "Get all giao dịch nộp tiền")
//    @ApiResponse(responseCode = "200", description = "Thành công")
//    @ApiResponse(responseCode = "400", description = "Dữ liệu không hợp lệ")
//    @GetMapping
//    public List<Payment> getPayments(
//            @Parameter(description = "Số trang, bắt đầu từ 0") @RequestParam(defaultValue = "0") int page,
//            @Parameter(description = "Số bản ghi mỗi trang") @RequestParam(defaultValue = "20") int size) {
//
//        int offset = page * size;
//        return paymentMapper.getPayments(offset, size);
//    }

    @Operation(summary = "Lấy giao dịch theo số tài khoản")
    @GetMapping("/account/{clientCode}")
    public  List<Payment> getPaymentsByClientCode(
            @Parameter(description = "Số tài khảon") @PathVariable String clientCode) {
        return paymentMapper.getPaymentsByClientCode(clientCode);

    }

    @PostMapping
    public ResponseEntity<Void> createPayment(@Valid @RequestBody PaymentRequest payment) {
        paymentService.createPayment(payment);
        return ResponseEntity.ok().build();
    }
}
