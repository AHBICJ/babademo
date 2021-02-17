package xyz.ahbicj.account.service.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.ahbicj.account.entity.Balance;
import xyz.ahbicj.account.service.remote.fallback.BalanceServiceFallback;

@FeignClient(name = "payment-service", fallback = BalanceServiceFallback.class)
public interface BalanceService {
    @RequestMapping(value = "/pay/balance", method = RequestMethod.GET)
    Balance getBalance(@RequestParam("id") Integer id);
}
