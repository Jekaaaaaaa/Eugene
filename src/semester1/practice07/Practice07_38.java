package semester1.practice07;

public class Practice07_38 {
    public static void main(String[] args) {
        Product notebook = new Product(1, "Зошит", 45.0);
        Product pen = new Product(2, "Ручка", 30.0);
        Order first = new Order(new Customer("Олена", 100.0), 3);
        first.addProduct(notebook);
        first.addProduct(pen);
        first.checkout();

        Order second = new Order(new Customer("Андрій", 50.0), 3);
        second.addProduct(notebook);
        second.addProduct(pen);
        second.checkout();
    }

    static class Product {
        private int id;
        private String title;
        private double price;

        public Product(int id, String title, double price) {
            this.id = id;
            this.title = title;
            this.price = price;
        }
    }

    static class Customer {
        private String name;
        private double walletBalance;

        public Customer(String name, double walletBalance) {
            this.name = name;
            this.walletBalance = walletBalance;
        }

        public boolean pay(double amount) {
            if (!(amount >= 0.0 && amount <= walletBalance) || !Double.isFinite(amount)) {
                return false;
            }
            walletBalance -= amount;
            return true;
        }
    }

    static class Order {
        private Customer customer;
        private Product[] items;
        private int itemCount;
        private boolean paid;

        public Order(Customer customer, int maxItems) {
            this.customer = customer;
            this.items = new Product[maxItems];
        }

        public void addProduct(Product p) {
            if (!paid && p != null && itemCount < items.length) {
                items[itemCount++] = p;
            }
        }

        public double calculateTotal() {
            double total = 0.0;
            for (int i = 0; i < itemCount; i++) {
                total += items[i].price;
            }
            return total;
        }

        public boolean checkout() {
            if (paid) {
                return true;
            }
            double total = calculateTotal();
            if (!this.customer.pay(total)) {
                System.out.println(customer.name + ": недостатньо коштів.");
                return false;
            }
            paid = true;
            System.out.println("Чек для " + customer.name);
            for (int i = 0; i < itemCount; i++) {
                Product product = items[i];
                System.out.println("#" + product.id + " " + product.title + " — " + product.price + " грн");
            }
            System.out.println("До сплати: " + total + " грн");
            return true;
        }
    }
}
