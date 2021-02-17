package xyz.ahbicj.account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.ahbicj.account.entity.Balance;
import xyz.ahbicj.account.entity.User;
import xyz.ahbicj.account.service.remote.BalanceService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    final static Map<Integer, User> userMap = new HashMap() {
        {
            put(1, new User(1, "张三"));
            put(2, new User(2, "李四"));
            put(3, new User(3, "王五"));
        }
    };

    @Resource
    private BalanceService balanceService;

    @RequestMapping("/acc/user")
    public User getUser(@RequestParam Integer id) {
        if (id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
            Balance balance = balanceService.getBalance(id);
            user.setBalance(balance);
            return user;
        }
        return new User(0, "");
    }
}
