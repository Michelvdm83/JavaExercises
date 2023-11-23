package VPP.SwapTwoNumbersUsingAMethodOnAnObject;

class Pair {
    private int first;
    private int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public void swap(){
        int temp = first;
        first = second;
        second = temp;
    }
    public int getFirst(){
        return first;
    }
    public int getSecond(){
        return second;
    }
    public void setFirst(int first) {
        this.first = first;
    }
    public void setSecond(int second) {
        this.second = second;
    }

}
