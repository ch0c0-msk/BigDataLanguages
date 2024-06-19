public class Computer {
    public class Specs {
        private String os;
        private String processor;
        private int ram;

        public Specs(String os, String processor, int ram) {
            this.os = os;
            this.processor = processor;
            this.ram = ram;
        }

        public String getOS() {
            return os;
        }

        public void setOS(String os) {
            this.os = os;
        }

        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public int getRAM() {
            return ram;
        }

        public void setRAM(int ram) {
            this.ram = ram;
        }

        @Override
        public String toString() {
            return "OS: " + os + ", Processor: " + processor + ", RAM: " + ram + "GB";
        }
    }
    private Specs specs;
    public Computer(String os, String processor, int ram) {
        this.specs = new Specs(os, processor, ram);
    }
    public Specs getSpecs() {
        return specs;
    }
}
