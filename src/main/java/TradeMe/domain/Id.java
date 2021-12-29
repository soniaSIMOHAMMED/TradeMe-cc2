package TradeMe.domain;

import TradeMe.kernel.ValueObjectID;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Id {

    private int value;

    public Id(int value) {
        this.value = value;
    }

    public static Id of(int value){
        return new Id(value);
    }

    public int getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id userId = (Id) o;
        return value == userId.value;
    }


    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Id{" +
                "value=" + value +
                '}';
    }

}