package playersguide.TheFountainOfObjects;

public enum FieldData {
    SMALL(4, 1, 1, 1),
    MEDIUM(6, 2, 1, 2),
    LARGE(8, 4, 2, 3);

    FieldData(int sizeOfSides, int nrOfPits, int nrOfMaelstroms, int nrOfAmaroks) {
        SIZE_OF_SIDES = sizeOfSides;
        NR_OF_PITS = nrOfPits;
        NR_OF_MAELSTROMS = nrOfMaelstroms;
        NR_OF_AMAROKS = nrOfAmaroks;
    }

    private final int SIZE_OF_SIDES;
    private final int NR_OF_PITS;
    private final int NR_OF_MAELSTROMS;
    private final int NR_OF_AMAROKS;

    public int getSizeOfSides() {
        return SIZE_OF_SIDES;
    }

    public int getNrOfPits() {
        return NR_OF_PITS;
    }

    public int getNrOfMaelstroms() {
        return NR_OF_MAELSTROMS;
    }

    public int getNrOfAmaroks() {
        return NR_OF_AMAROKS;
    }

}
