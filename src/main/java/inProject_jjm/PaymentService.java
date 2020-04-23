package inProject_jjm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(name ="paymentSystems", url= "${api.url.valreservation}")
public interface PaymentService {
    @RequestMapping(method = RequestMethod.POST, value = "/paymentSystems", consumes = "application/json")
    void makePayment(PaymentSystem paymentSystem);

}
