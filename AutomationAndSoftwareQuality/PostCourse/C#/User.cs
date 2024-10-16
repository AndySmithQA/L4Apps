using System;

public class User
{
    public string UserName { get; private set; }
    public string Password { get; private set; }
    public Address Address { get; private set; }

    public User(string userName, string password, Address address)
    {
        if (Utils.isAlphabetic(userName))
            this.UserName = userName;
        else
            throw new ArgumentException();

        if (isValidPasswordFormat(password))
            this.Password = password;
        else
            throw new ArgumentException();
        this.Address = address;
    }

    private bool isValidPasswordFormat(string password)
    {
        return (password != null && password.Length > 8 && Utils.hasExtraPasswordChars(password));
    }
}
