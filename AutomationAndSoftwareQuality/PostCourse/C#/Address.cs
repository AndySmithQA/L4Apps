using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class Address
{
    IUserAccountDb userAccountDb;
    public string number { get; set; }
    public string addressLine { get; set; }
    public string postCode { get; set; }
    public string city { get; set; }

    public Address(string number, string addressLine, string postCode, string city, IUserAccountDb userAccountDb)
    {
        this.userAccountDb = userAccountDb;
        this.number = number;
        this.addressLine = addressLine;
        if (isValidCity(city))
            this.city = city;
        else
            throw new ArgumentException();

        if (Utils.isValidUKPostCode(postCode))
            this.postCode = postCode;
        else
            throw new ArgumentException();
    }
    public bool isValidCity(string city)
    {
        return userAccountDb.getCityNames().Contains(city);
    }
}

