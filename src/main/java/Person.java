public class Person {
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Иванов Иван", "Менеджер", "ivanov@mail.com", "+7 (123) 456-7890", 50000, 41);
        employee[1] = new Employee("Петров Петр", "Разработчик", "petrov@mail.com", "+7 (987) 654-3210", 70000, 25);
        employee[2] = new Employee("Сидоров Алексей", "Тестировщик", "sidorov@mail.com", "+7 (111) 222-3333", 60000, 28);
        employee[3] = new Employee("Козлова Мария", "Дизайнер", "kozlova@mail.com", "+7 (333) 444-5555", 55000, 47);
        employee[4] = new Employee("Николаев Владимир", "Аналитик", "nikolaev@mail.com", "+7 (555) 666-7777", 75000, 32);
    }
        String fullname;
        String position;
        String email;
        String phone;
        String salary;
        String age;
        for (Employee employee : employee) {
            if (employee.getAge() > 40) {
                System.out.println("Информация о сотруднике:");
                System.out.println("ФИО: " + fullname);
                System.out.println("Должность: " + position);
                System.out.println("Email: " + email);
                System.out.println("Телефон: " + phone);
                System.out.println("Зарплата: " + salary);
                System.out.println("Возраст: " + age);
            }
        }
    }
}
