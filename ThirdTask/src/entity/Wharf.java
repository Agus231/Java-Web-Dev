package entity;

public class Wharf {
    private boolean isUsable;

    public Wharf(){
        isUsable = true;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }
}
