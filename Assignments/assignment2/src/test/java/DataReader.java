/**
 * Created by ugangha on 2/16/14.
 */
public class DataReader {
    private final In in;
    private final int size;

    public static class Site {
        private final int i;
        private final int j;
        private Site(int i, int j) {
            this.i = i;
            this.j =j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public DataReader(String url) {
        in = new In(url);
        size = in.readInt();
    }

    public int getSize() {
        return size;
    }

    public boolean hasNext() {
        return !in.isEmpty();
    }

    public Site next() {
        return new Site(in.readInt(), in.readInt());
    }
}
