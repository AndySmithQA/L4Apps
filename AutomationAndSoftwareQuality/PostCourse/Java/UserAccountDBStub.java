package qa;

import java.util.ArrayList;

public class UserAccountDBStub implements IUserAccountDb {

	// Database in memory
    ArrayList<String> cities;
    ArrayList<User> users;

    public UserAccountDBStub() throws IllegalArgumentException
    {
    	users = new ArrayList<>();
    	cities = new ArrayList<>();
        // Seed the database in memory (cities and users Lists)
    }

    public ArrayList<String> getCityNames()
    {
        return cities;
    }

    public boolean isAnExistingUser(User user)
    {
        // Write code to see if username exists in the users List
        return false;
    }

    public boolean isRegisteredUser(User user)
    {
        // Write code to see if username & password exists in the users List    
        return false;

    }

    public boolean register(User user)
    {
        if (isAnExistingUser(user))
            return false;

        // Add the user to the database in memory
        return true;
    }
}
