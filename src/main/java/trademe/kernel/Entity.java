package trademe.kernel;

@SuppressWarnings("all")
public interface Entity<VOID extends ValueObjectID> {
    VOID id();
}
