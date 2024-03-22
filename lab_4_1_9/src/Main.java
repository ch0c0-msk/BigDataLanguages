public class Main {
    public static void main(String[] args) {
        Park park = new Park();
        park.addAttraction("Roller Coaster", "10:00 AM - 8:00 PM", 25.0);
        park.addAttraction("Ferris Wheel", "11:00 AM - 9:00 PM", 15.0);

        System.out.println("Park Attractions Information:");
        for (Park.Attraction attraction : park.getAttractions()) {
            System.out.println(attraction);
        }
    }
}