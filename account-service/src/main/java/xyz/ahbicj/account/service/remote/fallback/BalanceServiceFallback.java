package xyz.ahbicj.account.service.remote.fallback;

import org.springframework.stereotype.Component;
import xyz.ahbicj.account.entity.Balance;
import xyz.ahbicj.account.service.remote.BalanceService;

@Component
public class BalanceServiceFallback implements BalanceService {
    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");
    }

}
