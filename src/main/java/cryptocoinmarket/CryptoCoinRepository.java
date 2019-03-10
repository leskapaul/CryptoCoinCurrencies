package cryptocoinmarket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CryptoCoinRepository extends JpaRepository<CryptoCoin, Long> {
    List<CryptoCoin> findByCryptoCoinPriceLessThan(BigDecimal cryptoCoinPrice);
}
