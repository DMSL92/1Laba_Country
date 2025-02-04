//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Country russia =  new Country("Россия", 17100000, 146700000, "Москва", 12600000 );
        Country finland = new Country("Финляндия", 338000, 55000000, "Хелсинки", 665000);
        Country france = new Country("Франция", 643800, 67800000, "Париж", 2100000);
        Country andora = new Country("Андора", 467000, 85400, "Андора Ла Велла",  22600 );
        Country singapore = new Country("Сингапур", 725, 5700000);

        Country[] countries = {russia, finland, france, andora, singapore};
        Country.printAll(countries);

        System.out.println("Плотность населения в " + russia.getName() + ": " + russia.getPopulationDensity() + " чел./кв. км.");


    }
}