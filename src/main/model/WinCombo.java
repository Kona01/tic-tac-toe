package model;

import java.util.ArrayList;
import java.util.List;

// Represents combinations of positions that result in a win
public enum WinCombo {
    TOP_ROW (0,1,2), MID_ROW (3,4,5), BOTTOM_ROW (6,7,8), LEFT_COL (0,3,6), MID_COL (1,4,7), RIGHT_COL (2,5,8),
    BACK_DIAGONAL(0,4,8), FORWARD_DIAGONAL (2,4,6);

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
