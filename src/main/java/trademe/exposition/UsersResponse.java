package trademe.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public final class UsersResponse {
    public final List<UserDTO> users;
    public UsersResponse(List<UserDTO> users) {
        this.users = users;
    }
}