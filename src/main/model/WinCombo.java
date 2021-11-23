package model;

import java.util.ArrayList;
import java.util.List;

// Represents combinations of positions that result in a win
public enum WinCombo {
    TOPROW (0,1,2), MIDROW (3,4,5), BOTTOMROW (6,7,8), LEFTCOL (0,3,6), MIDCOL (1,4,7), RIGHTCOL (2,5,8),
    BACKDIAGONAL(0,4,8), FORWARDIAGONAL (2,4,6);

    private List<Integer> positions;

    WinCombo(int i1, int i2, int i3) {
        positions = new ArrayList<>();
        positions.add(i1);
        positions.add(i2);
        positions.add(i3);
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
