package lk.icbt.MegaCityCabSystem.bo;

import lk.icbt.MegaCityCabSystem.dto.PaymentDTO;

public interface PaymentBO {
    boolean makePayment (PaymentDTO paymentDTO);
    boolean changePayment(PaymentDTO paymentDTO);
}
