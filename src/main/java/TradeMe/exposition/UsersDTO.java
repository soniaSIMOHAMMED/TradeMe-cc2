package TradeMe.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public class UsersDTO {
    public final List<UserDTO> users;

    public UsersDTO(List<UserDTO> users) {
        this.users = users;
    }

}