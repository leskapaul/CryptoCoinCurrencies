package cryptocoinmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private CryptoCoinRepository cryptoCoinRepository;

    @Autowired
    public DatabaseSeeder(CryptoCoinRepository cryptoCoinRepository) {
        this.cryptoCoinRepository = cryptoCoinRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<CryptoCoin> cryptoCoins = new ArrayList<>();

        cryptoCoins.add(new CryptoCoin("Bitcoin", BigDecimal.valueOf(22.25), LocalDate.now()));
        cryptoCoins.add(new CryptoCoin("LiteCoin", BigDecimal.valueOf(48.71), LocalDate.now()));
        cryptoCoins.add(new CryptoCoin("Ethereum", BigDecimal.valueOf(77.84), LocalDate.now()));


        cryptoCoinRepository.saveAll(cryptoCoins);
    }
}
