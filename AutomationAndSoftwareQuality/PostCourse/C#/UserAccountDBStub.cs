using System;
using System.Collections.Generic;

public class UserAccountDBStub : IUserAccountDb
{
    // Database in memory
    List<string> cities;
    List<User> users;

    public UserAccountDBStub()
    {
        cities = new List<string>();
        users = new List<User>();
        // Seed the database in memory (cities and users Lists)
    }

    public List<string> getCityNames()
    {
        return cities;
    }

    public bool isAnExistingUser(User user)
    {
        // Write code to see if username exists in the users List
        return false;
    }

    public bool isRegisteredUser(User user)
    {
        // Write code to see if username & password exists in the users List    
        return false;

    }

    public bool register(User user)
    {
        if (isAnExistingUser(user))
            return false;

        // Add the user to the database in memory
        return true;
    }
}

