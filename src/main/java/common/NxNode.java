package common;

import java.io.Serializable;
import java.util.List;

public class NxNode implements Serializable {

    public int val;

    public List<NxNode> children;

    public NxNode() {}

    public NxNode(int _val) {
        val = _val;
    }

    public NxNode(int _val, List<NxNode> _children) {
        val = _val;
        children = _children;
    }
}
