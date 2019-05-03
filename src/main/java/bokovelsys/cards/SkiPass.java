package bokovelsys.cards;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class SkiPass {
    protected int id;
    protected SkiPassType skiPassType;
    private boolean blocked;
    private LocalDateTime activationDate;
    protected Date expirationDate;

    public int getId() {
        return id;
    }

    public SkiPassType getSkiPassType() {
        return skiPassType;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public LocalDateTime getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDateTime activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}
