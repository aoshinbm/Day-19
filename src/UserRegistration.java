import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static void main(String args[]){

        ArrayList<String> emails = new ArrayList<String>();
        emails.add("abc@yahoo.com");
        emails.add("abc-100@yahoo.com");
        emails.add("abc.100@yahoo.com");
        emails.add("abc111@abc.com");
        emails.add("abc-100@abc.net");
        emails.add("abc.100@abc.com.au");
        emails.add("abc@1.com");
        emails.add("abc@gmail.com.com");
        emails.add("abc+100@gmail.com");

        //Add invalid emails in list
        //3. abc123@gmail.a – “.a” is not a valid tld, last tld must contains at least two
        //4. abc123@.com – tld can not start with dot “.”
        //5. abc123@.com.com – tld can not start with dot “.”
        //6. .abc@abc.com – email’s 1st character can not start with “.”
        //7. abc()*@gmail.com – email’s is only allow character, digit, underscore and dash
        //8. abc@%*.com – email’s tld is only allow character and digit
        //9. abc..2002@gmail.com – double dots “.” are not allow
        //10. abc.@gmail.com – email’s last character can not end with dot “.”
        //11. abc@abc@gmail.com – double “@” is not allow
        //12. abc@gmail.com.1a -email’s tld which has two characters can not contains digit
        //13. abc@gmail.com.aa.au - cannont have multiple email’s tld

//        emails.add("abc@.com.my");
        emails.add("javaTpoint#domain.com");

        //Regular Expression
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);

        //Iterate emails array list
        for(String email : emails){
            //Create instance of matcher
            Matcher matcher = pattern.matcher(email);
            System.out.println(email +" : "+ matcher.matches()+"\n");
        }
    }
}