public class Person
{
    private String name = "John Doe";
    private int age = 0;

    void display()
    {
        System.out.println("Name is: "+name+"\nAge is: "+age);
    }

    void birthDay()
    {
        age++;
    }

    void changeName(String newName)
    {
        name = newName;
    }

}