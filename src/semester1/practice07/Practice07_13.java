package semester1.practice07;

public class Practice07_13 {
    public static void main(String[] args) {
        String sql = new QueryBuilder("users")
                .select("id, name, email")
                .where("age >= 18")
                .build();
        System.out.println(sql);
    }

    static class QueryBuilder {
        private String table;
        private String fields = "*";
        private String whereClause = "";

        public QueryBuilder(String table) {
            this.table = table;
        }

        public QueryBuilder select(String fields) {
            this.fields = fields;
            return this;
        }

        public QueryBuilder where(String condition) {
            this.whereClause = condition;
            return this;
        }

        public String build() {
            return "SELECT " + fields + " FROM " + table
                    + (whereClause.isEmpty() ? "" : " WHERE " + whereClause) + ";";
        }
    }
}
