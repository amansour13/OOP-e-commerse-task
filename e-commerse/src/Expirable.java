import java.time.LocalDate;

public class Expirable {
    private LocalDate expiryDate;

    public Expirable(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
