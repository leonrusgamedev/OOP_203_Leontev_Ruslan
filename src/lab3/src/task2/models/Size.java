package lab3.src.task2.models;

public enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;

    // Конструктор для присвоения euroSize
    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    // Метод для получения описания
    public String getDescription() {
        return "Взрослый размер";
    }

    // Метод для получения евро размера
    public int getEuroSize() {
        return euroSize;
    }
}
