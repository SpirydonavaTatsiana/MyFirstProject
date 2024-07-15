class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public int getFood() {
        return food;
    }
    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        } else {
            System.out.println("Недостаточно еды в тарелке.");
        }
    }
    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды в тарелку.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }
    public void info() {
        System.out.println("В тарелке осталось " + food + " еды.");
    }
}

