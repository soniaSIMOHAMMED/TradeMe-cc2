package TradeMe.domain;

import TradeMe.kernel.ValueObjectID;

import java.util.Objects;

public final class Id implements ValueObjectID {

    private int value;

    public Id(int value) {
        this.value = value;
    }

    public static Id of(int value){
        return new Id(value);
    }

    public int getIntValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id memberId = (Id) o;
        return value == memberId.value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    public Id getIdValue(int id){
        return of(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}