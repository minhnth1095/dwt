package com.fpts.fitint.mapper.Payment;

import com.fpts.fitint.dto.Payment.PaymentRequest;
import com.fpts.fitint.dto.payment.PaymentAddParam;
import com.fpts.fitint.util.CommonUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentRequestConverter {
    public PaymentAddParam toAddParam(PaymentRequest request)
    {
        PaymentAddParam param = new PaymentAddParam();
        param.setPtransactionid(CommonUtils.randomStringId("NT"));
        param.setPbankgateway(request.getBankGateway());
        param.setPtranref(request.getTranRef());
        param.setPclientcode(request.getClientCode());
        param.setPclientname(request.getClientName());
        param.setPcashamt(request.getAmount());
        param.setPfptsacc(request.getFptsAcc());
        param.setPbankcode(request.getBankCode());
        param.setPbranch(request.getBranch());
        param.setPdescription(request.getDescription());
        param.setPstatus(request.getStatus());
        param.setPdomestic(request.getDomestic());
        param.setPcostcenter(request.getCostCenter());
        param.setPchannel(request.getChannel());
        param.setPtransdate(request.getTransDate());
        param.setPcreatedate(new Date());
        param.setPcreateby(request.getCreateBy());
        param.setPapproveby(request.getApproveBy());
        param.setPlongname(request.getLongName());
        param.setPrequestid(request.getRequestId());
        // các field default (-1, 0) đã set sẵn trong PaymentAddParam
        return param;
    }
}
