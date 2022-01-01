package trademe.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public final class UsersDTO {
    public final List<UserDTO> users;

    public UsersDTO(List<UserDTO> users) {
        this.users = users;
    }

}