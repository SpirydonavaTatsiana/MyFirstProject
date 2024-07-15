class Animal {
    protected String name;
    protected int age;
    protected static int animalCount = 0;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        animalCount++;
    }
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
    public static int getAnimalCount() {
        return animalCount;
    }
}
class Dog extends Animal {
    private static int dogCount = 0;
    public Dog(String name, int age) {
        super(name, age);
        dogCount++;
    }
    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }
    public static int getDogCount() {
        return dogCount;
    }
}
class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;
    public Cat(String name, int age) {
        super(name, age);
        catCount++;
        this.isFull = false;
    }
    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
    public static int getCatCount() {
        return catCount;
    }
    public boolean isFull() {
        return isFull;
    }
    public void eat(Plate plate) {
        int foodNeeded = 5;
        if (plate.getFood() >= foodNeeded) {
            plate.decreaseFood(foodNeeded);
            isFull = true;
            System.out.println(name + " покушал и теперь сыт.");
        } else {
            System.out.println("Для " + name + "а" + " не хватает еды в тарелке.");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик", 5);
        Dog dog2 = new Dog("Шарик", 3);
        Cat cat1 = new Cat("Мурзик", 2);
        Cat cat2 = new Cat("Барсик", 4);
        dog1.run(150);
        dog1.swim(5);
        dog2.run(600);
        dog2.swim(15);
        cat1.run(150);
        cat1.swim(5);
        cat2.run(250);
        cat2.swim(5);
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        Cat[] cats = {cat1, cat2};
        Plate plate = new Plate(6);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }
        plate.info();
        plate.addFood(10); // Добавляем 10 единиц еды в тарелку
        plate.info();
    }
}