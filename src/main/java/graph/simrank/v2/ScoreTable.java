package graph.simrank.v2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ScoreTable extends HashMap<String, Float> {

    public ScoreTable() {
        super();
    }


    public String toString(int sizeCol) {
        Set entrySet = this.entrySet();
        Iterator it = entrySet.iterator();
        int i = 0;
        String str = "";
        while (it.hasNext()) {
            if (i == sizeCol) {
                i = 0;
                str += "\n";
            }
            Entry me = (Entry) it.next();
            String troncato = String.format("%.3f", me.getValue());
            str += "\t" + me.getKey() + ": " + troncato + "\t";
            i++;
        }
        return str;
    }
}
