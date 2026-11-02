class Test {
    public static StringBuilder method() {
        StringBuilder sb = new StringBuilder("Hello");
        try {
            return sb;
        } finally {
            sb.append(" World");
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}