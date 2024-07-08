public class Employee {
    private String fullname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    public Employee(String fullname, String position, String email, String phone, int salary, int age) {
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age  = age;
    }
    public void displayInfo() {
        System.out.println("Информация о сотруднике:");
        System.out.println("ФИО: " + fullname);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        }
    public static void main(String[] args) {
        Employee employee = new Employee("Иванов Иван Иванович", "Разработчик", "ivanov234@gmail.com","+375295142569", 125000, 32);
        employee.displayInfo();
    }
}

