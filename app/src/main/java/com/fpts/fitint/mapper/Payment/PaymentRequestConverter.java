package com.fpts.fitint.mapper.Payment;

import com.fpts.fitint.dto.Payment.PaymentRequest;
import com.fpts.fitint.dto.payment.PaymentAddParam;
import com.fpts.fitint.util.CommonUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class PaymentRequestConverter {
    public PaymentAddParam toAddParam(PaymentRequest request)
    {
        PaymentAddParam param = new PaymentAddParam();
        param.setPtransactionid(CommonUtils.randomStringId("NT"));
        param.setPbankgateway(request.getBankGateway());
        param.setPtranref(request.getTransRef());
        param.setPclientcode(request.getClientCode());
        param.setPclientname(request.getClientName());
        param.setPcashamt(request.getCashAmount());
        param.setPfptsacc(request.getFptsAccNum());
        param.setPbankcode(request.getBankCode());
        param.setPdescription(request.getDescription());
        param.setPstatus(0);
        param.setPdomestic(request.getDomestic().getCode());
        param.setPcostcenter(request.getCostCenter().getCode());
        param.setPchannel(request.getChannel().getCode());
        param.setPtransdate(request.getTransDate());
        param.setPcreatedate(LocalDateTime.now());
        param.setPcreateby(request.getCreatedBy());
        param.setPlongname(request.getLongName());
        param.setPrequestid(request.getRequestId());
        // các field default (-1, 0) đã set sẵn trong PaymentAddParam
        return param;
    }
}
