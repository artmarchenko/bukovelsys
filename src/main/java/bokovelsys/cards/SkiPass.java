package bokovelsys.cards;

import java.util.Date;

public abstract class SkiPass {
    protected int id;
    protected SkiPassType skiPassType;
    private boolean blocked;
    private Date activationDate;
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

    public Date getActivationDate() {
        return activationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }
}
