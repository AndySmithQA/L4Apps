using System.Linq;
using System.Text.RegularExpressions;

public class Utils
{
    public static bool isAlphabetic(string input)
    {
        return input.All(c => char.IsLetter(c));
    }

    public static bool hasIllegalChars(string input)
    {
        string badChars = " \t\n\r[]<>~;'@";
        return input.Any(c => badChars.Contains(c));
    }

    public static bool hasOneDigit(string input)
    {
        return input.Any(c => char.IsDigit(c));
    }

    public static bool hasExtraPasswordChars(string input)
    {
        string extraChars = "$£%@?";
        return input.Any(c => extraChars.Contains(c));
    }
    public static bool isValidUKPostCode(string postCode)
    {
        string regXstring = "^([A-Z]{1,2})([0-9][0-9A-Z]?) ([0-9])([ABDEFGHJLNPQRSTUWXYZ]{2})$";
        return Regex.Match(postCode.Trim(), regXstring).Success;
    }
    public static bool isValidHouseNumber(string houseNumber)
    {
        string regXstring = "^[0-9]+(-[0-9]+)+$";
        return Regex.Match(houseNumber, regXstring).Success;
    }
}
