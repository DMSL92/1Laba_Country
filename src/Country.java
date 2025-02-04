import java.text.DecimalFormat;
public class Country {

    //Атрибуты класса
    private String name; //название страны
    private double area;
    private double population;
    private String capitalName;
    private double capitalPopulation;

    //Конструктор принимающий все значения
    public Country(String name, double area, int population, String capitalName, int capitalPopulation) {
        setName(name);
        setArea(area);
        setPopulation(population);
        setCapital(capitalName, capitalPopulation);
    }

    //Конструктор принимающий города - государства (только название, площадь и население)
    public Country(String name, double area, int population) {
        this(name, area, population, "", 0);
    }

    //get методы
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getPopulation() {
        return population;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public double getCapitalPopulation() {
        return capitalPopulation;
    }

    //get метод для вычисления плотности населения страны
    public double getPopulationDensity() {
        if (area == 0) {
            throw new ArithmeticException("Площадь не может быть нулевой. ");
        }
        return population / area;
    }

    //set методы
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название страны не может быть пустым");
        }
        this.name = name;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь не может быть меньше или равна нулю");
        }
        this.area = area;
    }

    public void setPopulation(int population) {
        if (population <= 0) {
            throw new IllegalArgumentException("Население не может быть меньше или равно нулю");
        }
        this.population = population;
    }

    public void setCapital(String capitalName, int capitalPopulation) {
        if (capitalName != null && !capitalName.isEmpty()) {
            if (capitalPopulation <= 0) {
                throw new IllegalArgumentException("Население страны должно быть строго больше нуля.");
            }
            this.capitalName = capitalName;
            this.capitalPopulation = capitalPopulation;
        } else {
            this.capitalName = null;
            this.capitalPopulation = 0;
        }
    }

    // Метод для печати данных о стране
    public void print() {
        DecimalFormat df = new DecimalFormat("#,##0.#"); // Формат: показывает дробную часть только если она ≠ 0

        System.out.println("Страна: " + name);

        // Вывод площади с разными единицами измерения
        if (area >= 1000000) {
            System.out.println("Площадь: " + df.format(area / 1000000) + " млн кв. км");
        } else if (area >= 1000 && area < 1000000) {
            System.out.println("Площадь: " + df.format(area / 1000) + " тыс. кв. км");
        } else {
            System.out.println("Площадь: " + df.format(area) + " кв. км");
        }

        // Вывод населения с разными единицами измерения
        if (population >= 1000000) {
            System.out.println("Население: " + df.format(population / 1000000) + " млн чел.");
        } else if (population >= 1000 && population < 1000000) {
            System.out.println("Население: " + df.format(population / 1000) + " тыс. чел.");
        } else {
            System.out.println("Население: " + df.format(population) + " чел.");
        }

        // Вывод данных о столице
        if (capitalName != null && !capitalName.isEmpty()) {
            System.out.println("Столица: " + capitalName);

            // Вывод населения столицы с разными единицами измерения
            if (capitalPopulation >= 1000000) {
                System.out.println("Население столицы: " + df.format(capitalPopulation / 1000000) + " млн чел.");
            } else if (capitalPopulation >= 1000 && capitalPopulation < 1000000) {
                System.out.println("Население столицы: " + df.format(capitalPopulation / 1000) + " тыс. чел.");
            } else {
                System.out.println("Население столицы: " + df.format(capitalPopulation) + " чел.");
            }
        } else {
            System.out.println("Город-государство, или данные о столице отсутствуют.");
        }
    }

    // Статический метод для печати данных о нескольких странах
    public static void printAll(Country[] countries) {
        for (Country country : countries) {
            if (country != null) {
                country.print();
                System.out.println("-----------------------------");
            }
        }

    }
}
