package semester1.practice09;

public class Practice09_21 {
    public static void main(String[] args) {
        DataCenterCluster cluster = new DataCenterCluster("Київ", 3);
        cluster.addNode(new ServerNode("192.0.2.1", 8, 0, false));
        cluster.addNode(new ServerNode("192.0.2.2", 16, 4, true));
        cluster.addNode(new ServerNode("192.0.2.3", 32, 24, true));
        System.out.println(cluster);
        System.out.println("Контейнер 10 ГБ: " + cluster.deployContainer(10));
        System.out.println("Контейнер 20 ГБ: " + cluster.deployContainer(20));
    }

    static class ServerNode {
        private final String ipAddress;
        private final int totalRamGb;
        private int usedRamGb;
        private boolean online;

        public ServerNode(String ipAddress, int totalRamGb, int usedRamGb, boolean online) {
            this.ipAddress = ipAddress;
            this.totalRamGb = totalRamGb;
            this.usedRamGb = usedRamGb;
            this.online = online;
        }

        public int getFreeRamGb() {
            return totalRamGb - usedRamGb;
        }

        public boolean allocateRam(int requiredRamGb) {
            if (!online || requiredRamGb <= 0 || requiredRamGb > getFreeRamGb()) {
                return false;
            }
            usedRamGb += requiredRamGb;
            return true;
        }

        @Override
        public String toString() {
            return ipAddress;
        }
    }

    static class DataCenterCluster {
        private final String clusterLocation;
        private final ServerNode[] nodes;
        private int nodeCount;

        public DataCenterCluster(String clusterLocation, int capacity) {
            this.clusterLocation = clusterLocation;
            this.nodes = new ServerNode[capacity];
        }

        public void addNode(ServerNode node) {
            if (node != null && nodeCount < nodes.length) {
                nodes[nodeCount++] = node;
            }
        }

        public boolean deployContainer(int requiredRamGb) {
            for (int i = 0; i < nodeCount; i++) {
                if (nodes[i].allocateRam(requiredRamGb)) {
                    System.out.println("Розміщено на вузлі " + nodes[i]);
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return clusterLocation + ", вузлів: " + nodeCount;
        }
    }
}
