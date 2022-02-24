public class Driver
{
    public static void main(String[] args)
    {
        Person employee1 = new Person();
        Person employee2 = new Person();
        String actualName1 = "Goldlewis Dickinson";
        String actualName2 = "Sol Badguy";

        for (int i = 0 ; i<56 ; i++)
        {
            employee1.birthDay();
        }

        for (int i = 0 ; i<35 ; i++)
        {
            employee2.birthDay();
        }
        
        employee1.changeName(actualName1);
        employee2.changeName(actualName2);
        employee1.display();
        employee2.display();
    }
}