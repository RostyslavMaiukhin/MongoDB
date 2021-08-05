import dao.userDao;
import entity.User;

public class Main {
    public static void main(String[] args) {
        userDao userDao = new userDao();

        User user1 = new User("Bill", "Kek", 33, "homeless", "Detroit");
        User user2 = new User("Chip", "Munk", 40, "Evilcorp", "Chicago");
        User user2_sameCity = new User("ChipBrother", "Munk", 30, "Goodcorp", "Chicago");
        User user3 = new User("Forrest", "Green", 120, "Tomb", "Cemetery");

        userDao.createData(user1, user2, user2_sameCity, user3);

        userDao.findUserByName("Chip");
        userDao.findUserByAge(50);
        userDao.findUserByCity("Chicago");

    }
}