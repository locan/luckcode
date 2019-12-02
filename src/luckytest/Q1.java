package luckytest;

import java.util.*;

public class Q1 {

    public boolean findPath(List path, Vertice pos, Vertice begin) {
        if (pos.in == 0 || pos.out == 0) {
            return false;
        }
        if (begin.equals(pos) && !path.isEmpty()) {
            path.add(pos);
            return true;
        }
        path.add(pos);
        for (int i = 0; i < pos.nextVertice.size(); i++) {
            Vertice next = pos.nextVertice.get(i);

            boolean ret = findPath(path, next, begin);
            if (!ret) {
                path.remove(next);
                continue;
            } else {
                return ret;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());
        HashMap<Integer, Vertice> vmap = new HashMap<>();
        HashMap<Vertice, Integer> vinmap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(scanner.next());
            int b = Integer.parseInt(scanner.next());
            if (!vmap.containsKey(a)) {
                vmap.put(a, new Vertice(a));
            }
            if (!vmap.containsKey(b)) {
                vmap.put(b, new Vertice(b));
            }
            vmap.get(a).addEdge(vmap.get(b));
            vinmap.put(vmap.get(b), vmap.get(b).in);
        }
        ArrayList<Vertice> path = new ArrayList<>();
        for (int num : vmap.keySet()) {
            if (vinmap.containsKey(vmap.get(num))) {
                Vertice v = vmap.get(num);
                boolean ret = q.findPath(path, v, v);
                if (ret) {
                    for (int i = 0; i< path.size();i++)
                        System.out.print(path.get(i).id + " ");
                    return;
                }
            }

        }
        System.out.println(0);
    }
}

class Vertice {
    public int id;
    public int in;
    public int out;
    public ArrayList<Vertice> nextVertice;

    public Vertice(int id) {
        this.id = id;
        this.in = 0;
        this.out = 0;
        nextVertice = new ArrayList<>();
    }

    public Edge addEdge(Vertice v) {
        this.out += 1;
        v.in += 1;
        return new Edge(this, v);
    }
}

class Edge {
    public Vertice u;
    public Vertice v;

    public Edge(Vertice u, Vertice v) {
        u.nextVertice.add(v);
        this.u = u;
        this.v = v;

    }
}