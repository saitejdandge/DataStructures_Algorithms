package graphs.utils;

public class Edge {
    public String src, dest;
   public double distance;

    public Edge(String src, String dest, double distance) {
        this.src = src;
        this.dest = dest;
        this.distance = distance;
    }
}