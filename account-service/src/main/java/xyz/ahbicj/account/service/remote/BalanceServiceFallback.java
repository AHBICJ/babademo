package xyz.ahbicj.account.service.remote;

import org.springframework.stereotype.Component;
import xyz.ahbicj.account.entity.Balance;

@Component
public class BalanceServiceFallback implements BalanceService {
    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");
    }

}
