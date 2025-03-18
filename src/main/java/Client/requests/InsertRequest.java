package Client.requests;

import extra.collectionElements.Vehicle;

public class InsertRequest extends Request {
    public InsertRequest(Vehicle vehicle, Object[] args) {
        super("insert", args, 1, true);
    }

    public InsertRequest() {
        super("insert", 1, true);
    }
}
