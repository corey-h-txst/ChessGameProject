package UtilityClasses;

public class Position {
    public int row;
    public int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    // Overrides default "==" with custom definition to avoid bugs
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Position other = (Position) obj;
        return this.row == other.row && this.col == other.col;
    }

}
