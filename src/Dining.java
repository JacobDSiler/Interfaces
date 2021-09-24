public class Dining implements Expense {

    Destination _dest;
    int _totalNights;

    public Dining(Destination dest, int nights){
        _dest = dest;
        _totalNights = nights;
    }

    public float getCost() {
        switch(_dest) {
            case Mexico:
                return 10.00f * _totalNights;
            case Europe:
                return 20.00f * _totalNights;
            case Japan:
                return 30.00f * _totalNights;
            default:
                return 0.0f;
        }
    }
}
