using System;
using System.Collections.Generic;

public interface IUserAccountDb
{
    List<string> getCityNames();

    bool register(User user);

    bool isRegisteredUser(User user);

    bool isAnExistingUser(User user);
}

/// <summary>
/// Uses the actual database or a stub/mock database to login or register a user
/// </summary>
public class UserAccountManager
{
    IUserAccountDb userAccountDb;

    public UserAccountManager(IUserAccountDb userAccountDb)
    {
        this.userAccountDb = userAccountDb;
    }

    /// <summary>
    /// Logs user in. The username and password format has already been validated
    /// </summary>
    public bool login(User user)
    {
        //if number of tries to login is > 3    
        //      throw an exception

        if (!userAccountDb.isRegisteredUser(user))
            throw new ArgumentException();

        return userAccountDb.register(user);
    }

    public bool register(User user)
    {
        if (userAccountDb.isRegisteredUser(user))
            throw new ArgumentException();

        userAccountDb.register(user);

        return true;
    }
}
