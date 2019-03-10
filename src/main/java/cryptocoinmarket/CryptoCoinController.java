package cryptocoinmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/crypto-coins")
public class CryptoCoinController {

    private CryptoCoinRepository cryptoCoinRepository;

    @Autowired
    public CryptoCoinController(CryptoCoinRepository cryptoCoinRepository) {
        this.cryptoCoinRepository = cryptoCoinRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CryptoCoin> getAll() {
        return cryptoCoinRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{cyrptoCoinPrice}", method = RequestMethod.GET)
    public List<CryptoCoin> getAffordable(@PathVariable BigDecimal cyrptoCoinPrice) {
        return cryptoCoinRepository.findByCryptoCoinPriceLessThan(cyrptoCoinPrice);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<CryptoCoin> create(@RequestBody CryptoCoin cryptoCoin) {
        cryptoCoinRepository.save(cryptoCoin);
        return cryptoCoinRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<CryptoCoin> remove(@PathVariable long id) {
        cryptoCoinRepository.deleteById(id);

        return cryptoCoinRepository.findAll();
    }
}
