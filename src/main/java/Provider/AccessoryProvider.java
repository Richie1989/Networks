package Provider;

import Constant.Constant;
import model.Accessory;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Onyebuchi Iheuwadinachi Eleazu
 */

@Service
public class AccessoryProvider {
    public List<Accessory> getAccessories(String username) {
        List<Accessory> accessories = new ArrayList<>();
        for (Accessory accessory : Constant.accessories) {
            if (accessory == null) {
                continue;
            }
            if (username.equals("admin")) {
                accessories.add(accessory);
            } else {
                if (accessory.getUsername().equals(username)) {
                    accessories.add(accessory);
                }
            }

        }
        return accessories;
    }

    public void removeAccessory(int id) {
        Constant.accessories.set(id, null);
    }

    public void newAccessory(String name, int stock, int price, String category, String description, String username) {
        int id = Constant.accessories.size();
        Constant.accessories.add(new Accessory(id, name, stock, price, category, description, username));
    }
}