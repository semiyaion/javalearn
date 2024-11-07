package h_generic.limit.upper_limit;

public class Limit {

    static class Test <T extends Number>{
        /*使得所有泛型类型只能是数字类型*/
        private T varcha;

        public Test() {
        }

        public Test(T varcha) {
            this.varcha = varcha;
        }

        public T getVarcha(T varcha) {
            return varcha;
        }

        public void setVarcha(T varcha) {
            this.varcha = varcha;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "varcha=" + varcha +
                    '}';
        }
    }




}
