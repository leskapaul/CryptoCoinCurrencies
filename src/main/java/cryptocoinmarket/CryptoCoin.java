package cryptocoinmarket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class CryptoCoin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String cryptoCoinName;
    private BigDecimal cryptoCoinPrice;
    private LocalDate createdDate;


    public CryptoCoin(){}

    public CryptoCoin(String cryptoCoinName, BigDecimal cryptoCoinPrice, LocalDate createdDate) {
        this.cryptoCoinName = cryptoCoinName;
        this.cryptoCoinPrice = cryptoCoinPrice;
        this.createdDate = createdDate;
    }

    public String getCryptoCoinName() {
        return cryptoCoinName;
    }

    public void setCryptoCoinName(String cryptoCoinName) {
        this.cryptoCoinName = cryptoCoinName;
    }

    public BigDecimal getCyrptoCoinPrice() {
        return cryptoCoinPrice;
    }

    public void setCyrptoCoinPrice(BigDecimal cyrptoCoinPrice) {
        this.cryptoCoinPrice = cyrptoCoinPrice;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public long getCoinId() {
        return id;
    }

}
